package cscd212classes.lab3.players;
import java.text.NumberFormat;

public abstract class Player implements Cloneable{
    protected String name;
    protected String position;
    protected int salary;
    protected String ssn;

    NumberFormat myFormat = NumberFormat.getInstance();

    protected Player(final String name, final String ssn, final int salary, final String position){
        if(name==null||ssn==null||position==null||name.isEmpty()||ssn.isEmpty()||position.isEmpty())
            throw new IllegalArgumentException("Bad Params in Player Constructor");
        this.name = name;
        this.ssn = ssn;
        this.position = position;
        this.salary = salary;
    }
    public int getSalary(){
        return this.salary;
    }
    public String getSsn(){
        return this.ssn;
    }
    public String getPosition(){
        return this.position;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return this.name+"\t\t"+this.ssn+"\t\t"+"$"+this.myFormat.format(this.salary)+".00\t\t"+this.position;
    }
    public Player clone() throws CloneNotSupportedException{
        return (Player)super.clone();
    }

}
