package ai.promethean;
import ai.promethean.DataModel.*;
import ai.promethean.GraphManagement.GraphManager;


public class Main {

    public static void main(String[] args) {
        GraphManager manager = new GraphManager();
        System.out.println("Testing graph manager");
        System.out.println(manager);

        ResourceMap test_resource = new ResourceMap("test", 10.0);
        test_resource.addResource("Blah", 100.);

        ResourceMap test_resource_same = new ResourceMap("test", 10.);
        test_resource_same.addResource("Blah", 100.);

        ResourceMap test_resource_diff = new ResourceMap("test1", 100.);

        System.out.println(test_resource.getValue("test"));
        System.out.println(test_resource.equals(test_resource_same));
        System.out.println(test_resource.equals(test_resource_diff));
        System.out.println(test_resource.containsResource("Blah"));
        System.out.println(test_resource_diff.containsResource("Blah"));

    }
}
