package cscd212classes.lab3.players;

public class BaseballPlayer extends Player implements Cloneable{

    protected double batAvg;

    public BaseballPlayer(final String name, final String ssn, final int salary, final String position,
                             final double batAvg) {
        super(name, ssn, salary, position);
        if(batAvg<0)
            throw new IllegalArgumentException("Bad Params in BaseballPlayer Constructor");
        this.batAvg = batAvg;
    }
    public String toString(){
        return super.toString()+"\t\t"+this.batAvg;
    }
    public BaseballPlayer clone() throws CloneNotSupportedException{
        return (BaseballPlayer)super.clone();
    }

}
