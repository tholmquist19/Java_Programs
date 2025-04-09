package shipCreator;
import cruiseEnums.CruiseType;

public class FamilyCruise extends CruiseShip {

    public FamilyCruise(final String parentCompany, final String shipName) {
        super(parentCompany, shipName);
        super.setMaxCapacity(3300);
        this.type=CruiseType.FAMILY;
    }

    public void buildEvents(){
        this.events.add("Circus Show");
        this.events.add("Pool Volleyball");
        this.events.add("Arts and Crafts Class");
        this.events.add("Movie Night on the Deck");
    }
}
