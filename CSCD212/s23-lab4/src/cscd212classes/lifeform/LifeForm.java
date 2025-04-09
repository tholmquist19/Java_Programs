package cscd212classes.lifeform;

public abstract class LifeForm {
    protected int currentLifePoints;
    protected final int MAX_LIFE_POINTS;
    private String name;

    public LifeForm(final String name, final int currentLifePoints, final int MAX_LIFE_POINTS){
        if(name==null||name.isEmpty()||currentLifePoints<=0||MAX_LIFE_POINTS<=0||currentLifePoints>MAX_LIFE_POINTS)
            throw new IllegalArgumentException("Bad Params in LifeForm Constructor");
        this.name=name;
        this.currentLifePoints=currentLifePoints;
        this.MAX_LIFE_POINTS=MAX_LIFE_POINTS;
    }
    public LifeForm(final String name, final int currentLifePoints){
        if(name==null||name.isEmpty()||currentLifePoints<=0)
            throw new IllegalArgumentException("Bad Params in LifeForm Constructor");
        this.name=name;
        this.currentLifePoints=currentLifePoints;
        this.MAX_LIFE_POINTS = 100;
    }
    public int getLifePoints(){
        return this.currentLifePoints;
    }
    public String getName(){
        return this.name;
    }
    public void takeHit(final int damage){
        if(damage<=0)
            throw new IllegalArgumentException("Bad params in takeHit");
        if(damage>=this.currentLifePoints)
            this.currentLifePoints=0;
        else
            this.currentLifePoints-=damage;
    }
    public String toString(){
        return this.name+" has "+this.currentLifePoints+" life points";
    }
}
