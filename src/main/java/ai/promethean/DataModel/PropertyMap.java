package ai.promethean.DataModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A Map of (name, Property object) to easily retrieve a Property with a given name
 */
public class PropertyMap {
    private Map<String, Property> property_map = new HashMap<>();

    /**
     * Instantiates a new Property map.
     */
    public PropertyMap() {}

    /**
     * Add a BooleanProperty to the PropertyMap. If a property already has the name specified, the value will be updated
     *
     * @param name  The name
     * @param value The value
     */
    public void addProperty(String name, Boolean value) {
        Property new_prop = new BooleanProperty(name, value);
        if(property_map.containsKey(name)) {
            property_map.replace(name, new_prop);
        } else {
            property_map.put(name, new_prop);
        }
    }

    /**
     * Add a NumericalProperty to the PropertyMap. If a property already has the name specified, the value will be updated
     *
     * @param name  The name
     * @param value The value
     */
    public void addProperty(String name, Double value) {
        Property new_prop = new NumericalProperty(name, value);
        if(property_map.containsKey(name)) {
            property_map.replace(name, new_prop);
        } else {
            property_map.put(name, new_prop);
        }
    }

    /**
     * Add a StringProperty to the PropertyMap. If a property already has the name specified, the value will be updated
     *
     * @param name  The name
     * @param value The value
     */
    public void addProperty(String name, String value) {
        Property new_prop = new StringProperty(name, value);
        if(property_map.containsKey(name)) {
            property_map.replace(name, new_prop);
        } else {
            property_map.put(name, new_prop);
        }
    }

    /**
     * Add a fully defined property to the PropertyMap. If a property already has the name specified, the value will be updated
     *
     * @param p The property to add
     */
    public void addProperty(Property p) {

        if(property_map.containsKey(p.getName())) {
            property_map.replace(p.getName(), p);
        } else {
            property_map.put(p.getName(), p);
        }
    }

    /**
     * Gets the whole Map object and returns it, for use of comparing two PropertyMaps
     *
     * @return The property_map
     */
    private Map<String, Property> getPropertyMap() {
        return property_map;
    }

    /**
     * Gets value of the property with specified name. If not property exists, returns Null
     *
     * @param name The name of the property to get the value of
     * @return Property object with the given name, Null otherwise
     */
    public Property getProperty(String name) {
        return property_map.get(name);
    }

    /**
     * Checks whether the PropertyMap contains an entry with the given name
     *
     * @param name The name of property to check in the map
     * @return Boolean whether the PropertyMap contains an entry with that key name
     */
    public Boolean containsProperty(String name) {
        return property_map.containsKey(name);
    }

    /**
     * Gets a Java Set with all the string names of keys in the PropertyMap
     *
     * @return A Sat of Strings of the key names
     */
    public Set<String> getKeys() {
        return property_map.keySet();
    }

    /**
     * Used to compare two PropertyMaps. Returns true if they are the same map, false otherwise. This includes the Property mapped to the name
     *
     * @param p the PropertyMap to compare to this one
     * @return Boolean whether the input PropertyMap is identical to this one
     */
    public Boolean equals(PropertyMap p) {
        return property_map.equals(p.getPropertyMap());
    }

    @Override
    public String toString() {
        String printOut="";
        for(Property p : property_map.values()){
            printOut=printOut + "\n Name: "+ p.getName()+ "Type: " +p.getType()+ " Value: " + p.getValue();
        }
        return printOut;
    }
}
