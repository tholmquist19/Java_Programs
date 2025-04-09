package cscd212classes.lab3.players;

public class HockeyPlayer extends Player implements Cloneable{

    protected int jerseyNumber;
    public HockeyPlayer(final String name, final String ssn, final int salary, final String position, final int jn) {
        super(name, ssn, salary, position);
        if(jn<0)
            throw new IllegalArgumentException("Bad Params in HockeyPlayer Constructor");
        this.jerseyNumber=jn;
    }
    public String toString(){
        return super.toString()+"\t\t"+this.jerseyNumber;
    }
    public HockeyPlayer clone() throws CloneNotSupportedException{
        return (HockeyPlayer)super.clone();
    }
}
