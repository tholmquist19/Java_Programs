package cscd212classes.decorations;
import cscd212interfaces.HolidayItem;

public class Tinsel extends HolidayItemDecorator{

    public Tinsel(final HolidayItem item, final double cost){
        super(item,"Tinsel",cost);
    }

    @Override
    public double getCost() {
        return super.getItemCost()+this.item.getCost();
    }

    public String getDescription(){
        return this.item.getDescription()+super.getName()+", ";
    }
}
