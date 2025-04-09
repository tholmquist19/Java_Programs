package cscd212classes.lifeform;

public abstract class LifeForm {
    protected int currentLifePoints;
    private final String name;

    public LifeForm(final String name, final int currentLifePoints){
        if(name==null||name.isEmpty()||currentLifePoints<=0)
            throw new IllegalArgumentException("Bad params in LifeForm constructor");
        this.name = name;
        this.currentLifePoints = currentLifePoints;
    }
    public int getCurrentLifePoints(){
        return this.currentLifePoints;
    }
    public void setCurrentLifePoints(final int currentLifePoints){
        this.currentLifePoints = currentLifePoints;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return this.name+" has "+this.currentLifePoints+" life points";
    }

}
