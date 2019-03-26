package ai.promethean.API;
import ai.promethean.ExecutingAgent.*;
import ai.promethean.Output.*;
import ai.promethean.Parser.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public void throwOutputError(String err_msg){ throw new OutputError(err_msg); }


    public Map<String, Object> parseInput(String inputFile, Boolean isFile){
        ParserInterface p = new JSONParser();
        Map<String, Object> objects = p.parse(inputFile, isFile);

        return objects;
    }

    /**
     * Generate a plan to be used by planner from list of parsed objects
     * @param parsedObjects List of objects generated by parser
     */


    public Plan generatePlanFromParsedObjects(Map<String, Object> parsedObjects){
        Algorithm algo = new AStar();
        Planner planner = new Planner(algo);
        Plan plan = planner.plan((SystemState) parsedObjects.get("initialState"),
                (GoalState) parsedObjects.get("goalState"),
                (TaskDictionary) parsedObjects.get("tasks"),
                (StaticOptimizations) parsedObjects.get("optimizations"));
        return plan;
    }

    /**
     * Generate a plan from a specific SystemState Object instead of list of parsed objects
     * @param currentState
     * @param goalState
     * @param taskDictionary
     * @param optimizations
     * @return
     */
    public Plan generatePlanFromSystemState(SystemState currentState, GoalState goalState, TaskDictionary taskDictionary, StaticOptimizations optimizations){
        Algorithm algo = new AStar();
        Planner planner = new Planner(algo);
        Plan plan = planner.plan(currentState, goalState, taskDictionary, optimizations);
        return plan;
    }
    /**
     * Parse the input file and generate a plan from the parsed objects.
     * Initialize the clock and handle perturbation or goal state responses
     */

    public void executePlan(String input, Boolean isFile){
        Map <String, Object> objects = parseInput(input, isFile);
        Plan plan = generatePlanFromParsedObjects(objects);
        ClockManager clockManager = new ClockManager();
        clockManager.runPlanClock(plan, objects);


    }
}

