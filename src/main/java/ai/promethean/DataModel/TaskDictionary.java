package ai.promethean.DataModel;
import java.util.*;

/**
 * A Map of (UID, Task object) pairs to quickly access Tasks
 */
public class TaskDictionary {
    private Map<Integer, Task> TaskDictionary = new HashMap<Integer, Task>();

    /**
     * Gets the entire task dictionary
     *
     * @return The task dictionary
     */
    public Map<Integer, Task> getTaskDictionary() {
        return TaskDictionary;
    }

    /**
     * Add a fully formed Task to the Map
     *
     * @param t The Task object to add to the TaskDictionary
     */
    public void addTask(Task t){
        TaskDictionary.put(t.getUID(), t);
    }

    /**
     * Remove a given task from the TaskDictionary
     *
     * @param t The Task to remove
     */
    public void removeTask(Task t){
        TaskDictionary.remove(t.getUID());
    }

    /**
     * Find a Task in the dictionary given the Task itself
     *
     * @param t The Task to retrieve the UID of
     * @return The
     */
    public Task findTask(Task t){
        return TaskDictionary.get(t.getUID());
    }

    /**
     * Gets a Task given the index in the TaskDictionary
     *
     * @param i The index of the TaskDictionary
     * @return The Task found at the given index
     */
    public Task getTask(Integer i) { return TaskDictionary.get(i); }

    /**
     * Gets the number of elements in the TaskDictionary
     *
     * @return Integer of the number of Tasks
     */
    public int size() { return TaskDictionary.size(); }

    @Override
    public String toString() {
        String printOut= "Task Dictionary: \n";
        for(Task t: TaskDictionary.values()){
            printOut=printOut+ t + "\n";
        }
        return printOut;
    }
}
