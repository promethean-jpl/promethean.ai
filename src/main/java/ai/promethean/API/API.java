package ai.promethean.API;
import ai.promethean.Parser.*;
import java.util.*;
import ai.promethean.DataModel.*;
import ai.promethean.Planner.*;


/*
    This API is meant to be as simple as possible and expandable as possible.
    If you want to add a new functionality simply add a function to the the API class.
    PlannerError is a custom error throwing class. When throwing a PlannerError make sure to include
    a detailed error message.
    Example, if we want to add a function to create resource objects, simply create that function and then
    call it with the resource object that keeps track of the examples

 */

public class API {
    public API(){

    }

    public void throwPlannerError(String err_msg){
        throw new PlannerError(err_msg);
    }

    public void throwParserError(String err_msg){
        throw new ParserError(err_msg);
    }

    public Plan generatePlan(String inputFile, Boolean isFile){
        JSONParser p = new JSONParser();
        List<Object> objects = p.parse(inputFile,isFile);
        Algorithm algo = new AStar();

        Planner planner = new Planner(algo);
        Plan plan = planner.plan((SystemState) objects.get(1), (GoalState) objects.get(2), (TaskDictionary) objects.get(3), (StaticOptimizations) objects.get(0));

        System.out.println("\nInitial State:\n======================");
        System.out.println(plan.getInitialState());
        System.out.println("\nRuntime Goal State:\n======================");
        System.out.println(plan.getGoalState());
        System.out.println("\nPlan:\n======================");
        List<PlanBlock> list = plan.getPlanBlockList();
        for (PlanBlock block: list) {
            System.out.println(block.getTask());
            System.out.println("\n");
            System.out.println(block.getState());
            System.out.println("\n");
        }

        return plan;
    }
}

