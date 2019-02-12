package ai.promethean.DataModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ResourceMap {
    private Map<String, Double> resource_map = new HashMap<>();

    /*
     * Initializer for Resource_2, which will hopefully replace / extend Resource
     * @param   _name   The name of the resource
     * @param   _value  The value of the resource
     */
    public ResourceMap() {}

    /* Used to add new resource to the map. If a resource already has the name specified, the value will be updated.
     * @param   name    The name of the resource
     * @param   value   The value to map to given name
     */
    public void addResource(String name, Double value) {
        if (resource_map.containsKey(name)) {
            resource_map.replace(name, value);
        } else {
            resource_map.put(name, value);
        }
    }

    /* Returns the private resource_map to be used to compare two ResourceMaps
     */
    public Map<String, Double> getResourceMap() {
        return resource_map;
    }

    /* Returns the value of a resource given its name
     * @param   name    The name of the resource whose value to retrieve
     */
    public Double getValue(String name) {
        return resource_map.get(name);
    }

    /* Returns True/False whether the resource map contains an entry with argument key name
     * @param   name    The name of the resource to check whether it is in the map
     */
    public Boolean containsResource(String name) {
        return resource_map.containsKey(name);
    }

    /* Returns a Java Set with all the string names of the keys in the resource map
     */
    public Set<String> getKeys() {
        return resource_map.keySet();
    }

    /* Used to compare two ResourceMaps. Returns true if they are the same map, false otherwise. This includes the values mapped to resource names
     * @param   r   The ResourceMap to compare to this one
     */
    public Boolean equals(ResourceMap r) {
        return resource_map.equals(r.getResourceMap());
    }


}
