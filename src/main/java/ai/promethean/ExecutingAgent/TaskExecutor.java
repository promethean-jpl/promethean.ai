package ai.promethean.ExecutingAgent;

import ai.promethean.DataModel.Property;
import ai.promethean.DataModel.PropertyMap;
import ai.promethean.DataModel.SystemState;
import ai.promethean.DataModel.Task;
import ai.promethean.Planner.Plan;
import ai.promethean.Planner.PlanBlock;

import java.util.List;

public class TaskExecutor extends ClockObserver {
    private Plan plan;
    private int initTime;

    public TaskExecutor(Plan _plan) {
        plan = _plan;
        initTime = 0;
    }

    /**
     * Notify TaskExecutor of the current time
     * This will apply a task and add a new state to shared state list if the task has finished
     * @param _time The current time
     * @return returns true if the TaskExecutor is out of tasks or a generated state is invalid
     */
    @Override
    public boolean update(int _time) {
        List<PlanBlock> planBlocks = plan.getPlanBlockList();
        if (planBlocks.isEmpty()) {
            return true;
        }

        int taskDuration = planBlocks.get(0).getTask().getDuration();
//        int initTime = planBlocks.get(0).getTask().getTime();

        if (_time == initTime + taskDuration) {
            PlanBlock currentBlock = planBlocks.remove(0);

            boolean appliedBlock = applyBlock(currentBlock, _time);
            if (appliedBlock) {
                initTime = _time;
            }
            return !appliedBlock;
        }

        return false;
    }

    /**
     * Generate a new state from the current PlanBlock
     * Also compare the new state to the state that the plan predicted
     * @param block PlanBlock whose task should be applied to the current state
     * @param time Current time
     * @return true if the generated state matches the block's state or false otherwise
     */
    private boolean applyBlock(PlanBlock block, int time) {
        System.out.println(block.getTask().toString());
        System.out.println(block.getState().toString());
        System.out.println(time);
        // Generate a new SystemState based on the last element of the list of SystemStates
        // Add that new State to the end of the state list
        // Check that the new state equals the plan's predicted state
        SystemState previousState = stateList.get(stateList.size() - 1);
        PropertyMap prev_properties = previousState.getPropertyMap();

        SystemState currentState = new SystemState(time);
        Task task = block.getTask();

        for (String propertyName : prev_properties.getKeys()) {
            Property previousProperty = previousState.getProperty(propertyName);
            Property impact = task.getProperty(propertyName);
            if (impact != null) {
                Property newProperty = previousProperty.applyImpact(impact);
                currentState.addProperty(newProperty);
            } else {
                currentState.addProperty(previousProperty);
            }
        }

        ClockObserver.addState(currentState);

        System.out.println(currentState.equals(block.getState()));
        return currentState.equals(block.getState());
    }
}