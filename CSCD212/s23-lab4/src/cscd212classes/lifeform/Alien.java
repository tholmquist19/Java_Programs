package cscd212classes.lifeform;
import cscd212interfaces.recovery.RecoveryBehavior;

public abstract class Alien extends LifeForm{

    private RecoveryBehavior recovery;

    public Alien(final String name, final int currentLifePoints, final int maxLifePoints,
                 final RecoveryBehavior recovery){
        super(name, currentLifePoints, maxLifePoints);
        if(recovery==null)
            throw new IllegalArgumentException("Bad Params in Alien Constructor");
        this.recovery=recovery;
    }
    public Alien(final String name, final int currentLifePoints){
        super(name,currentLifePoints);
    }
    public void setCurrentLifePoints(final int currentLifePoints){
        if(currentLifePoints<=0||currentLifePoints>this.MAX_LIFE_POINTS)
            throw new IllegalArgumentException("Bad Params in setCurrentLifePoints");
        super.currentLifePoints=currentLifePoints;
    }
    public void setRecoveryBehavior(final RecoveryBehavior newBehavior){
        if(newBehavior==null)
            throw new IllegalArgumentException("bad params in setRecoveryBehavior");
        this.recovery=newBehavior;
    }
    public RecoveryBehavior getRecoveryBehavior(){
        return this.recovery;
    }
    public String recover(){
        int x = this.getRecoveryBehavior().calculateRecovery(this.currentLifePoints);
        if(this.currentLifePoints+x<=110)
            this.setCurrentLifePoints(this.currentLifePoints+x);
        return getName()+" has had "+x+" recovery points added their current life points";
    }
    public String toString(){
        return super.toString()+" and has recovery mode of "+this.recovery.getClass().getSimpleName();
    }


}

