package ai.promethean.DataModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PropertyMap {
    private Map<String, Boolean> property_map = new HashMap<>();

    public PropertyMap() {}

    // TODO: Figure out how to add multiple different types for value instead of just Boolean
    public void addProperty(String name, Boolean value) {
        if(property_map.containsKey(name)) {
            property_map.replace(name, value);
        } else {
            property_map.put(name, value);
        }
    }

    public Map<String, Boolean> getPropertyMap() {
        return property_map;
    }

    public Boolean getValue(String name) {
        return property_map.get(name);
    }

    public Boolean containsProperty(String name) {
        return property_map.containsKey(name);
    }

    public Set<String> getKeys(String name) {
        return property_map.keySet();
    }

    public Boolean equals(PropertyMap p) {
        return property_map.equals(p.getPropertyMap());
    }


}
