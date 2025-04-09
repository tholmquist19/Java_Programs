package cscd212lab5;

import cscd212classes.decorations.Angel;
import cscd212classes.decorations.BallsGreen;
import cscd212classes.decorations.BallsRed;
import cscd212classes.decorations.HolidayItemDecorator;
import cscd212classes.decorations.LightsLED;
import cscd212classes.decorations.Ribbons;
import cscd212classes.decorations.Star;
import cscd212classes.decorations.Tinsel;
import cscd212classes.trees.BalsamFir;
import cscd212classes.trees.ColoradoBlueSpruce;
import cscd212classes.trees.Tree;
import cscd212interfaces.HolidayItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CSCD212Lab5Tests {

    @Nested
    class outputTest {

        private ByteArrayOutputStream out;
        private PrintStream originalOut;
        @BeforeEach
        void setUp() {
            // Setup output
            this.out = new ByteArrayOutputStream();
            this.originalOut = System.out;
            System.setOut(new PrintStream(this.out));
        }

        @AfterEach
        void tearDown() {
            // Return output
            System.setOut(this.originalOut);
        }

        @Test
        void main() {
            String outputText = "Off to buy a holiday tree\n" +
                    "Bought a nice holiday tree\n" +
                    "My tree is a Balsam Fir\n" +
                    "\n" +
                    "Adding some holiday ribbons to my holiday tree\n" +
                    "\n" +
                    "Adding some red ball ornaments to my holiday tree\n" +
                    "\n" +
                    "Adding some LED lights to my holiday tree\n" +
                    "\n" +
                    "My holiday tree needs more ribbon or cowbell\n" +
                    "\n" +
                    "Adding a star to my holiday tree.\n" +
                    "\n" +
                    "My holiday tree is decorated\n" +
                    "\n" +
                    "My tree is a Balsam Fir with Ribbons, Red Ball Ornaments, LED Lights, Ribbons, and a Tree Top Star. The total cost was $148.21\n" +
                    "================================================================================================================================\n" +
                    "\n" +
                    "Decided I needed another holiday tree\n" +
                    "Bought a another nice holiday tree\n" +
                    "My tree is a Colorado Blue Spruce\n" +
                    "\n" +
                    "Adding some LED lights to my holiday tree\n" +
                    "\n" +
                    "Adding some green ball ornaments to my other holiday tree\n" +
                    "\n" +
                    "Adding some holiday tinsel to my other holiday tree\n" +
                    "\n" +
                    "Adding an angel to my other holiday tree.\n" +
                    "\n" +
                    "My other holiday tree is decorated\n" +
                    "\n" +
                    "My tree is a Colorado Blue Spruce with LED Lights, Green Ball Ornaments, Tinsel, and a Angel. The total cost was $146.00\n";
            // Run the program
            CSCD212Lab5.main(new String[0]);
            // check output
            assertEquals(outputText, this.out.toString().replace("\r", ""),
                    "Output does not match our run of the program");
        }
    }

    @ParameterizedTest
    @MethodSource("getHolidayItemDecorators")
    void getCost(final HolidayItem item, final String description, final double cost, final double itemCost) {
        assertEquals(cost, item.getCost());
    }

    @ParameterizedTest
    @MethodSource("getHolidayItemDecorators")
    void getDescription(final HolidayItem item, final String description, final double cost, final double itemCost) {
        assertEquals(description, item.getDescription());
    }

    @ParameterizedTest
    @MethodSource("getHolidayItemDecorators")
    void getItemCost(final HolidayItem item, final String description, final double cost, final double itemCost)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        if (item instanceof HolidayItemDecorator) {
            HolidayItemDecorator holidayItemDecorator = (HolidayItemDecorator) item;
            Method itemCostM = HolidayItemDecorator.class.getDeclaredMethod("getItemCost");
            itemCostM.setAccessible(true);
            assertEquals(itemCost, itemCostM.invoke(holidayItemDecorator));
        } else {
            assertTrue(item instanceof Tree);
        }
    }

    static Random random = new Random();
    private static double getNewPrice() {
        int priceBig = random.nextInt(1000);
        int priceSmall = random.nextInt(100);
        return ((double) priceBig) + (((double) priceSmall) / 100);
    }

    private static Stream<Arguments> getHolidayItemDecorators() {
        int numOfItems = 5;
        ArrayList<Double> itemCost = new ArrayList<>();
        ArrayList<Double> cost = new ArrayList<>();
        ArrayList<HolidayItem> HolidayItemDecorators = new ArrayList<>();
        ArrayList<String> descriptions = new ArrayList<>();

        for (int i = 0; i < numOfItems; i++) {
            itemCost.add(getNewPrice());
            cost.add(itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new BalsamFir(itemCost.get(itemCost.size() - 1)));
            descriptions.add("My tree is a Balsam Fir with ");
        }

        for (int i = 0; i < numOfItems; i++) {
            itemCost.add(getNewPrice());
            cost.add(itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new ColoradoBlueSpruce(itemCost.get(itemCost.size() - 1)));
            descriptions.add("My tree is a Colorado Blue Spruce with ");
        }


        int size = HolidayItemDecorators.size();
        for (int i = 0; i < size; i++) {
            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new Angel(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "and a Angel");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new BallsGreen(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "Green Ball Ornaments, ");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new BallsRed(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "Red Ball Ornaments, ");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new LightsLED(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "LED Lights, ");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new Ribbons(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "Ribbons, ");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new Star(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "and a Tree Top Star");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new Tinsel(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "Tinsel, ");
        }

        size = HolidayItemDecorators.size();
        for (int i = 0; i < size; i++) {
            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new BallsGreen(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "Green Ball Ornaments, ");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new BallsRed(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "Red Ball Ornaments, ");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new LightsLED(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "LED Lights, ");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new Ribbons(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "Ribbons, ");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new Star(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "and a Tree Top Star");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new Tinsel(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "Tinsel, ");
        }

        size = HolidayItemDecorators.size();
        for (int i = 0; i < size; i++) {
            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new BallsRed(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "Red Ball Ornaments, ");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new LightsLED(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "LED Lights, ");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new Ribbons(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "Ribbons, ");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new Star(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "and a Tree Top Star");

            itemCost.add(getNewPrice());
            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
            HolidayItemDecorators.add(new Tinsel(
                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
            descriptions.add(descriptions.get(i) + "Tinsel, ");
        }
//
//        size = HolidayItemDecorators.size();
//        for (int i = 0; i < size; i++) {
//            itemCost.add(random.nextDouble());
//            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
//            HolidayItemDecorators.add(new LightsLED(
//                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
//            descriptions.add(descriptions.get(i) + "LED Lights, ");
//
//            itemCost.add(random.nextDouble());
//            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
//            HolidayItemDecorators.add(new Ribbons(
//                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
//            descriptions.add(descriptions.get(i) + "Ribbons, ");
//
//            itemCost.add(random.nextDouble());
//            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
//            HolidayItemDecorators.add(new Star(
//                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
//            descriptions.add(descriptions.get(i) + "and a Tree Top Star");
//
//            itemCost.add(random.nextDouble());
//            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
//            HolidayItemDecorators.add(new Tinsel(
//                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
//            descriptions.add(descriptions.get(i) + "Tinsel, ");
//        }
//
//        size = HolidayItemDecorators.size();
//        for (int i = 0; i < size; i++) {
//            itemCost.add(random.nextDouble());
//            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
//            HolidayItemDecorators.add(new Ribbons(
//                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
//            descriptions.add(descriptions.get(i) + "Ribbons, ");
//
//            itemCost.add(random.nextDouble());
//            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
//            HolidayItemDecorators.add(new Star(
//                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
//            descriptions.add(descriptions.get(i) + "and a Tree Top Star");
//
//            itemCost.add(random.nextDouble());
//            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
//            HolidayItemDecorators.add(new Tinsel(
//                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
//            descriptions.add(descriptions.get(i) + "Tinsel, ");
//        }
//
//        size = HolidayItemDecorators.size();
//        for (int i = 0; i < size; i++) {
//            itemCost.add(random.nextDouble());
//            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
//            HolidayItemDecorators.add(new Star(
//                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
//            descriptions.add(descriptions.get(i) + "and a Tree Top Star");
//
//            itemCost.add(random.nextDouble());
//            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
//            HolidayItemDecorators.add(new Tinsel(
//                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
//            descriptions.add(descriptions.get(i) + "Tinsel, ");
//        }
//
//        size = HolidayItemDecorators.size();
//        for (int i = 0; i < size; i++) {
//            itemCost.add(random.nextDouble());
//            cost.add(cost.get(i) + itemCost.get(itemCost.size() - 1));
//            HolidayItemDecorators.add(new Tinsel(
//                    HolidayItemDecorators.get(i), itemCost.get(itemCost.size() - 1)));
//            descriptions.add(descriptions.get(i) + "Tinsel, ");
//        }

        ArrayList<Arguments> arguments = new ArrayList<>();
        for (int i = 0; i < HolidayItemDecorators.size(); i++) {
            arguments.add(Arguments.of(HolidayItemDecorators.get(i), descriptions.get(i), cost.get(i), itemCost.get(i)));
        }
        return Stream.of(arguments.toArray(new Arguments[0]));
    }
}