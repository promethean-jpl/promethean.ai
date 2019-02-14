package ai.promethean.DataModel;
import java.util.*;

public class Task {
    private int UID;
    private int duration;

    private PropertyMap property_impacts= new PropertyMap();
    private ArrayList<ai.promethean.DataModel.Condition> requirements=new ArrayList<>();

    public Task(int _UID, int _duration){
        setUID(_UID);
        setDuration(_duration);
    }

    public void setUID(int _UID){
        this.UID=_UID;
    }

    public int getUID(){
        return this.UID;
    }

    public void setDuration(int _duration){
        this.duration=_duration;
    }

    public int getDuration(){
        return this.duration;
    }

    public PropertyMap getProperty_impacts() {
        return property_impacts;
    }
    public ArrayList<Condition> getRequirements(){
        return requirements;
    }

    public void addProperty(String name, Boolean value){
        property_impacts.addProperty(name, value);
    }

    public void addProperty(String name, Double value){
        property_impacts.addProperty(name, value);
    }

    public void addProperty(String name, String value){
        property_impacts.addProperty(name, value);
    }

    public void addRequirement(ai.promethean.DataModel.Condition c){ requirements.add(c);}
}
