package cruiseCreator;
import java.beans.*;

public class User implements PropertyChangeListener{

    public User(){
    }

    public void add(final Cruise cruise){
        if(cruise==null)
            throw new IllegalArgumentException("Bad params in add method");
        System.out.println("You have been added to the deals watch list ");
        cruise.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        if(evt==null)
            throw new IllegalArgumentException("Bad params in propertyChange");
        System.out.println("The price of the cruise has been changed from "+evt.getOldValue()
                +" to "+evt.getNewValue());
    }
}
