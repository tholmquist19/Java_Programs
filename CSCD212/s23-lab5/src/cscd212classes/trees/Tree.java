package cscd212classes.trees;
import cscd212interfaces.HolidayItem;

public abstract class Tree implements HolidayItem{

    private String treeType;
    protected double cost;

    public Tree(final String treeType, final double cost){
        this.treeType=treeType;
        this.cost=cost;
    }
    public double getCost(){
        return this.cost;
    }
    public String getDescription(){
        return "My tree is a "+this.treeType+" with ";
    }
    public String toString(){
        return "My tree is a "+this.treeType;
    }

}
