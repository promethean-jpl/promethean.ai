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
        // For now let's I'll assume the taskDictionary has to be passed as argument
        // TODO: Find all tasks that can be executed from state (is TaskDictionary global?)
        ArrayList<Task> valid_tasks = new ArrayList<>();
        ArrayList<Resource> state_resources = state.getResources();
        ArrayList<Property> state_props = state.getProperties();
        for(int i=0; i < taskDictionary.size(); i++) {
            // I don't like the way this works, possible to mess up and add wrong tasks?
            boolean possible_task = true;
            Task current_task = taskDictionary.getTask(i);
            ArrayList<Condition> requirements = current_task.getRequirements();
            // I love IntelliJ
            for(Condition condition: requirements) {
                // Get value of this resource/property from the current state
                    // Issue: getting value can be Int, Bool, Double, etc...
                    // Also Condition.eval only can evaluate doubles
                // If the value doesn't pass condition.eval(), break out and go to next task
                    // Or set a flag to tell logic after this loop to not add the task to valid_tasks array
            }
            // If all conditions are satisfied, then add this task to the valid_tasks array
            if(possible_task) {
                valid_tasks.add(current_task);
            }

        }

        return null;
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