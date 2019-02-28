package ai.promethean.DataModel;
import java.util.*;
import java.util.concurrent.atomic.*;

/**
 * Defines a state the system can be / is in
 */
public class SystemState {
    private int UID;
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    private int time;
    private PropertyMap properties = new PropertyMap();

    //Members for graph-search in planning
    private SystemState previousState;
    private Task previousTask;
    private double gValue=0.0;

    /**
     * Instantiates a new SystemState with no given time
     */
    public SystemState(){
        setUID();
    }

    /**
     * Instantiates a new System state which the system is in at a given time
     *
     * @param time The time the system is in the state
     */
    public SystemState(int time){
        setUID();
        setTime(time);
    }

    /**
     * Sets time the system is in a state
     *
     * @param time The time the state will be valid
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Sets the UID of the SystemState. Will automatically increment and assign properly
     */
    private void setUID(){

        this.UID=ID_GENERATOR.getAndIncrement();
    }

    /**
     * Get the UID of the state
     *
     * @return The UID
     */
    public int getUID(){
        return UID;
    }

    /**
     * Get the time a system is in the state
     *
     * @return The time
     */
    public int getTime(){
        return time;
    }

    /**
     * Sets the G-value of the state, used for A* planning
     *
     * @param gValue The G-value to assign to the state
     */
    public void setgValue(double gValue) {
        this.gValue = gValue;
    }

    /**
     * Gets the G-value of the state
     *
     * @return The state's G-value
     */
    public double getgValue() {
        return gValue;
    }


    /**
     * Gets the properties of the SystemState
     *
     * @return An ArrayList of Property objects
     */
    public ArrayList<Property> getProperties() {
        ArrayList<Property> property_list = new ArrayList<>();
        for (String key : properties.getKeys()) {
            property_list.add(properties.getProperty(key));
        }
        return property_list;
    }

    /**
     * Sets the SystemState properties to the given PropertyMap
     *
     * @param propertyMap The PropertyMap to assign to the SystemState
     */
    public void setPropertyMap(PropertyMap propertyMap) {
        this.properties = propertyMap;
    }


    /**
     * Gets the SystemState property map.
     *
     * @return The PropertyMap
     */
    public PropertyMap getPropertyMap() { return properties; }

    /**
     * Sets previous state.
     *
     * @param previousState A SystemState object representing the previous state
     */
    public void setPreviousState(SystemState previousState) {
        this.previousState = previousState;
    }

    /**
     * Gets previous state.
     *
     * @return A SystemState object of the previous state
     */
    public SystemState getPreviousState() {

        return previousState;
    }

    /**
     * Sets previous task.
     *
     * @param previousTask A Task object of the previous task
     */
    public void setPreviousTask(Task previousTask) {
        this.previousTask = previousTask;
    }

    /**
     * Gets previous task.
     *
     * @return A Task object of the previous task
     */
    public Task getPreviousTask() {
        return previousTask;
    }


    /**
     * Add a BooleanProperty to the PropertyMap
     *
     * @param name  The name
     * @param value The value
     */
    public void addProperty(String name, Boolean value) {
        properties.addProperty(name, value, null);
    }


    /**
     * Add a StringProperty to the PropertyMap
     *
     * @param name  The name
     * @param value The value
     */
    public void addProperty(String name, Double value) {
        properties.addProperty(name, value, null);
    }

    /**
     * Add a StringProperty to the PropertyMap
     *
     * @param name  The name
     * @param value The value
     */
    public void addProperty(String name, String value) {
        properties.addProperty(name, value, null);
    }

    /**
     * Add a fully defined Property object to the PropertyMap
     *
     * @param p the p
     */
    public void addProperty(Property p) {
        properties.addProperty(p);
    }

    /**
     * Gets a Property from the PropertyMap given a name
     *
     * @param name The name of the Property to search for
     * @return A Property object retrieved from the PropertyMap, or Null if none with the given name could be found
     */
    public Property getProperty(String name) {
        return properties.getProperty(name);
    }

/*
    //TODO needs more testing
    public Boolean equals(SystemState systemState){
        this.sortProperties();
        systemState.sortProperties();
        return properties.equals(systemState.getProperties());
    }
    */

    @Override
    public String toString() {
        return "System State UID: " + this.UID + "\n Time: " + this.time
                + "\n G-Value: " + gValue
                + "\n Properties: " + properties;
    }
}