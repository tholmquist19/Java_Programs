package cscd212lab7;

import cscd212dataobjects.*;
import cscd212observers.*;
import cscd212subjects.*;

/**
 * This program implements the PropertyChangeListener and PropertyChangeEvent.
 * <br>Your task is to take the ObserverLOR code and convert it to PCL and PCE
 * <br>EyeOfSauron is the subject (Observable), BadGuys are the observers, GoodGuys is the data.
 * <br>This program uses the update method to get data to the observers.
 * <br>Use the sample code provided for both LOR Observer and PCL and PCE<br>
 * <br>GoodGuys package is cscd212dataobjects
 * <br>BadGuys package is cscd212observers
 * <br>EyeOfSauron package is cscd212subjects
 * <br>You can't change this main
 * <br>All preconditions will be met and all parameters will be final
 */

public class PropertyChangeMainLOR {
    /**
     * The main method
     * @param args Representing the command line parameters
     */
    public static void main(final String[] args) {
        System.out.println("Registering EyeOfSauron as the Subject (Observable Object)");
        EyeOfSauron eye = new EyeOfSauron(); // Subject

        System.out.println("Good guys forming the resistance (Data Object)");
        GoodGuys heros = new GoodGuys(1, 2, 3, 4);

        System.out.println();
        System.out.println("Registering Sauruman as an observer");
        BadGuy saruman = new BadGuy("Sauruman");
        saruman.add(eye); // Observer

        System.out.println();
        System.out.println("EyeOfSauron has spotted good guys, notifying the bad guys\n");
        eye.update(heros);

        System.out.println();
        System.out.println("Registering The Witch King as a second observer");
        BadGuy witchKing = new BadGuy("Witch King");
        witchKing.add(eye); // Observer

        System.out.println();
        System.out.println("Updating the Good Guys to add hobbits, elves, dwarves and no humans");
        heros.update(1, 12, 20, 0); // Data Object


        System.out.println();
        System.out.println("EyeOfSauron has spotted more good guys, notifying the bad guys\n");
        eye.update(heros);  // Method to get data to subject

        System.out.println();
        System.out.println("Removing the Witch King as a second observer");
        witchKing.remove(eye); //Removes from Observer list

        System.out.println();
        System.out.println("Updating the Good Guys to add hobbits, elves, dwarves and humans");
        heros.update(4, -2, -5, 100);

        System.out.println();
        System.out.println("EyeOfSauron has spotted more good guys, notifying the bad guys\n");
        eye.update(heros);

    }// end main

}// end class