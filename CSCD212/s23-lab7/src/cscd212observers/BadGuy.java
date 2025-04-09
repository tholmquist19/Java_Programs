package cscd212observers;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import cscd212subjects.EyeOfSauron;

public class BadGuy implements PropertyChangeListener{

    String name;

    public BadGuy(final String name){
        this.name = name;
    }

    public void remove(final EyeOfSauron eye){
        System.out.println(this.name + " was defeated");
        eye.removePropertyChangeListener(this);
        System.out.println();
    }

    public void add(final EyeOfSauron eye){
        System.out.println(this.name + " was added as an observer of EyeOfSauron");
        eye.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        System.out.println(this.name + " - Changed property: "+evt.getPropertyName()+" [old -> "+evt.getOldValue()
        +"] | [new -> "+evt.getNewValue()+"]");
    }
}
