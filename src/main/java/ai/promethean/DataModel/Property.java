package ai.promethean.DataModel;

public class Property {
    protected String name;
    protected Boolean value;

    public Property(String _name, Boolean _value){
        setName(_name);
        setValue(_value);
    }

    public void setName(String _name){
        this.name=_name;
    }

    public void setValue(Boolean _value) {
        this.value = _value;
    }

    public String getName(){
        return this.name;
    }

    public Boolean getValue() {
        return this.value;
    }

    public String toString() {
        return("Property name: " + this.name + ", Value: " + this.value);
    }

    public Boolean equals(Property p) {
        return p.getName().equals(this.name) && p.getValue().equals(this.value);
    }
}
