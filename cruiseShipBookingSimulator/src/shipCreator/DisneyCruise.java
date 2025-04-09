package shipCreator;
import cruiseEnums.CruiseType;

public class DisneyCruise extends CruiseShip {


    public DisneyCruise(final String parentCompany, final String shipName) {
        super(parentCompany, shipName);
        super.setMaxCapacity(4257);
        this.type=CruiseType.DISNEY;
    }

    public void buildEvents(){
        this.events.add("Disney Musicals");
        this.events.add("Meet your Favorite Characters Form your Favorite Movies");
        this.events.add("Mickey and Friends Hosted Deck Party");
        this.events.add("Different Movie themed Restaurant Experiences Every Night");
    }
}
