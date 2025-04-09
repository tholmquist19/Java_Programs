package cscd212classes.decorations;
import cscd212interfaces.HolidayItem;

public class BallsRed extends HolidayItemDecorator{

    public BallsRed(final HolidayItem item, final double cost){
        super(item,"BallsRed",cost);
    }

    @Override
    public double getCost() {
        return super.getItemCost()+this.item.getCost();
    }

    public String getDescription(){
        return this.item.getDescription()+"Red Ball Ornaments, ";
    }
}
