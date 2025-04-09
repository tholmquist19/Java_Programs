package cscd212classes.lab3;
import java.util.ArrayList;
import cscd212classes.lab3.players.Player;
import cscd212interfaces.lab3.Payroll;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Team implements Payroll, Comparable<Team>{
    protected String city;
    protected int payroll;
    protected ArrayList<Player> players = new ArrayList<>();
    protected String teamName;

    NumberFormat myFormat = NumberFormat.getInstance();
    public Team(final String city, final String teamName, final Player[] player) throws CloneNotSupportedException{
        if(city==null||teamName==null||player==null||player.length<=0||city.isEmpty()||teamName.isEmpty())
            throw new IllegalArgumentException("Bad Params in Team Constructor");
        this.city = city;
        this.teamName = teamName;
        for(int i=0; i<player.length; i++){
            this.players.add(player[i].clone());
            this.players.trimToSize();
        }
        this.payroll = this.calculatePayroll();
    }

    public String getTeamName(){
        return this.teamName;
    }
    public String getCity(){
        return this.city;
    }
    public int getPayroll(){
        return this.payroll;
    }
    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    public String toString(){
        String p = "";
        for(int i=0; i<this.players.size(); i++){
            p+=this.players.get(i).toString()+"\n";
        }
        return this.city+" - "+this.teamName+"\n"+"Payroll: $"+this.myFormat.format(this.payroll)+".00\n"+
                "----------------------------------------------------------------------------"+"\n"+p+"\n";

    }
    @Override
    public int calculatePayroll() {
        int fin = 0;
        for(int i=0; i<this.players.size(); i++){
            fin+=this.players.get(i).getSalary();
        }
        return fin+BASE_PAYROLL;
    }

    @Override
    public int compareTo(final Team o) {
        if(o==null)
            throw new IllegalArgumentException("Bad Params in compareTo");
        if(this.city==o.getCity())
            return(CharSequence.compare(this.teamName,o.teamName));
        return CharSequence.compare(this.city,o.getCity());
    }
}
