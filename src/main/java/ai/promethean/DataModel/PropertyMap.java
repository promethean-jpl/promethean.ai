package ai.promethean.DataModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PropertyMap {
    private Map<String, Property> property_map = new HashMap<>();

    public PropertyMap() {}

    // TODO: Figure out how to add multiple different types for value instead of just Boolean
    /* Used to add a new property to the PropertyMap. If a property already has the name specified, the value will be updated
     * @param   name    The name of the property being added
     * @param   value   The boolean value associated with the property
     */
    public void addProperty(String name, Boolean value) {
        Property new_prop = new Property(name, value);
        if(property_map.containsKey(name)) {
            property_map.replace(name, new_prop);
        } else {
            property_map.put(name, new_prop);
        }
    }

    /* Returns the private property_map to be used to compare two PropertyMaps
     */
    public Map<String, Property> getPropertyMap() {
        return property_map;
    }

    /* Returns the value of the property with specified name. If not property exists, returns null
     * @param   name    The name of the property to get the value of
     */
    public Property getValue(String name) {
        return property_map.get(name);
    }

    /* Returns true/false whether the property map contains an entry with argument name
     * @param   name    The name of property to check in the map
     */
    public Boolean containsProperty(String name) {
        return property_map.containsKey(name);
    }

    /* Returns a Java Set with all the string names of keys in the property map
     */
    public Set<String> getKeys() {
        return property_map.keySet();
    }

    /* Used to compare two PropertyMaps. Returns true if they are the same map, false otherwise. This includes the Property mapped to the name
     * @param   p   The PropertyMap to compare to this one
     */
    public Boolean equals(PropertyMap p) {
        return property_map.equals(p.getPropertyMap());
    }


}
