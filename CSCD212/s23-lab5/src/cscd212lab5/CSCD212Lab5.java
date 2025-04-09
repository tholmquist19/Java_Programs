package cscd212lab5;

import cscd212classes.trees.*;
import cscd212interfaces.HolidayItem;
import cscd212classes.decorations.*;
import java.text.DecimalFormat;


public class CSCD212Lab5
{
    public static void main(final String[] args)
    {
        DecimalFormat fmt = new DecimalFormat("#,##0.00");

        System.out.println("Off to buy a holiday tree");
        HolidayItem myTree = new BalsamFir(75.50);

        System.out.println("Bought a nice holiday tree");
        System.out.println(myTree);
        System.out.println();

        System.out.println("Adding some holiday ribbons to my holiday tree");
        myTree = new Ribbons(myTree, 2.49);
        System.out.println();

        System.out.println("Adding some red ball ornaments to my holiday tree");
        myTree = new BallsRed(myTree, 4.99);
        System.out.println();

        System.out.println("Adding some LED lights to my holiday tree");
        myTree = new LightsLED(myTree, 12.75);
        System.out.println();

        System.out.println("My holiday tree needs more ribbon or cowbell");
        myTree = new Ribbons(myTree, 2.49);
        System.out.println();

        System.out.println("Adding a star to my holiday tree.");
        myTree = new Star(myTree, 49.99);
        System.out.println();

        System.out.println("My holiday tree is decorated\n");
        System.out.println(myTree.getDescription() + ". The total cost was $" + fmt.format(myTree.getCost()));

        System.out.print("=================================================================");
        System.out.println("===============================================================\n");

        System.out.println("Decided I needed another holiday tree");
        HolidayItem myOtherTree = new ColoradoBlueSpruce(95);

        System.out.println("Bought a another nice holiday tree");
        System.out.println(myOtherTree);
        System.out.println();

        System.out.println("Adding some LED lights to my holiday tree");
        myOtherTree = new LightsLED(myOtherTree, 12.75);
        System.out.println();

        System.out.println("Adding some green ball ornaments to my other holiday tree");
        myOtherTree = new BallsGreen(myOtherTree, 4.25);
        System.out.println();

        System.out.println("Adding some holiday tinsel to my other holiday tree");
        myOtherTree = new Tinsel(myOtherTree, 5.00);
        System.out.println();

        System.out.println("Adding an angel to my other holiday tree.");
        myOtherTree = new Angel(myOtherTree, 29.00);
        System.out.println();

        System.out.println("My other holiday tree is decorated\n");
        System.out.println(myOtherTree.getDescription() + ". The total cost was $" + fmt.format(myOtherTree.getCost()));
    }// end main
}// end class
