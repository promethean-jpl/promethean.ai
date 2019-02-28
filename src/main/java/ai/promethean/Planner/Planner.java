package ai.promethean.Planner;

import ai.promethean.DataModel.SystemState;

public class Planner {

    private Algorithm algorithm;

    public Planner(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Plan plan() {
        SystemState runtimeGoalState = this.algorithm.run();
        if (runtimeGoalState != null) {
            return new Plan(runtimeGoalState);
        }
        return null;
    }

}
