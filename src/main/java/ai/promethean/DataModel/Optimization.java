package ai.promethean.DataModel;

/**
 * Optimization class used to define optimizations in the input JSON files
 */
public class Optimization {
    private String name;
    private Boolean isMin;
    private int priority;

    /**
     * Instantiates a new Optimization.
     *
     * @param _name     The name
     * @param _isMin    Whether the optimization is a minimization or now
     * @param _priority The priority of the optimization, with 0 being the lowest
     */
    public Optimization(String _name, Boolean _isMin, int _priority){
        setName(_name);
        setIsMin(_isMin);
        setPriority(_priority);
    }

    /**
     * Sets priority
     *
     * @param priority The priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Gets priority
     *
     * @return The priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets whether the Optimization is a minimization or now
     *
     * @param min True/False if the Optimization is min
     */
    public void setIsMin(Boolean min) {
        isMin = min;
    }

    /**
     * Gets whether the Optimization is a minimum or not
     *
     * @return True/False
     */
    public Boolean getIsMin() {
        return isMin;
    }

    /**
     * Sets name of the Optimization
     *
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Checks whether a given Optimization is the same as this one
     *
     * @param optimization The optimization to compare
     * @return Boolean whether the input Optimization is the same
     */
    public Boolean equals(Optimization optimization){
        return optimization.getName().equals(this.name) && optimization.getIsMin().equals(this.isMin);
    }

    @Override
    public String toString() {
        if(isMin)
            return "Optimization Name: " +name + " Type: Minimize Priority: " + priority;
        else
            return "Optimization Name: " +name + " Type: Maximize Priority: " + priority;
    }
}
