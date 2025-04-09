package cruiseCreator;
import cruiseEnums.CruiseType;
import portCreator.CruisePort;
import shipCreator.CruiseShip;
import java.util.ArrayList;
import java.time.LocalDate;
import java.beans.*;

public class Cruise {

    private CruiseShip ship;
    private CruisePort startPort;
    private CruisePort destinationPort;
    private ArrayList<CruisePort> ports;
    private LocalDate departureDate;
    private int daysAtDestination;
    private int daysToDestination;
    private int cost;
    private PropertyChangeSupport pcs;

    public Cruise(final CruiseShip ship, final CruisePort startPort, final CruisePort destinationPort,
                  final ArrayList<CruisePort> ports){
        if(ship==null || startPort==null || destinationPort==null || ports==null)
            throw new IllegalArgumentException("Bad params in Cruise constructor");
        this.ship = ship;
        this.startPort=startPort;
        this.destinationPort=destinationPort;
        this.ports=ports;
        this.pcs= new PropertyChangeSupport(this);
    }


    public void setDepartureDate(final int year, final int month, final int day){
        if(year<0||month<0||month>12||day<0||day>31)
            throw new IllegalArgumentException("Date doesn't exist");
        this.departureDate=LocalDate.of(year, month, day);
    }

    public void setDaysAtDestination(final int days){
        if(days<0)
            throw new IllegalArgumentException("days cant be less than zero");
        this.daysAtDestination=days;
    }

    public void setDaysToDestination(final int days){
        if(days<0)
            throw new IllegalArgumentException("Days can't be less than zero");
        this.daysToDestination=days;
    }

    public void updatePrice(final int price){
        if(price<0)
            throw new IllegalArgumentException("Price can't be less than zero");
        int oldVal=this.cost;
        this.cost=price;
        this.pcs.firePropertyChange("Cost has changed", oldVal, this.cost);
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        if(listener==null)
            throw new IllegalArgumentException("bad params in addPropertyChangeListener");
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(final PropertyChangeListener listener)
    {
        if(listener==null)
            throw new IllegalArgumentException("bad params in addPropertyChangeListener");
        this.pcs.removePropertyChangeListener(listener);
    }

    public void setCost(final int cost){
        if(cost<0)
            throw new IllegalArgumentException("cost can't be less than zero");
        this.cost=cost;
    }
    public int getCost(){
        return this.cost;
    }
    public int getDaysToDestination(){
        return this.daysToDestination;
    }
    public int getDaysAtDestination(){
        return this.daysAtDestination;
    }
    public LocalDate getDepartureDate(){
        return this.departureDate;
    }
    public CruisePort getStartPort(){
        return this.startPort;
    }
    public CruisePort getDestinationPort(){
        return this.destinationPort;
    }
    public ArrayList<CruisePort> getPorts(){
        return this.ports;
    }

    public CruiseShip getShip(){
        return this.ship;
    }

    public String toString(){
        String portList="";
        for(int i=1;i<this.ports.size()-1;i++){
            portList+=this.ports.get(i).toString();
            if(i<this.ports.size()-2)
                portList+="\n";
        }
        if(portList=="")
            portList="none";
        return this.daysToDestination*2+this.daysAtDestination+" Day "+this.ship.getType()+" Cruise on the " +
                this.ship.getShipName()+"\n"+"Departure date: "+this.departureDate+"\n"+"Start port: "
                +this.startPort.toString()+
                ", Destination: "+this.destinationPort.toString()+"\n"+"Days to destination: "+
                this.daysToDestination+", "+"Days at destination: "+this.daysAtDestination+"\n"+
                "Other ports stopped at on the way include:\n"+portList+"\n"+this.ship+"\n"+
                "Initial Cost: "+this.cost+"\n";
    }
}
