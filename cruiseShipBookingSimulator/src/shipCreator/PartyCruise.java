package shipCreator;
import cruiseEnums.CruiseType;

public class PartyCruise extends CruiseShip {


    public PartyCruise(final String parentCompany, final String shipName) {
        super(parentCompany, shipName);
        super.setMaxCapacity(3892);
        this.type=CruiseType.PARTY;
    }

    public void buildEvents(){
        this.events.add("Night Club");
        this.events.add("Party Nights on the Deck");
        this.events.add("Pool Parties and Various Events");
        this.events.add("Recovery Spa(Open mornings and afternoon)");
    }
}
