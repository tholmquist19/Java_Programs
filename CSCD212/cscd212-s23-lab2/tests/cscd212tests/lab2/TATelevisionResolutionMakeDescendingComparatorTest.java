package cscd212tests.lab2;

import cscd212classes.lab2.Television;
import cscd212comparators.lab2.TelevisionResolutionMakeDescendingComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TATelevisionResolutionMakeDescendingComparatorTest {

    @Nested
    class NullChecks {
        Comparator<Television> comparator;
        @BeforeEach
        void setUp() {
            this.comparator = new TelevisionResolutionMakeDescendingComparator();
        }

        @Test
        void t1Null() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                this.comparator.compare(null, new Television("b", "b", true, 64, 1080));
            }, "Missing throw IllegalArgumentException for null t1");
            assertEquals("null parameter in TelevisionResolutionMakeDescendingComparator", exception.getMessage(),
                    "exception message does not match");
        }

        @Test
        void t2Null() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                this.comparator.compare(new Television("b", "b", true, 64, 1080), null);
            }, "Missing throw IllegalArgumentException for null t2");
            assertEquals("null parameter in TelevisionResolutionMakeDescendingComparator", exception.getMessage(),
                    "exception message does not match");
        }

        @Test
        void bothNull() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                this.comparator.compare(null, null);
            }, "Missing throw IllegalArgumentException for null t1 and t2");
            assertEquals("null parameter in TelevisionResolutionMakeDescendingComparator", exception.getMessage(),
                    "exception message does not match");
        }
    }

    @Nested
    class Compare {
        Comparator<Television> comparator;
        String[] makes = {"EWU", "TFTinker"};

        int[] resolutions = {1080, 1440};
        Television television1;
        @BeforeEach
        void setup() {
            this.comparator = new TelevisionResolutionMakeDescendingComparator();
            this.television1 = new Television(this.makes[0], "test", true, 32, this.resolutions[0]);
        }

        @Test
        void same() {
            Television television2 = new Television(this.makes[0], "test", true, 32, this.resolutions[0]);
            assertEquals(0, this.comparator.compare(this.television1, television2),
                    "The same tv does not give 0");
        }

        @Test
        void diffrentResolution() {
            Television television2 =
                    new Television(this.makes[0], "test", true, 32, this.resolutions[1]);
            assertEquals(this.resolutions[1] - this.resolutions[0],
                    this.comparator.compare(this.television1, television2),
                    "The different in resolution was not return");
        }

        @Test
        void diffrentMakes() {
            Television television2 = new Television(this.makes[1], "test", true, 32, this.resolutions[0]);
            assertEquals(this.makes[1].compareTo(this.makes[0]), this.comparator.compare(this.television1, television2),
                    "The compareTo value of makes not return");
        }

    }
}