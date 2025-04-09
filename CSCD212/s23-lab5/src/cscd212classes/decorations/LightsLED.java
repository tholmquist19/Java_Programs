package cscd212classes.decorations;
import cscd212interfaces.HolidayItem;

public class LightsLED extends HolidayItemDecorator{

    public LightsLED(final HolidayItem item, final double cost){
        super(item,"LightsLED",cost);
    }

    @Override
    public double getCost() {
        return super.getItemCost()+this.item.getCost();
    }

    public String getDescription(){
        return this.item.getDescription()+"LED Lights, ";
    }
}
