package cscd212classes.recovery;
import cscd212interfaces.recovery.RecoveryBehavior;

public class RecoveryNone implements RecoveryBehavior{

    public RecoveryNone(){}

    @Override
    public int calculateRecovery(final int currentLifePoints) {
        return 0;
    }
}
