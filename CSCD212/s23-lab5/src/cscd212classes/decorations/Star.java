package cscd212classes.decorations;
import cscd212interfaces.HolidayItem;


public class Star extends HolidayItemDecorator{

    public Star(final HolidayItem item, final double cost){
        super(item,"Star",cost);
    }

    @Override
    public double getCost() {
        return super.getItemCost()+this.item.getCost();
    }

    public String getDescription(){
        return this.item.getDescription()+"and a Tree Top "+super.getName();
    }
}
