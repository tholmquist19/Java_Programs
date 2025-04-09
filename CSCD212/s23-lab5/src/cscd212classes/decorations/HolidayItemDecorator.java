package cscd212classes.decorations;
import cscd212interfaces.HolidayItem;

public abstract class HolidayItemDecorator implements HolidayItem{

    protected double cost;
    protected HolidayItem item;
    protected String name;

    public HolidayItemDecorator(final HolidayItem item, final String name, final double cost){
        this.cost = cost;
        this.item = item;
        this.name = name;
    }

    protected double getItemCost(){
        return this.cost;
    }
    protected String getName(){
        return this.name;
    }

    public String getDescription(){
        return "";
    }

}
