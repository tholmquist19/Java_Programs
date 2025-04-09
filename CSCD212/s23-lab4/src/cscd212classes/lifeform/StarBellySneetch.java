package cscd212classes.lifeform;
import cscd212interfaces.recovery.RecoveryBehavior;

public class StarBellySneetch extends Alien{
    public StarBellySneetch(final String name, final int currentLifePoints, final int maxLifePoints,
                            final RecoveryBehavior recovery){
        super(name, currentLifePoints, maxLifePoints, recovery);
    }
    public StarBellySneetch(final String name, final int currentLifePoints){
        super(name, currentLifePoints);
    }
}
