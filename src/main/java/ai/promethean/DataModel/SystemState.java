package ai.promethean.DataModel;
import java.sql.Time;
import java.util.*;

public class SystemState {
    private int UID;
    private Time timeStamp;
    private PropertyMap properties = new PropertyMap();

    public SystemState(int _UID){
        setUID(_UID);
        timeStamp= new Time(System.currentTimeMillis());
    }

    public SystemState(int _UID, long time){
        setUID(_UID);
        timeStamp= new Time(time);
    }

    public void setUID(int _UID){
        this.UID=_UID;
    }

    public int getUID(){
        return UID;
    }

    public Time getTimeStamp(){
        return timeStamp;
    }

    public PropertyMap getProperties() {
        return properties;
    }

    public void addProperty(String name, Boolean value) {
        properties.addProperty(name, value);
    }

    public void addProperty(String name, Double value) {
        properties.addProperty(name, value);
    }

    public void addProperty(String name, String value) {
        properties.addProperty(name, value);
    }

    public Object getValue(String name) {
        Property return_object = properties.getValue(name);
        return return_object;
    }

    /*
    //TODO needs more testing
    public Boolean equals(SystemState systemState){
        this.sortProperties();
        this.sortResources();
        systemState.sortProperties();
        systemState.sortResources();

        return properties.equals(systemState.getProperties())&& resources.equals(systemState.getResources());
    }
    */

    // public void sortProperties(){ Collections.sort(properties, new SortbyProperty()); }

    @Override
    public String toString() {
        return "System State UID: " + this.UID + "\n Timestamp: " + this.timeStamp
                + "\n Properties: " + properties;
    }
}
