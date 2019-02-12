package ai.promethean.GraphManagement;

import ai.promethean.DataModel.*;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GraphManager {

    private PriorityQueue<StateTemplate> frontier;
    private static SystemState initState;
    private static SystemState goalState;
    private static TaskDictionary taskDict;

    public GraphManager() {

    }

    private static ArrayList<Task> validTasks(SystemState state, TaskDictionary taskDictionary){
        ResourceMap resources = state.getResources();
        PropertyMap properties = state.getProperties();
        // For keeping track of valid tasks
        ArrayList<Task> valid_tasks = new ArrayList<>();
        for(int i=0; i < taskDictionary.size(); i++) {
            boolean possible_task = false;
            Task current_task = taskDictionary.getTask(i);
            ArrayList<Condition> requirements = current_task.getRequirements();
            // I love IntelliJ
            for(Condition condition: requirements) {
                String name = condition.getName();
                double value = condition.getValue();
                double resource_value = resources.getValue(name);
                // ISSUE: condition.evaluate only does Doubles, extending props/res will break this
                if(condition.evaluate(resource_value)) {
                    possible_task = true;
                } else {
                    possible_task = false;
                }
            }
            // If all conditions are satisfied, then add this task to the valid_tasks array
            if(possible_task) {
                valid_tasks.add(current_task);
            }

        }

        return valid_tasks;
    }

    private static ArrayList<StateTemplate> templateGeneration(SystemState state, ArrayList<Task> tasks){
        // TODO: Create templates for every task
        return null;
    }

    public static void addNeighbors(SystemState state) {
        // *** This can be changed to not include taskDict as argument if implementation changes in future ***
        ArrayList<Task> tasks = validTasks(state, taskDict);
        ArrayList<StateTemplate> templates = templateGeneration(state, tasks);
        // TODO: Enqueue to frontier
    }

    private static SystemState createState(SystemState previousState, Task task) {
        // TODO: Build and return a new SystemState object
        return null;
    }

    public static SystemState poll() {
        // TODO: Dequeue best template from frontier or Null if frontier is empty
        // TODO: return createState(template.previousState, template.task)
        return null;
    }

}