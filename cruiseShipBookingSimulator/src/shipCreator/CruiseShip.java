package shipCreator;
import portCreator.CruisePort;
import java.util.*;
import cruiseEnums.*;

public abstract class CruiseShip {

    private Room roomType;
    private String parentCompany;
    private String shipName;
    private CruisePackage packageChoice;
    protected ArrayList<String> events = new ArrayList();
    private int MaxCapacity;
    protected CruiseType type;


    public CruiseShip(final String parentCompany, final String shipName){
        if(parentCompany==null || parentCompany.isEmpty() || shipName==null || shipName.isEmpty())
            throw new IllegalArgumentException("Bad params in CruiseShip constructor");
        this.parentCompany=parentCompany;
        this.shipName=shipName;
        this.buildEvents();
    }

    public abstract void buildEvents();

    public CruiseType getType(){
        return this.type;
    }
    public void setMaxCapacity(final int capacity){
        if(capacity<0)
            throw new IllegalArgumentException("capacity can't be less than zero");
        this.MaxCapacity=capacity;
    }

    public CruisePackage getCruisePackage(){
        return this.packageChoice;
    }

    public void setRoomType(final Room room){
        if(room==null)
            throw new IllegalArgumentException("bad param in setRoomType");
        this.roomType=room;
    }

    public Room getRoomType(){
        return this.roomType;
    }
    public String getParentCompany(){
        return this.parentCompany;
    }
    public String getShipName(){
        return this.shipName;
    }

    public void setPackageChoice(final CruisePackage choice){
        if(choice==null)
            throw new IllegalArgumentException("Bad params in setPackageChoice");
        this.packageChoice=choice;
    }

    public CruisePackage getPackageChoice(){
        return this.packageChoice;
    }

    public int getMaxCapacity(){
        return this.MaxCapacity;
    }

    public Room getRoom(){
        return this.roomType;
    }

    public ArrayList<String> getEvents(){
        return this.events;
    }


    public String toString(){
        String str = "";
        for(int i =0; i<this.events.size(); i++){
            str+=this.events.get(i);
            if(i<this.events.size()-1)
                str+="\n";
        }
        return "Events include:\n"+str;
    }


}
