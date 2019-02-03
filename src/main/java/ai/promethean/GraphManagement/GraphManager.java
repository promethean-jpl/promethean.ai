package ai.promethean.GraphManagement;

import ai.promethean.DataModel.*;

import java.util.*;

/*
<p>
Class to create and return dummy data to be used in testing approaches to the graph management. This can probably be
    used to help create the actual class that will be used to pass around the possible states/tasks in the future
</p>
 */
class DummyData {
    ArrayList<SystemState> states = new ArrayList<SystemState>();
    TaskDictionary tasks = new TaskDictionary();

    DummyData() {
        SystemState start = new SystemState(0);
        start.addProperty("On", false);
        start.addProperty("Happy", false);
        start.addProperty("Nope", true);
        start.addResource("batteryLevel", 0.0);
        states.add(start);

        SystemState goal = new SystemState(100);
        goal.addProperty("On", true);
        goal.addProperty("Happy", true);
        goal.addResource("batteryLevel", 100.0);
        states.add(goal);

        Task chargeBattery = new Task(1, 10);
        chargeBattery.addResource("batteryLevel", 10.0);
        tasks.addTask(chargeBattery);

        Task makeHappy = new Task(2, 10);
        makeHappy.addProperty("Happy", true);
        makeHappy.addResource("batteryLevel", -10.0);
        Condition batGreater10 = new Condition("batteryLevel", 10.0, ">");
        makeHappy.addRequirement(batGreater10);
        tasks.addTask(makeHappy);

        Task turnOn = new Task(3, 15);
        turnOn.addProperty("On", true);
        tasks.addTask(turnOn);

        Task turnOff = new Task(4, 20);
        turnOff.addProperty("On", false);
        tasks.addTask(turnOff);

        Task useless = new Task(5, 100);
        useless.addProperty("Nope", true);
        tasks.addTask(useless);
    }
}

public class GraphManager {
    static DummyData getDummyData() {
        return new DummyData();
    }

    public static void main(String[] args) {
        System.out.print("Testing Graph Manager\n\n");
        DummyData data = getDummyData();

        generateNextStates(data.states.get(0), data.states.get(data.states.size() - 1), data.tasks);
    }

    public static ArrayList<Task> validTasks(SystemState state, SystemState goal, TaskDictionary tasks){
        // Find tasks which affect the resources / properties shared by both start and goal states
        // I think we'll need some methods which allow to look up tasks based on the resources / properties they impact
        // For now I'll just make a list of the ones that are known to be needed
        // TODO: Way to populate the valid_tasks list from TaskDictionary
        ArrayList<Task> valid_tasks = new ArrayList<>();
        valid_tasks.add(tasks.getTask(1));
        valid_tasks.add(tasks.getTask(2));
        valid_tasks.add(tasks.getTask(3));

        return valid_tasks;
    }

    /*
    @param  states  ArrayList of system states already defined, probably just start and goal states
    @param  tasks   ArrayList of tasks which can be taken from any state
     */
    public static void generateNextStates(SystemState state, SystemState goal, TaskDictionary tasks) {
        // Iterates over each task in tasks list argument (funky syntax)
        /*
        for (Task t: tasks) {
            System.out.print(t.getProperty_impacts() + "\n\n");
        }
        */

        // System.out.print(state + "\n\n" + goal);
        // Find difference in props / resources between current and goal states
        ArrayList<Property> start_props = state.getProperties();
        ArrayList<Resource> start_resources = state.getResources();
        ArrayList<Property> goal_props = goal.getProperties();
        ArrayList<Resource> goal_resources = goal.getResources();

        ArrayList<String> shared_props = new ArrayList<>();
        ArrayList<String> shared_resources = new ArrayList<>();

        // Find properties shared by start and goal states
        for (Property start_prop: start_props) {
            // Right now there isn't a way to get just the property value from a property object >:(
            // This is a slow way to do this ugh but we'll optimise later...
            for (Property goal_prop: goal_props) {
                if (start_prop.getName().equals(goal_prop.getName())) {
                    shared_props.add(start_prop.getName());
                }
            }
        }

        // Find resources shared by start and goal states
        for (Resource start_res: start_resources) {
            for (Resource goal_res: goal_resources) {
                if (start_res.getName().equals(goal_res.getName())) {
                    shared_resources.add(start_res.getName());
                }
            }
        }

        ArrayList<Task> valid_tasks = validTasks(state, goal, tasks);

        for (Task valid_task: valid_tasks) {
            System.out.print(valid_task.getResource_impacts());
            System.out.print(valid_task.getProperty_impacts() + "\n\n");
        }

        // TODO: Possible to separate tasks in the TaskDictionary into groups for resource / prop impacts?
        // Or extend task definition to add method to tell if task has only one type of impact? Or if it has requirements


    }
}
