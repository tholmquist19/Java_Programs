package cscd212tests;

import cscd212dataobjects.GoodGuys;
import cscd212lab7.PropertyChangeMainLOR;
import cscd212observers.BadGuy;
import cscd212subjects.EyeOfSauron;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CSCD212Lab7Tests {
    @Nested
    class TAProptertyChangeMainLORTest {

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
            String outputText = "Registering EyeOfSauron as the Subject (Observable Object)\n" +
                    "Good guys forming the resistance (Data Object)\n" +
                    "\n" +
                    "Registering Sauruman as an observer\n" +
                    "Sauruman was added as an observer of EyeOfSauron\n" +
                    "\n" +
                    "EyeOfSauron has spotted good guys, notifying the bad guys\n" +
                    "\n" +
                    "Sauruman - Changed property: Hobbits [old -> 0] | [new -> 1]\n" +
                    "Sauruman - Changed property: Elves [old -> 0] | [new -> 2]\n" +
                    "Sauruman - Changed property: Dwarves [old -> 0] | [new -> 3]\n" +
                    "Sauruman - Changed property: Humans [old -> 0] | [new -> 4]\n" +
                    "\n" +
                    "Registering The Witch King as a second observer\n" +
                    "Witch King was added as an observer of EyeOfSauron\n" +
                    "\n" +
                    "Updating the Good Guys to add hobbits, elves, dwarves and no humans\n" +
                    "\n" +
                    "EyeOfSauron has spotted more good guys, notifying the bad guys\n" +
                    "\n" +
                    "Sauruman - Changed property: Hobbits [old -> 1] | [new -> 2]\n" +
                    "Witch King - Changed property: Hobbits [old -> 1] | [new -> 2]\n" +
                    "Sauruman - Changed property: Elves [old -> 2] | [new -> 14]\n" +
                    "Witch King - Changed property: Elves [old -> 2] | [new -> 14]\n" +
                    "Sauruman - Changed property: Dwarves [old -> 3] | [new -> 23]\n" +
                    "Witch King - Changed property: Dwarves [old -> 3] | [new -> 23]\n" +
                    "\n" +
                    "Removing the Witch King as a second observer\n" +
                    "Witch King was defeated\n" +
                    "\n" +
                    "\n" +
                    "Updating the Good Guys to add hobbits, elves, dwarves and humans\n" +
                    "\n" +
                    "EyeOfSauron has spotted more good guys, notifying the bad guys\n" +
                    "\n" +
                    "Sauruman - Changed property: Hobbits [old -> 2] | [new -> 6]\n" +
                    "Sauruman - Changed property: Elves [old -> 14] | [new -> 12]\n" +
                    "Sauruman - Changed property: Dwarves [old -> 23] | [new -> 18]\n" +
                    "Sauruman - Changed property: Humans [old -> 4] | [new -> 104]\n";
                  // Run the program
            PropertyChangeMainLOR.main(new String[0]);
            // check output
            assertEquals(outputText, this.out.toString().replaceAll("\r", ""),
                    "Output does not match our run of the program");
        }
    }

    @Nested
    class TAGoodGuysTest {

        int[] numbers;
        GoodGuys exampleGoodGuys;

        @BeforeEach
        void setUp() {
            Random random = new Random();
            this.numbers = new int[4];
            for (int i = 0; i < this.numbers.length; i++) {
                this.numbers[i] = random.nextInt();
            }
            this.exampleGoodGuys = new GoodGuys(this.numbers[0], this.numbers[1],
                    this.numbers[2], this.numbers[3]);
        }

        @RepeatedTest(3)
        void getHobbits() {
            assertEquals(this.numbers[0], this.exampleGoodGuys.getHobbits());
        }

        @RepeatedTest(3)
        void getElves() {
            assertEquals(this.numbers[1], this.exampleGoodGuys.getElves());
        }

        @RepeatedTest(3)
        void getDwarves() {
            assertEquals(this.numbers[2], this.exampleGoodGuys.getDwarves());
        }

        @RepeatedTest(3)
        void getHumans() {
            assertEquals(this.numbers[3], this.exampleGoodGuys.getHumans());
        }
    }

    @Nested
    class TAEyeOfSauronTest {
        int[] numbers;
        GoodGuys exampleGoodGuys;
        EyeOfSauron eyeOfSauron;

        @BeforeEach
        void setUp() {
            Random random = new Random();
            this.numbers = new int[4];
            for (int i = 0; i < this.numbers.length; i++) {
                this.numbers[i] = random.nextInt();
            }
            this.exampleGoodGuys = new GoodGuys(this.numbers[0], this.numbers[1],
                    this.numbers[2], this.numbers[3]);
            this.eyeOfSauron = new EyeOfSauron();
        }

        @RepeatedTest(3)
        void update() {
            class TestsLisner implements PropertyChangeListener {
                @Override
                public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
                    if (propertyChangeEvent.getPropertyName().trim().equalsIgnoreCase("Hobbits")) {
                        assertEquals(0, propertyChangeEvent.getOldValue());
                        assertEquals(TAEyeOfSauronTest.this.exampleGoodGuys.getHobbits(),
                                propertyChangeEvent.getNewValue());
                    } else if (propertyChangeEvent.getPropertyName().trim().equalsIgnoreCase("Elves")) {
                        assertEquals(0, propertyChangeEvent.getOldValue());
                        assertEquals(TAEyeOfSauronTest.this.exampleGoodGuys.getElves(),
                                propertyChangeEvent.getNewValue());
                    } else if (propertyChangeEvent.getPropertyName().trim().equalsIgnoreCase("Dwarves")) {
                        assertEquals(0, propertyChangeEvent.getOldValue());
                        assertEquals(TAEyeOfSauronTest.this.exampleGoodGuys.getDwarves(),
                                propertyChangeEvent.getNewValue());
                    } else if (propertyChangeEvent.getPropertyName().trim().equalsIgnoreCase("Humans")) {
                        assertEquals(0, propertyChangeEvent.getOldValue());
                        assertEquals(TAEyeOfSauronTest.this.exampleGoodGuys.getHumans(),
                                propertyChangeEvent.getNewValue());
                    } else {
                        fail("Was given a unknown property of: " + propertyChangeEvent.getPropertyName().trim());
                    }
                }
            }
            TestsLisner testsLisner = new TestsLisner();
            this.eyeOfSauron.addPropertyChangeListener(testsLisner);
            this.eyeOfSauron.update(this.exampleGoodGuys);
        }
    }

    @Nested
    class TABadGuyTest {

        String name = "testsName";
        int[] numbers;
        GoodGuys exampleGoodGuys;
        EyeOfSauron eyeOfSauron;
        BadGuy badGuy;

        private ByteArrayOutputStream out;
        private PrintStream originalOut;

        Random random;

        @BeforeEach
        void setUp() {
            this.random = new Random();
            this.numbers = new int[4];
            for (int i = 0; i < this.numbers.length; i++) {
                this.numbers[i] = this.random.nextInt();
            }
            this.exampleGoodGuys = new GoodGuys(this.numbers[0], this.numbers[1],
                    this.numbers[2], this.numbers[3]);
            this.eyeOfSauron = new EyeOfSauron();
            this.badGuy = new BadGuy(this.name);
            this.badGuy.add(this.eyeOfSauron);
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

        @RepeatedTest(3)
        void remove() {
            this.badGuy.remove(eyeOfSauron);
            assertEquals(this.name + " was defeated",
                    this.out.toString().trim().replace("\r", "").trim());
        }

        @RepeatedTest(3)
        void propertyChange() {
            String pn = "Testing Propery";
            int ov = this.random.nextInt();
            int nv = this.random.nextInt();
            PropertyChangeEvent propertyChangeEvent =
                    new PropertyChangeEvent(this.eyeOfSauron, pn, ov, nv);
            this.badGuy.propertyChange(propertyChangeEvent);
            assertEquals(this.name + " - Changed property: " + pn + " [old -> " + ov + "] | [new -> " + nv + "]",
                    this.out.toString().trim().replace("\r", "").trim());
        }
    }
}
