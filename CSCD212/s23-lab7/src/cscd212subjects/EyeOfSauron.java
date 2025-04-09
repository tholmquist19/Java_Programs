package cscd212subjects;
import java.beans.*;
import cscd212dataobjects.GoodGuys;

public class EyeOfSauron {

    private int dwarves;
    private int elves;
    private int hobbits;
    private int humans;
    private PropertyChangeSupport pcs;

    public EyeOfSauron(){
        this.dwarves=0;
        this.elves=0;
        this.hobbits=0;
        this.humans=0;
        this.pcs= new PropertyChangeSupport(this);
    }

    public void update(final GoodGuys gg){
        int oldHobbits=this.hobbits;
        int oldElves=this.elves;
        int oldDwarves=this.dwarves;
        int oldHumans=this.humans;

        this.hobbits=gg.getHobbits();
        this.elves=gg.getElves();
        this.dwarves=gg.getDwarves();
        this.humans=gg.getHumans();

        this.pcs.firePropertyChange("Hobbits", oldHobbits, this.hobbits);
        this.pcs.firePropertyChange("Elves", oldElves, this.elves);
        this.pcs.firePropertyChange("Dwarves", oldDwarves, this.dwarves);
        this.pcs.firePropertyChange("Humans", oldHumans, this.humans);
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener)
    {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(final PropertyChangeListener listener)
    {
        this.pcs.removePropertyChangeListener(listener);
    }
}
