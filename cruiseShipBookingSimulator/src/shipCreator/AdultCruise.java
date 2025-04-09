package shipCreator;
import cruiseEnums.CruiseType;

public class AdultCruise extends CruiseShip {

    public AdultCruise(final String parentCompany, final String shipName) {
        super(parentCompany, shipName);
        super.setMaxCapacity(3000);
        this.type=CruiseType.ADULT;
    }

    public void buildEvents(){
        this.events.add("Wine Tasting");
        this.events.add("Water Aerobics");
        this.events.add("Tour of Inner Workings of the Ship");
        this.events.add("Relaxing Massage and Spa");
    }
}
