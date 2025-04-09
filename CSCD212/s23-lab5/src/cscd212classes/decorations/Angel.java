package cscd212classes.decorations;
import cscd212interfaces.HolidayItem;

public class Angel extends HolidayItemDecorator{

    public Angel(final HolidayItem item, final double cost){
        super(item, "Angel",cost);
    }

    @Override
    public double getCost() {
        return super.getItemCost()+this.item.getCost();
    }

    public String getDescription(){
        return this.item.getDescription()+"and a "+super.getName();
    }
}
