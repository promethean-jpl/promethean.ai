package ai.promethean.DataModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ResourceMap {
    private Map<String, Resource> resource_map = new HashMap<>();

    public ResourceMap() {}

    /* Used to add new resource to the map. If a resource already has the name specified, the value will be updated.
     * @param   name    The name of the resource
     * @param   value   The value to map to given name
     */
    public void addResource(String name, Double value) {
        Resource new_resource = new Resource(name, value);
        if (resource_map.containsKey(name)) {
            resource_map.replace(name, new_resource);
        } else {
            resource_map.put(name, new_resource);
        }
    }

    /* Returns the private resource_map to be used to compare two ResourceMaps
     */
    public Map<String, Resource> getResourceMap() {
        return resource_map;
    }

    /* Returns the resource value given its name
     * @param   name    The name of the resource whose value to retrieve
     */
    public Double getValue(String name) {
        return resource_map.get(name).getValue();
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

    /* Used to compare two ResourceMaps. Returns true if they are the same map, false otherwise. This includes the Resource mapped to resource names
     * @param   r   The ResourceMap to compare to this one
     */
    public Boolean equals(ResourceMap r) {
        return resource_map.equals(r.getResourceMap());
    }


}
