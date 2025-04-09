package cscd212classes.factories;
import cscd212classes.lifeform.*;
import cscd212enums.LifeFormType;

public class LifeFormFactory {
    public LifeFormFactory(){}
    public static LifeForm getLifeForm(final LifeFormType lifeFormType, final String name, final int currentLifePoints){
        if(name==null||name.isEmpty()||currentLifePoints<=0)
            throw new IllegalArgumentException("Bad params in getLifeForm");
        if(lifeFormType==LifeFormType.HUMAN)
            return new Human(name, currentLifePoints);
        if(lifeFormType==LifeFormType.MARTIAN)
            return new Martian(name, currentLifePoints);
        if(lifeFormType==LifeFormType.PLAIN_BELLY_SNEETCH)
            return new PlainBellySneetch(name, currentLifePoints);
        return new StarBellySneetch(name, currentLifePoints);
    }

    public static LifeForm getLifeForm(final LifeFormType lifeFormType){
        return getLifeForm(lifeFormType, lifeFormType.getName(), lifeFormType.getCurrentLifePoints());
    }
}
