package cscd212dataobjects;

public class GoodGuys
{
    private int hobbits;
    private int elves;
    private int dwarves;
    private int humans;

    public GoodGuys(final int hobbits, final int elves, final int dwarves, final int humans)
    {
        this.hobbits = hobbits;
        this.elves = elves;
        this.dwarves = dwarves;
        this.humans = humans;
    }

    public void update(final int hobbits, final int elves, final int dwarves, final int humans)
    {
        this.hobbits += hobbits;
        this.elves += elves;
        this.dwarves += dwarves;
        this.humans += humans;
    }

    public int getHobbits() {return this.hobbits;}

    public int getElves() {return this.elves;}

    public int getDwarves() {return this.dwarves;}

    public int getHumans() {return this.humans;}




}