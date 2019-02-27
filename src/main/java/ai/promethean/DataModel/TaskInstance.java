package ai.promethean.DataModel;

/**
 * The type Task instance.
 */
public class TaskInstance {
    private SystemState prevSystemState;
    private Task task;

    /**
     * Instantiates a new Task instance.
     *
     * @param _prevSystemState the prev system state
     * @param _task            the task
     */
    public TaskInstance(SystemState _prevSystemState, Task _task){
        setTask(_task);
        setPreviousSystemState(_prevSystemState);
    }

    /**
     * Sets previous system state.
     *
     * @param _previousSystemState the previous system state
     */
    public void setPreviousSystemState(SystemState _previousSystemState) {
        this.prevSystemState = _previousSystemState;
    }

    /**
     * Set task.
     *
     * @param _task the task
     */
    public void setTask(Task _task){
        this.task = _task;
    }

    /**
     * Gets prev system state.
     *
     * @return the prev system state
     */
    public SystemState getPrevSystemState() {
        return prevSystemState;
    }

    /**
     * Get task task.
     *
     * @return the task
     */
    public Task getTask(){
        return task;
    }

    public String toString() {
        return "Task Instance: \n Previous State: " + prevSystemState
                + "\n Perturbation: " + task;
    }
}
