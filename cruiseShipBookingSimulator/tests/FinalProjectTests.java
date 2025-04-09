import org.junit.jupiter.api.*;
import java.io.*;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;
import cruiseCreator.*;
import cruiseEnums.*;
import portCreator.*;
import shipCreator.*;
import java.util.ArrayList;

public class FinalProjectTests {

    private CruisePort startPort = new CruisePort("Spokane", "WA");
    private CruisePort endPort = new CruisePort("Miami", "FL");
    CruiseShip ship = CruiseShipFactory.getCruiseShip(CruiseType.PARTY, "Princess", "Water");
    ArrayList<CruisePort> ports = new ArrayList();
    Cruise cruise = new Cruise(this.ship, this.startPort,this.endPort, this.ports);
    @Test
    public void testCruiseShipFactory(){
        CruiseShip testShip = CruiseShipFactory.getCruiseShip(CruiseType.PARTY, "Princess", "Diana");
        assertTrue(testShip instanceof CruiseShip);
    }

    @Test
    public void testIsCruise(){
        this.ports.add(startPort);
        this.ports.add(endPort);
        this.ports.add(new CruisePort("Cheney", "WA"));
        assertTrue(this.cruise instanceof Cruise);
    }

    @Test
    public void testDepartureDateSet(){
        this.cruise.setDepartureDate(2023, 5, 17);
        assertEquals("2023-05-17", this.cruise.getDepartureDate().toString());
    }

    @Test
    public void testDaysAtDestinationSet(){
        this.cruise.setDaysAtDestination(4);
        assertEquals(4, this.cruise.getDaysAtDestination());
    }

    @Test
    public void testDaysToDestinationSet(){
        this.cruise.setDaysToDestination(3);
        assertEquals(3, this.cruise.getDaysToDestination());
    }

    @Test
    public void testUpdatePrice(){
        this.cruise.updatePrice(100);
        assertEquals(100, this.cruise.getCost());
    }

    @Test
    public void testCruisePortIsPort(){
        assertTrue(this.startPort instanceof CruisePort);
    }

    @Test
    public void testGetType(){
        assertEquals(CruiseType.PARTY, this.ship.getType());
    }

    @Test
    public void testSetMaxCapacity(){
        this.ship.setMaxCapacity(4000);
        assertEquals(4000, this.ship.getMaxCapacity());
    }

    @Test
    public void testSetRoomType(){
        this.ship.setRoomType(Room.INCABIN);
        assertEquals(Room.INCABIN, this.ship.getRoomType());
    }

    @Test
    public void testSetPackageChoice(){
        this.ship.setPackageChoice(CruisePackage.ALLINCLUSIVE);
        assertEquals(CruisePackage.ALLINCLUSIVE, this.ship.getPackageChoice());
    }

    @Test
    public void testAdultType(){
        CruiseShip newShip = CruiseShipFactory.getCruiseShip(CruiseType.ADULT, "Princess", "Water");
        assertEquals(CruiseType.ADULT, newShip.getType());
    }

    @Test
    public void testPartyType(){
        CruiseShip newShip = CruiseShipFactory.getCruiseShip(CruiseType.PARTY, "Princess", "Water");
        assertEquals(CruiseType.PARTY, newShip.getType());
    }

    @Test
    public void testFamilyType(){
        CruiseShip newShip = CruiseShipFactory.getCruiseShip(CruiseType.FAMILY, "Princess", "Water");
        assertEquals(CruiseType.FAMILY, newShip.getType());
    }

    @Test
    public void testDisneyType(){
        CruiseShip newShip = CruiseShipFactory.getCruiseShip(CruiseType.DISNEY, "Princess", "Water");
        assertEquals(CruiseType.DISNEY, newShip.getType());
    }

    @Test
    public void InCabinRoomBuilderTest(){
        assertEquals("You chose the In Cabin room. Your room is A18", new RoomTypeBuilder(Room.INCABIN).toString());
    }

    @Test
    public void BalconyCabinRoomBuilderTest(){
        assertEquals("You chose the Balcony Cabin room. Your room is C24", new RoomTypeBuilder(Room.BALCONYCABIN).toString());
    }

    @Test
    public void PortCabinRoomBuilderTest(){
        assertEquals("You chose the Port Cabin room. Your room is B13", new RoomTypeBuilder(Room.PORTCABIN).toString());
    }

    @Test
    public void CabinSuiteRoomBuilderTest(){
        assertEquals("You chose the Cabin Suite room. Your room is D1", new RoomTypeBuilder(Room.CABINSUITE).toString());
    }

    @Test
    public void AllInclusivePackageBuilderTest(){
        assertEquals("You have selected the All Inclusive package. " +
                "This allows you free access to all food, drinks and shows during the duration of your cruise",
                new PackageBuilder(CruisePackage.ALLINCLUSIVE).toString());
    }

    @Test
    public void FreeShowsPackageBuilderTest(){
        assertEquals("You have selected the Free Shows package. " +
                "This allows you free viewing of all our shows during the duration of your cruise",
                new PackageBuilder(CruisePackage.FREESHOWS).toString());
    }

    @Test
    public void FreeDrinksPackageBuilderTest(){
        assertEquals("You have selected the Free Drinks package. " +
                "This allows you free access to all drinks during the duration of your cruise",
                new PackageBuilder(CruisePackage.FREEDRINKS).toString());
    }

    @Test
    public void FreeFoodPackageBuilderTest(){
        assertEquals("You have selected the Free Food package. " +
                "This allows you free access to all marked foods during the duration of your cruise",
                new PackageBuilder(CruisePackage.FREEFOOD).toString());
    }

    @Test
    public void NoPackPackageBuilderTest(){
        assertEquals("You have selected the No Package package. " +
                "This allows you all the basic amenities during the duration of your cruise",
                new PackageBuilder(CruisePackage.NOPACK).toString());
    }

    @Test
    public void PartyCruiseShipFactoryTest(){
        CruiseShip testShip = CruiseShipFactory.getCruiseShip(CruiseType.PARTY, "Princess", "Diana");
        assertEquals(CruiseType.PARTY, testShip.getType());
    }

    @Test
    public void AdultCruiseShipFactoryTest(){
        CruiseShip testShip = CruiseShipFactory.getCruiseShip(CruiseType.ADULT, "Princess", "Diana");
        assertEquals(CruiseType.ADULT, testShip.getType());
    }

    @Test
    public void FamilyCruiseShipFactoryTest(){
        CruiseShip testShip = CruiseShipFactory.getCruiseShip(CruiseType.FAMILY, "Princess", "Diana");
        assertEquals(CruiseType.FAMILY, testShip.getType());
    }

    @Test
    public void DisneyCruiseShipFactoryTest(){
        CruiseShip testShip = CruiseShipFactory.getCruiseShip(CruiseType.DISNEY, "Princess", "Diana");
        assertEquals(CruiseType.DISNEY, testShip.getType());
    }

    @Test
    public void testAdultEvents(){
        CruiseShip testShip = CruiseShipFactory.getCruiseShip(CruiseType.ADULT, "Princess", "Diana");
        assertTrue(testShip.getEvents().get(0).equals("Wine Tasting")&&
                testShip.getEvents().get(1).equals("Water Aerobics")&&
                testShip.getEvents().get(2).equals("Tour of Inner Workings of the Ship")&&
                testShip.getEvents().get(3).equals("Relaxing Massage and Spa"));
    }

    @Test
    public void testFamilyEvents(){
        CruiseShip testShip = CruiseShipFactory.getCruiseShip(CruiseType.FAMILY, "Princess", "Diana");
        assertTrue(testShip.getEvents().get(0).equals("Circus Show")&&
                testShip.getEvents().get(1).equals("Pool Volleyball")&&
                testShip.getEvents().get(2).equals("Arts and Crafts Class")&&
                testShip.getEvents().get(3).equals("Movie Night on the Deck"));
    }

    @Test
    public void testPartyEvents(){
        CruiseShip testShip = CruiseShipFactory.getCruiseShip(CruiseType.PARTY, "Princess", "Diana");
        assertTrue(testShip.getEvents().get(0).equals("Night Club")&&
                testShip.getEvents().get(1).equals("Party Nights on the Deck")&&
                testShip.getEvents().get(2).equals("Pool Parties and Various Events")&&
                testShip.getEvents().get(3).equals("Recovery Spa(Open mornings and afternoon)"));
    }

    @Test
    public void testDisneyEvents(){
        CruiseShip testShip = CruiseShipFactory.getCruiseShip(CruiseType.DISNEY, "Princess", "Diana");
        assertTrue(testShip.getEvents().get(0).equals("Disney Musicals")&&
                testShip.getEvents().get(1).equals("Meet your Favorite Characters Form your Favorite Movies")&&
                testShip.getEvents().get(2).equals("Mickey and Friends Hosted Deck Party")&&
                testShip.getEvents().get(3).equals("Different Movie themed Restaurant Experiences Every Night"));
    }


    @Test
    public void AllInclusiveCruisePackageGetChargeTest(){
        assertEquals(200, CruisePackage.ALLINCLUSIVE.getCharge());
    }

    @Test
    public void FreeFoodCruisePackageGetChargeTest(){
        assertEquals(100, CruisePackage.FREEFOOD.getCharge());
    }

    @Test
    public void FreeDrinksCruisePackageGetChargeTest(){
        assertEquals(75, CruisePackage.FREEDRINKS.getCharge());
    }

    @Test
    public void FreeShowsCruisePackageGetChargeTest(){
        assertEquals(50, CruisePackage.FREESHOWS.getCharge());
    }

    @Test
    public void NoPackCruisePackageGetChargeTest(){
        assertEquals(0, CruisePackage.NOPACK.getCharge());
    }

    @Test
    public void inCabinRoomGetNameTest(){
        assertEquals("In Cabin", Room.INCABIN.getName());
    }

    @Test
    public void CabinSuiteRoomGetNameTest(){
        assertEquals("Cabin Suite", Room.CABINSUITE.getName());
    }

    @Test
    public void PortCabinRoomGetNameTest(){
        assertEquals("Port Cabin", Room.PORTCABIN.getName());
    }

    @Test
    public void BalconyCabinRoomGetNameTest(){
        assertEquals("Balcony Cabin", Room.BALCONYCABIN.getName());
    }

    @Test
    public void inCabinRoomGetRoomNumTest(){
        assertEquals(18, Room.INCABIN.getRoomNum());
    }

    @Test
    public void CabinSuiteRoomGetRoomNumTest(){
        assertEquals(1, Room.CABINSUITE.getRoomNum());
    }

    @Test
    public void PortCabinRoomGetRoomNumTest(){
        assertEquals(13, Room.PORTCABIN.getRoomNum());
    }

    @Test
    public void BalconyCabinRoomGetRoomNumTest(){
        assertEquals(24, Room.BALCONYCABIN.getRoomNum());
    }

    @Test
    public void inCabinRoomGetCostTest(){
        assertEquals(50, Room.INCABIN.getCost());
    }

    @Test
    public void CabinSuiteRoomGetCostTest(){
        assertEquals(150, Room.CABINSUITE.getCost());
    }

    @Test
    public void PortCabinRoomGetCostTest(){
        assertEquals(70, Room.PORTCABIN.getCost());
    }

    @Test
    public void BalconyCabinRoomGetCostTest(){
        assertEquals(100, Room.BALCONYCABIN.getCost());
    }

    @Test
    public void inCabinRoomGetDeckNameTest(){
        assertEquals('A', Room.INCABIN.getDeckName());
    }

    @Test
    public void CabinSuiteRoomGetDeckNameTest(){
        assertEquals('D', Room.CABINSUITE.getDeckName());
    }

    @Test
    public void PortCabinRoomGetDeckNameTest(){
        assertEquals('B', Room.PORTCABIN.getDeckName());
    }

    @Test
    public void BalconyCabinRoomGetDeckNameTest(){
        assertEquals('C', Room.BALCONYCABIN.getDeckName());
    }

}
