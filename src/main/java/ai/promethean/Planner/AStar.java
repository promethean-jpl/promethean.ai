package ai.promethean.Planner;

import ai.promethean.DataModel.GoalState;
import ai.promethean.DataModel.StaticOptimizations;
import ai.promethean.DataModel.SystemState;
import ai.promethean.DataModel.TaskDictionary;

public class AStar implements Algorithm {
    private GraphManager graph;
    private Double ceiling;
    private SystemState initState;
    private GoalState goalState;

    public AStar(SystemState initState, GoalState goalState, TaskDictionary taskDict, StaticOptimizations optimizations) {
        this.graph = new GraphManager(initState, goalState, taskDict, optimizations);
        this.initState = initState;
        this.goalState = goalState;
    }

    public SystemState run() {
        if (goalState.meetsGoal(initState)) {
            return initState;
        }

        graph.addNeighborsToFrontier(initState);

        while (!graph.frontierIsEmpty()/*|| ceiling check*/) {
            SystemState currentState = graph.poll();
            if (goalState.meetsGoal(currentState)) {
                return currentState;
            }
            graph.addNeighborsToFrontier(currentState);
        }

        return null;
    }

}
