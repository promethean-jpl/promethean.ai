package ai.promethean.DataModel;

import java.sql.Time;
import java.util.*;


public class Perturbation {
    private Time timeStamp;
    private PropertyMap properties= new PropertyMap();

    public Perturbation(){
        timeStamp= new Time(System.currentTimeMillis());
    }
    public Perturbation(long time){
        timeStamp= new Time(time);
    }

    public Time getTimeStamp() {
        return timeStamp;
    }

    public PropertyMap getProperties() {
        return properties;
    }

    public void addProperty(String name, Boolean value){
        properties.addProperty(name, value);
    }

    public void addProperty(String name, Double value){
        properties.addProperty(name, value);
    }

    public void addProperty(String name, String value){
        properties.addProperty(name, value);
    }

    @Override
    public String toString() {
        return "Pertubation Timestamp: " + this.timeStamp
                + "\n Property Changes: " + properties;
    }
}
