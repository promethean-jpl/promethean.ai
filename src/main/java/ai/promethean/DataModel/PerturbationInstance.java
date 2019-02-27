package ai.promethean.DataModel;

/**
 * The type Perturbation instance.
 */
public class PerturbationInstance {
    private SystemState previousSystemState;
    private Perturbation perturbation;

    /**
     * Instantiates a new Perturbation instance.
     *
     * @param _prevSystemState the prev system state
     * @param _perturbation    the perturbation
     */
    public PerturbationInstance(SystemState _prevSystemState, Perturbation _perturbation){
        setPerturbation(_perturbation);
        setPreviousSystemState(_prevSystemState);
    }

    /**
     * Sets perturbation.
     *
     * @param perturbation the perturbation
     */
    public void setPerturbation(Perturbation perturbation) {
        this.perturbation = perturbation;
    }

    /**
     * Sets previous system state.
     *
     * @param previousSystemState the previous system state
     */
    public void setPreviousSystemState(SystemState previousSystemState) {
        this.previousSystemState = previousSystemState;
    }

    /**
     * Gets perturbation.
     *
     * @return the perturbation
     */
    public Perturbation getPerturbation() {
        return perturbation;
    }

    /**
     * Gets previous system state.
     *
     * @return the previous system state
     */
    public SystemState getPreviousSystemState() {
        return previousSystemState;
    }

    @Override
    public String toString() {
        return "Perturbation Instance: \n Previous State: " + previousSystemState
                + "\n Perturbation: " + perturbation;
    }

    /**
     * Apply perturbation system state.
     *
     * @return the system state
     */
    public SystemState applyPerturbation(){
        //TODO When ready: this function can be implemented to create a new state by applying perturbation to prev state
        return new SystemState(-1);
    }
}
