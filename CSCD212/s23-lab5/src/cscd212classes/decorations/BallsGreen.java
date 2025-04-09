package cscd212classes.decorations;
import cscd212interfaces.HolidayItem;

public class BallsGreen extends HolidayItemDecorator{

     public BallsGreen(final HolidayItem item, final double cost){
         super(item,"BallsGreen",cost);
     }

    @Override
    public double getCost() {
        return super.getItemCost()+this.item.getCost();
    }

    public String getDescription(){
        return this.item.getDescription()+"Green Ball Ornaments, ";
    }
}
