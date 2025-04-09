package cscd212enums;

public enum LifeFormType {
    HUMAN("Hugh Mann", 100), MARTIAN("Marvin", 120), PLAIN_BELLY_SNEETCH("Paul", 75), STAR_BELLY_SNEETCH("Starry", 85);

    private int currentLifePoints;
    private String name;

    private LifeFormType(final String name, final int currentLifePoints){
        if(name==null||name.isEmpty()||currentLifePoints<=0)
            throw new IllegalArgumentException("Bad params in LifeFormType constructor");
        this.name = name;
        this.currentLifePoints=currentLifePoints;
    }
    public String getName(){
        return this.name;
    }
    public int getCurrentLifePoints(){
        return this.currentLifePoints;
    }
}
