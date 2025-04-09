package  cscd212classes.lifeform;
import cscd212interfaces.recovery.RecoveryBehavior;

public class Martian extends Alien{

    public Martian(final String name, final int currentLifePoints){
        super(name, currentLifePoints);
    }
    public Martian(final String name, final int currentLifePoints, final int maxLifePoints,
                   final RecoveryBehavior recovery){
        super(name, currentLifePoints, maxLifePoints, recovery);
    }
}
