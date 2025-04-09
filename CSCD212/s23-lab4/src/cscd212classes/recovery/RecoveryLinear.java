package  cscd212classes.recovery;
import cscd212interfaces.recovery.RecoveryBehavior;

public class RecoveryLinear implements RecoveryBehavior{

    private int recoveryStep;

    public RecoveryLinear(final int recoveryStep){
        if(recoveryStep<=0)
            throw new IllegalArgumentException("Bad params in RecoveryLinear");
        this.recoveryStep=recoveryStep;
    }

    @Override
    public int calculateRecovery(final int currentLifePoints) {
        if(currentLifePoints>=95)
            return 15;
        return this.recoveryStep;
    }
}
