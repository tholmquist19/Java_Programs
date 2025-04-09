package cruiseCreator;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import portCreator.*;
import shipCreator.*;
import cruiseEnums.*;
import java.util.Scanner;
import java.io.File;

public class CruiseManager {

    private CruiseShip ship;
    private CruisePort startPort;
    private CruisePort endPort;
    private ArrayList<CruisePort> ports = new ArrayList();
    private ArrayList<Cruise> cruises = new ArrayList();
    private Cruise cruise;


    private void createCruiseShip(final CruiseType type, final String parentComp, final String shipName){
        if(type==null||parentComp==null||parentComp.isEmpty()||shipName==null||shipName.isEmpty())
            throw new IllegalArgumentException("Bad params in createCruiseShip");
        CruiseShip newShip = CruiseShipFactory.getCruiseShip(type, parentComp, shipName);
        this.ship = newShip;
    }

    private CruisePort createCruisePort(final String locName, final String countryCode){
        if(locName==null||locName.isEmpty()||countryCode==null||countryCode.isEmpty())
            throw new IllegalArgumentException("Bad params in createCruisePort");
        int flag=0;
        CruisePort port = new CruisePort(locName, countryCode);
        for(int i=0;i<this.ports.size();i++){
            if(this.ports.get(i).toString().equals(port.toString()))
                flag=1;
        }
        if(flag==0)
            this.ports.add(port);
        return port;
    }


    public void makeCruises(){
        String parentComp="";
        String shipName="";
        String data;
        int counter =1;
        Cruise newCruise=null;

        File ships = new File("ships.txt");
        Scanner fin = null;
        try {
            fin = new Scanner(ships);
        } catch (FileNotFoundException e) {
            System.out.println("ships.txt is not found");
        }

        File ports = new File("ports.txt");
        Scanner portRead = null;
        try {
            portRead = new Scanner(ports);
        } catch (FileNotFoundException e) {
            System.out.println("ports.txt is not found");
        }

        data = fin.nextLine();
        String[] shipData = data.split(",");
        parentComp = shipData[0].strip();
        shipName = shipData[1].strip();
        String shipName2 = shipData[2].strip();
        String shipName3 = shipData[3].strip();
        String shipName4 = shipData[4].strip();


        for(int i=0; i<4; i++) {
            while (portRead.hasNext()) {
                data = portRead.nextLine();
                String[] portData = data.split(",");
                if(portData[0]=="") {
                    break;
                }
                String locName = portData[0].strip();
                String countryCode = portData[1].strip();
                createCruisePort(locName, countryCode);
            }
            this.startPort=this.ports.get(0);
            this.endPort = this.ports.get(this.ports.size()-1);
            if(counter == 1) {
                createCruiseShip(CruiseType.ADULT, parentComp, shipName);
                newCruise = new Cruise(this.ship, this.startPort, this.endPort, this.ports);
                newCruise.setCost(499);
                newCruise.setDepartureDate(2023,5,18);
                newCruise.setDaysAtDestination(4);
                newCruise.setDaysToDestination(6);
            }
            if(counter==2) {
                createCruiseShip(CruiseType.FAMILY, parentComp, shipName2);
                newCruise = new Cruise(this.ship, this.startPort, this.endPort, this.ports);
                newCruise.setCost(799);
                newCruise.setDepartureDate(2023,12,4);
                newCruise.setDaysAtDestination(3);
                newCruise.setDaysToDestination(3);
            }
            if(counter==3) {
                createCruiseShip(CruiseType.PARTY, parentComp, shipName3);
                newCruise = new Cruise(this.ship, this.startPort, this.endPort, this.ports);
                newCruise.setCost(399);
                newCruise.setDepartureDate(2023,8,14);
                newCruise.setDaysAtDestination(2);
                newCruise.setDaysToDestination(4);
            }
            if(counter==4){
                createCruiseShip(CruiseType.DISNEY, parentComp, shipName4);
                newCruise = new Cruise(this.ship, this.startPort, this.endPort, this.ports);
                newCruise.setCost(599);
                newCruise.setDepartureDate(2024,2,16);
                newCruise.setDaysAtDestination(2);
                newCruise.setDaysToDestination(3);
                counter=0;
            }
            counter++;

            this.cruises.add(newCruise);
            this.ports= new ArrayList();
        }

    }

    public Cruise displayCruises() {
        Scanner kb = new Scanner(System.in);
        int decision;
        System.out.println("Enter 1 to search for cruises or enter 2 to display available cruises: ");
        decision = kb.nextInt();
        if(decision==1) {
            String sp, dp, dd="";
            do {
                System.out.println("Enter start port(country code, location name): ");
                sp = kb.nextLine();
            }while(sp.equals(""));
            System.out.println("Enter destination port(country code, location name): ");
            dp = kb.nextLine();
            System.out.println("Enter departure date(year(4 digit)-month(2 digit)-day(2 digit): ");
            dd = kb.nextLine();
            for (int i = 0; i < this.cruises.size(); i++) {
                if (this.cruises.get(i).getStartPort().toString().equals(sp))
                    if (this.cruises.get(i).getDestinationPort().toString().equals(dp))
                        if (this.cruises.get(i).getDepartureDate().toString().equals(dd))
                            return this.cruises.get(i);
            }
            System.out.println("We don't have a cruise matching those specifications, here are the cruises that we offer:");
            System.out.println();
        }
        int choice;
        do {
            System.out.println("Please choose from the following");
            System.out.println();
            System.out.println("1) " + this.cruises.get(0).toString());
            System.out.println("2) " + this.cruises.get(1).toString());
            System.out.println("3) " + this.cruises.get(2).toString());
            System.out.println("4) " + this.cruises.get(3).toString());
            System.out.print("Choice --> ");
            choice = kb.nextInt();
            kb.nextLine();
        } while (choice < 1 || choice > 4);

        this.ship=(this.cruises.get(choice-1).getShip());
        return this.cruises.get(choice - 1);
    }

    private CruisePackage packageSelect(){
        Scanner kb = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please choose your cruise package");
            System.out.println();
            System.out.println("1) "+ CruisePackage.ALLINCLUSIVE.getName()+", Charge: "+CruisePackage.ALLINCLUSIVE.getCharge());
            System.out.println("2) "+ CruisePackage.FREEFOOD.getName()+", Charge: "+CruisePackage.FREEFOOD.getCharge());
            System.out.println("3) "+ CruisePackage.FREEDRINKS.getName()+", Charge: "+CruisePackage.FREEDRINKS.getCharge());
            System.out.println("4) "+ CruisePackage.FREESHOWS.getName()+", Charge: "+CruisePackage.FREESHOWS.getCharge());
            System.out.println("5) "+ CruisePackage.NOPACK.getName()+", Charge: "+CruisePackage.NOPACK.getCharge());
            System.out.print("Choice --> ");
            choice = kb.nextInt();
            kb.nextLine();
        } while (choice < 1 || choice > 5);

        if(choice==1)
            return CruisePackage.ALLINCLUSIVE;
        if(choice==2)
            return CruisePackage.FREEFOOD;
        if(choice==3)
            return CruisePackage.FREEDRINKS;
        if(choice==4)
            return CruisePackage.FREESHOWS;
        else return CruisePackage.NOPACK;
    }

    private Room roomTypeSelect(){
        Scanner kb = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please choose your room type");
            System.out.println();
            System.out.println("1) "+ Room.INCABIN.getName()+", Cost: "+Room.INCABIN.getCost());
            System.out.println("2) "+ Room.BALCONYCABIN.getName()+", Cost: "+Room.BALCONYCABIN.getCost());
            System.out.println("3) "+ Room.CABINSUITE.getName()+", Cost: "+Room.CABINSUITE.getCost());
            System.out.println("4) "+ Room.PORTCABIN.getName()+", Cost: "+Room.PORTCABIN.getCost());
            System.out.print("Choice --> ");
            choice = kb.nextInt();
            kb.nextLine();
        } while (choice < 1 || choice > 4);

        if(choice==1)
            return Room.INCABIN;
        if(choice==2)
            return Room.BALCONYCABIN;
        if(choice==3)
            return Room.CABINSUITE;
        else return Room.PORTCABIN;
    }


    public Cruise designCruise(){
        this.cruise = displayCruises();
        this.ship.setPackageChoice(packageSelect());
        System.out.println(new PackageBuilder(this.ship.getPackageChoice()));
        this.ship.setRoomType(roomTypeSelect());
        System.out.println(new RoomTypeBuilder(this.ship.getRoomType()));
        return this.cruise;
    }

    public Cruise getCruise() {
        return this.cruise;
    }

    public void displayCruiseSystemDetails() {
        int length = (this.cruise.getDaysToDestination() * 2) + this.cruise.getDaysAtDestination();
        int cost = this.cruise.getCost() + this.ship.getCruisePackage().getCharge() + this.ship.getRoom().getCost();

        String portList = "";
        for (int i = 1; i < this.cruise.getPorts().size() - 1; i++) {
            portList += this.cruise.getPorts().get(i).toString();
            if (i < this.cruise.getPorts().size() - 2)
                portList += "\n";
        }
        if (portList == "")
            portList = " none";

        System.out.println("\nCruise:\nYou have selected the " + length +
                " day " + this.ship.getType() + " cruise to " + this.cruise.getDestinationPort() + " on the " + this.ship.getShipName() +
                " offered by " + this.ship.getParentCompany() +
                " with the " + this.ship.getCruisePackage().getName() + " package " + "\n" +
                "Your cruise will be departing on " + this.cruise.getDepartureDate() +
                " out of " + this.cruise.getStartPort() + "\n" + "The cruise will take " + this.cruise.getDaysToDestination() +
                " days to arrive at " + this.cruise.getDestinationPort() + " and will spend " + this.cruise.getDaysAtDestination() +
                " days at its destination\n" +
                "You booked the " + this.ship.getRoom().getName() +
                " room, your room is " + this.ship.getRoom().getDeckName() + this.ship.getRoom().getRoomNum() + "\n" +
                "Ports the cruise will stop by on the way to destination include:\n" + portList + "\n" + this.ship + "\n"
                + "The final cost of your cruise is $" + cost);
    }
}

