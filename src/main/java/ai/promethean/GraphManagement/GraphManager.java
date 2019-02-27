package ai.promethean.GraphManagement;

import ai.promethean.DataModel.*;
import ai.promethean.Planner.TaskWeight;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Builds and manages the graph which is used by the planning algorithm.
 */
public class GraphManager {

    private PriorityQueue<StateTemplate> frontier;
    private static SystemState initState;
    private static SystemState goalState;
    private static TaskDictionary taskDict;
    private static StaticOptimizations optimizations;

    /**
     * Instantiates a new GraphManager.
     */
    public GraphManager() {

    }

    /**
     * Used to get an ArrayList of tasks which are valid to execute from the input `state`.
     * @param state SystemState object of the curernt state to find valid tasks from
     * @param taskDictionary TaskDictionary object which contains every possible task
     * @return ArrayList of Task objects which are valid to be executed from the given state
     */
    private static ArrayList<Task> validTasks(SystemState state, TaskDictionary taskDictionary){
        // For keeping track of valid tasks
        ArrayList<Task> valid_tasks = new ArrayList<>();
        for (int i = 0; i < taskDictionary.size(); i++) {
            boolean possible_task = false;
            Task current_task = taskDictionary.getTask(i);
            ArrayList<Condition> requirements = current_task.getRequirements();
            for (Condition condition : requirements) {
                String name = condition.getName();
                Object state_value = state.getProperty(name);
                // ISSUE: condition.evaluate only does Doubles, extending props will break this
                // Extend after merging other changes to handle different inputs
                // Basically remove the (Double) cast right there, for now it won't compile without it
                if (condition.evaluate((Double) state_value)) {
                    possible_task = true;
                } else {
                    possible_task = false;
                }
            }
            // If all conditions are satisfied, then add this task to the valid_tasks array
            if (possible_task) {
                valid_tasks.add(current_task);
            }
        }
        return valid_tasks;
    }

    /**
     *
     * @param state SystemState representing the state the system is in currently
     * @param tasks ArrayList of Task objects received from the validTasks method
     * @return ArrayList of StateTemplate objects which represent the possible states which can be reached from the current state and its valid tasks
     */
    private static ArrayList<StateTemplate> templateGeneration(SystemState state, ArrayList<Task> tasks){
        // TODO: Create templates for every task
        return null;
    }

    /**
     * Add neighbors to the Frontier of the planning algorithm
     *
     * @param state SystemState to add to the frontier
     */
    public static void addNeighbors(SystemState state) {
        ArrayList<Task> tasks = validTasks(state, taskDict);
        ArrayList<StateTemplate> templates = templateGeneration(state, tasks);
        // TODO: Enqueue to frontier
    }

    /**
     * Creates a valid SystemState object representing the state the spacecraft will be in after executing a given Task
     * @param previousState SystemState object of the state that is being transitioned from
     * @param task Task object of the task which is being executed on the given state
     * @return SystemState object of the state the system will be in after executing the input Task
     */
    private static SystemState createState(SystemState previousState, Task task) {
        ArrayList<Property> taskProperties = task.getProperty_impacts();
        PropertyMap affectedProperties = previousState.getPropertyMap();

        int previousTime = previousState.getTime();
        int nextTime = previousTime + task.getDuration();
        double gVal = previousState.getgValue() + TaskWeight.calculateTaskWeight(task, optimizations);

        SystemState nextState = new SystemState(nextTime);
        nextState.setgValue(gVal);
        nextState.setPreviousState(previousState);
        nextState.setPreviousTask(task);

        PropertyMap nextStateMap = nextState.getPropertyMap();

        for (Property property: taskProperties) {
            String propertyName = property.getName();

            Property oldProperty = affectedProperties.getProperty(propertyName);
            nextStateMap.addProperty(oldProperty.applyPropertyImpactOnto(property));
        }

        for (String propertyName: affectedProperties.getKeys()) {
            if (!nextStateMap.containsProperty(propertyName)) {
                nextStateMap.addProperty(affectedProperties.getProperty(propertyName));
            }
        }

        return nextState;
    }

    /**
     * Used to find the best SystemState template from the frontier
     * @return SystemState object of the best state available from the frontier, of Null if frontier is empty
     */
    public static SystemState poll() {
        // TODO: Dequeue best template from frontier or Null if frontier is empty
        // TODO: return createState(template.previousState, template.task)
        return null;
    }
}
