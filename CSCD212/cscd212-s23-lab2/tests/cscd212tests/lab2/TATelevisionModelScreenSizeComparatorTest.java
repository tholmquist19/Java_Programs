package cscd212tests.lab2;

import cscd212classes.lab2.Television;
import cscd212comparators.lab2.TelevisionModelScreenSizeComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TATelevisionModelScreenSizeComparatorTest {
    @Nested
    class NullChecks {
        Comparator<Television> comparator;
        @BeforeEach
        void setUp() {
            this.comparator = new TelevisionModelScreenSizeComparator();
        }

        @Test
        void t1Null() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                this.comparator.compare(null, new Television("b", "b", true, 64, 1080));
            }, "Missing throw IllegalArgumentException for null t1");
            assertEquals("null parameter in TelevisionModelScreenSizeComparator", exception.getMessage(),
                    "exception message does not match");
        }

        @Test
        void t2Null() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                this.comparator.compare(new Television("b", "b", true, 64, 1080), null);
            }, "Missing throw IllegalArgumentException for null t2");
            assertEquals("null parameter in TelevisionModelScreenSizeComparator", exception.getMessage(),
                    "exception message does not match");
        }

        @Test
        void bothNull() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                this.comparator.compare(null, null);
            }, "Missing throw IllegalArgumentException for null t1 and t2");
            assertEquals("null parameter in TelevisionModelScreenSizeComparator", exception.getMessage(),
                    "exception message does not match");
        }
    }

    @Nested
    class Compare {
        Comparator<Television> comparator;
        String[] models = {"EWU", "TFTinker"};
        int[] sizes = {64, 82};
        Television television1;
        @BeforeEach
        void setup() {
            this.comparator = new TelevisionModelScreenSizeComparator();
            this.television1 = new Television("test", this.models[0], true, this.sizes[0], 1080);
        }

        @Test
        void same() {
            Television television2 = new Television("test", this.models[0], true, this.sizes[0], 1080);
            assertEquals(0, this.comparator.compare(this.television1, television2),
                    "The same tv does not give 0");
        }

        @Test
        void diffrentModels() {
            Television television2 =
                    new Television("test", this.models[1], true, this.sizes[0], 1080);
            assertEquals(this.models[0].compareTo(this.models[1]),
                    this.comparator.compare(this.television1, television2),
                    "The compareTo of models was not return (if - try flipping what you compare)");
        }

        @Test
        void diffrentSize() {
            Television television2 =
                    new Television("test", this.models[0], true, this.sizes[1], 1080);
            assertEquals(this.sizes[0] - this.sizes[1],
                    this.comparator.compare(this.television1, television2),
                    "The different of size not return (if - try flipping what you compare)");
        }

    }
}