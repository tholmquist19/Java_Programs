package cscd212tests.lab2;

import cscd212classes.lab2.Television;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TATelevisionTest {

    @Nested
    class BasicQuickTests {
        private Television televisionTestsObject;
        private final String make = "EWU";
        private final String model = "superTester";
        private final boolean smart = true;
        private final int size = 36;
        private final int resolution = 1080;

        private final String toStringValue = "EWU-superTester, 36 inch smart tv with 1080 resolution";
        private final int hashCodeValue = -2051529767;

        @BeforeEach
        void setUp() {
            this.televisionTestsObject = new Television(this.make, this.model, this.smart, this.size, this.resolution);
        }

        @Test
        void getScreenSize() {
            assertEquals(this.size, this.televisionTestsObject.getScreenSize());
        }

        @Test
        void getResolution() {
            assertEquals(this.resolution, this.televisionTestsObject.getResolution());
        }

        @Test
        void getMake() {
            assertEquals(this.make, this.televisionTestsObject.getMake());
        }

        @Test
        void getModel() {
            assertEquals(this.model, this.televisionTestsObject.getModel());
        }

        @Test
        void testToString() {
            assertEquals(this.toStringValue, this.televisionTestsObject.toString());
        }

        @Test
        void testHashCode() {
            assertEquals(this.hashCodeValue, this.televisionTestsObject.hashCode());
        }
    }

    @Nested
    class BasicOtherQuickTests {
        private Television televisionTestsObject;
        private final String make = "EWU";
        private final String model = "superTester";
        private final boolean smart = false;
        private final int size = 36;
        private final int resolution = 2160;

        private final String toStringValue = "EWU-superTester, 36 inch tv with 4K resolution";
        private final int hashCodeValue = -2051528687;

        @BeforeEach
        void setUp() {
            this.televisionTestsObject = new Television(this.make, this.model, this.smart, this.size, this.resolution);
        }

        @Test
        void getScreenSize() {
            assertEquals(this.size, this.televisionTestsObject.getScreenSize());
        }

        @Test
        void getResolution() {
            assertEquals(this.resolution, this.televisionTestsObject.getResolution());
        }

        @Test
        void getMake() {
            assertEquals(this.make, this.televisionTestsObject.getMake());
        }

        @Test
        void getModel() {
            assertEquals(this.model, this.televisionTestsObject.getModel());
        }

        @Test
        void testToString() {
            assertEquals(this.toStringValue, this.televisionTestsObject.toString());
        }

        @Test
        void testHashCode() {
            assertEquals(this.hashCodeValue, this.televisionTestsObject.hashCode());
        }
    }

    @Nested
    class IllegalMovesTests {
        @Test
        void badMake() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                new Television(null, "tests", true, 36, 1080);
            }, "Missing throw IllegalArgumentException for null make");
            assertEquals("Invalid parameter in constructor", exception.getMessage(),
                    "exception message does not match");
        }

        @Test
        void badModel() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                new Television("tests", null, true, 36, 1080);
            }, "Missing throw IllegalArgumentException for null model");
            assertEquals("Invalid parameter in constructor", exception.getMessage(),
                    "exception message does not match");
        }

        @Test
        void badScreenSize() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                new Television("tests", "tests", true, -10, 1080);
            }, "Missing throw IllegalArgumentException for size less then 32");
            assertEquals("Invalid parameter in constructor", exception.getMessage(),
                    "exception message does not match");
        }

        @Test
        void badResolution() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                new Television("tests", "tests", true, 36, -144);
            }, "Missing throw IllegalArgumentException for resolution less then 720");
            assertEquals("Invalid parameter in constructor", exception.getMessage(),
                    "exception message does not match");
        }

        @Test
        void badTelevision() {
            Television television = new Television("tests", "tests", true, 36, 1080);
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                television.compareTo(null);
            }, "Missing throw IllegalArgumentException for null Television (compareTo)");
            assertEquals("null parameter in the compareTo method", exception.getMessage(),
                    "exception message does not match");
        }
    }

    @Nested
    class CompareToTests {
        @Test
        void sameTV() {
            Television television1 = new Television("make", "model", true, 64, 1080);
            Television television2 = new Television("make", "model", true, 64, 1080);
            assertEquals(0, television1.compareTo(television2));
        }
        @Test
        void checkMake() {
            String makeName1 = "EWU";
            String makeName2 = "TFTinker";
            Television television1 = new Television(makeName1, "model", true, 64, 1080);
            Television television2 = new Television(makeName2, "model", true, 64, 1080);
            assertEquals(makeName1.compareTo(makeName2), television1.compareTo(television2));
        }
        @Test
        void checkModel() {
            String modelName1 = "EWU";
            String modelName2 = "TFTinker";
            Television television1 = new Television("make", modelName1, true, 64, 1080);
            Television television2  = new Television("make", modelName2, true, 64, 1080);
            assertEquals(modelName1.compareTo(modelName2), television1.compareTo(television2));
        }
        @Test
        void checkSize() {
            Television television1 = new Television("make", "model", true, 64, 1080);
            Television television2 = new Television("make", "model", true, 128, 1080);
            assertEquals(64-128, television1.compareTo(television2));
        }
    }

    @Nested
    class EqualsTests {
        @Test
        void sameObject() {
            Television television1 = new Television("make", "model", true, 64, 1080);
            assertTrue(television1.equals(television1));
        }
        @Test
        void equalNULL() {
            Television television1 = new Television("make", "model", true, 64, 1080);
            assertFalse(television1.equals(null), "null is not a tv so false");
        }
        @Test
        void notTV() {
            Television television1 = new Television("make", "model", true, 64, 1080);
            String[] tvInfo = {"no", "yes", "260"};
            assertFalse(television1.equals(tvInfo), "null is not a tv so false");
        }
        @Test
        void sameTV() {
            Television television1 = new Television("make", "model", true, 64, 1080);
            Television television2 = new Television("make", "model", true, 64, 1080);
            assertTrue(television1.equals(television2));
            assertTrue(television2.equals(television1));
        }
        @Test
        void differentTV() {
            Television television1 = new Television("make", "EWU", true, 64, 1080);
            Television television2 = new Television("make", "TFTinker", true, 64, 1080);
            assertFalse(television1.equals(television2));
            assertFalse(television2.equals(television1));
        }
    }
}