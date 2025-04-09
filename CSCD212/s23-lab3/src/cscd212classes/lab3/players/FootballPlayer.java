package cscd212classes.lab3.players;

public class FootballPlayer extends Player implements Cloneable{

    protected int jerseyNumber;
    protected int td;
    public FootballPlayer(final String name, final String ssn, final int salary, final String position,
                             final int td, final int jerseyNumber) {
        super(name, ssn, salary, position);
        if(jerseyNumber<0||td<0)
            throw new IllegalArgumentException("Bad Params in FootballPlayer Constructor");
        this.td = td;
        this.jerseyNumber = jerseyNumber;
    }
    public String toString(){
        return super.toString()+"\t\t"+this.td+"\t\t"+this.jerseyNumber;
    }
    public FootballPlayer clone() throws CloneNotSupportedException{
        return (FootballPlayer)super.clone();
    }

}
