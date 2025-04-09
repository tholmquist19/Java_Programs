package  cscd212classes.lifeform;

public class Human extends LifeForm{

    private int armourPoints;

    public Human(final String name, final int currentLifePoints, final int maxLifePoints, final int armorPoints){
        super(name, currentLifePoints, maxLifePoints);
        if(armorPoints<0)
            throw new IllegalArgumentException("Bad Params in Human Constructor");
        this.armourPoints=armorPoints;
    }
    public Human(final String name, final int currentLifePoints){
        super(name, currentLifePoints);
    }
    public int getArmorPoints(){
        return this.armourPoints;
    }
    public void setArmorPoints(final int armourPoints){
        if(armourPoints<0)
            throw new IllegalArgumentException("Bad Params in setArmorPoints");
        this.armourPoints=armourPoints;
    }

    public void takeHit(final int damage){
        if(damage<=0)
            throw new IllegalArgumentException("Bad Params in takeHit");
        int x =damage;
        if(damage>this.armourPoints){
            x-=this.armourPoints;
            this.armourPoints=0;
            if(x!=0)
                super.takeHit(x);
        }
        else
            this.armourPoints-=damage;
    }
    public String toString(){
        return super.toString()+" and "+this.armourPoints+" armor points";
    }

}
