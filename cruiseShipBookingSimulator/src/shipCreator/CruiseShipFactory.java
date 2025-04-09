package shipCreator;
import cruiseEnums.*;

public class CruiseShipFactory {

    public void CruiseShipFactory(){}

    public static CruiseShip getCruiseShip(final CruiseType type, final String parentComp, final String shipName){
        if(type==null||parentComp==null||parentComp.isEmpty()||shipName==null||shipName.isEmpty())
            throw new IllegalArgumentException("type is null in cruiseShipBuilder");
        if(type==CruiseType.FAMILY)
            return new FamilyCruise(parentComp, shipName);
        if(type==CruiseType.ADULT)
            return new AdultCruise(parentComp, shipName);
        if(type==CruiseType.DISNEY)
            return new DisneyCruise(parentComp, shipName);
        return new PartyCruise(parentComp, shipName);
    }


}
