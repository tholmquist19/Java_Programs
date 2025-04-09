package cscd212classes.decorations;
import cscd212interfaces.HolidayItem;

public class Ribbons extends HolidayItemDecorator{

    public Ribbons(final HolidayItem item, final double cost){
        super(item,"Ribbons",cost);
    }

    @Override
    public double getCost() {
        return super.getItemCost()+this.item.getCost();
    }

    public String getDescription(){
        return this.item.getDescription()+super.getName()+", ";
    }
}
