package cscd212classes.recovery;
import cscd212interfaces.recovery.RecoveryBehavior;
import cscd212classes.lifeform.Alien;

public class RecoveryFractional implements RecoveryBehavior{

    private final int BASE_RECOVERY;
    private double recoveryPercent;

    public RecoveryFractional(final double recoveryPercent, final int baseRecovery){
        this.recoveryPercent=recoveryPercent;
        this.BASE_RECOVERY=baseRecovery;
    }
    public RecoveryFractional(final double recoveryPercent){
        this.recoveryPercent=recoveryPercent;
        this.BASE_RECOVERY=10;
    }

    @Override
    public int calculateRecovery(final int currentLifePoints) {
        if(currentLifePoints>=90) {
            return 20;
        }
        int x = (int)(currentLifePoints*this.recoveryPercent);
        if(x<this.BASE_RECOVERY)
            return this.BASE_RECOVERY;
        return x;
    }
}
