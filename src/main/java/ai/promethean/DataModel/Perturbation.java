package ai.promethean.DataModel;

import java.util.*;


/**
 * Perturbation class used to define perts in the input JSON files
 */
public class Perturbation {
    private int time;
    private String name;
    private ArrayList<Property> property_impacts= new ArrayList<Property>();

    /**
     * Instantiates a new Perturbation. Defaults to have no name and to take effect at t=0
     */
    public Perturbation(){
        setTime(0);
    }

    /**
     * Instantiates a new Perturbation with a given name. Defaults to take effect at t=0
     *
     * @param _name The name of the Perturbation
     */
    public Perturbation(String _name){
        setTime(0);
        setName(_name);

    }

    /**
     * Instantiates a new Perturbation to take effect at a given time
     *
     * @param time The time which the Perturbation will happen
     */
    public Perturbation(int time){
        setTime(time);
    }

    /**
     * Instantiates a new Perturbation with a given name to take effect at the given time
     *
     * @param _name The name of the Perturbation
     * @param time The time which the Perturbation will happen
     */
    public Perturbation(String _name, int time){
        setName(_name);
        setTime(time);
    }

    /**
     * Sets the time the Perturbation will take effect
     *
     * @param time The time
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Gets the time the Perturbation will happen
     *
     * @return The time
     */
    public int getTime() {
        return time;
    }

    /**
     * Gets the name of the Pert
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Pert
     *
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets an ArrayList of Property impacts the Perturbation causes
     *
     * @return the properties
     */
    public ArrayList<Property> getProperties() {
        return property_impacts;
    }


    /**
     * Look up the impact on a certain property given the name
     *
     * @param name The name of the property to search for
     * @return A Property object with the given name, or Null if name was not found
     */
    public Property getProperty(String name){
        for(Property p: property_impacts){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }


    /**
     * Add property to the impacts of the Perturbation
     *
     * @param p A fully formed Property object
     */
    public void addProperty(Property p){
        property_impacts.add(p);
    }


    /**
     * Add a BooleanProperty to the impacts of the Pert
     *
     * @param name  The name
     * @param value The value
     * @param type  The type, either "assignment" or "delta"
     */
    public void addProperty(String name, Boolean value, String type){
        property_impacts.add(new BooleanProperty(name, value,type));
    }

    /**
     * Add a NumericalProperty to the impacts of the Pert
     *
     * @param name  The name
     * @param value The value
     * @param type  The type, either "assignment" or "delta"
     */
    public void addProperty(String name, Double value, String type){
        property_impacts.add(new NumericalProperty(name, value,type));
    }

    /**
     * Add a StringProperty to the impacts of the Pert
     *
     * @param name  The name
     * @param value The value
     * @param type  The type, either "assignment" or "delta"
     */
    public void addProperty(String name, String value, String type){
        property_impacts.add(new StringProperty(name, value,type));
    }

    /**
     * Sort properties
     */
    public void sortProperties(){
        Collections.sort(property_impacts, new SortbyProperty());
    }

    @Override
    public String toString() {
        return "Perturbation Name: "+this.name+ ", Time: " + this.time
                + "\n Property Changes: " + property_impacts + "\n";
    }
}
