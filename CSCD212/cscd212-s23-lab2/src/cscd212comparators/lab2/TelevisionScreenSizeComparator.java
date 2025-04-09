package cscd212comparators.lab2;
import cscd212classes.lab2.Television;
import java.util.Comparator;

public class TelevisionScreenSizeComparator implements Comparator<Television>{

    @Override
    public int compare(Television t1, Television t2) {
        if(t1==null || t2 == null)
            throw new IllegalArgumentException("null parameter in TelevisionScreenSizeComparator");
        if(Integer.compare(t1.getScreenSize(), t2.getScreenSize()) == 0)
            return 0;
        else
            return t1.getScreenSize()-t2.getScreenSize();
    }
}
