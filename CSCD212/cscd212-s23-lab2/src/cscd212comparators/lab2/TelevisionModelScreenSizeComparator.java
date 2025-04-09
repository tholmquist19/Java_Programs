package cscd212comparators.lab2;
import cscd212classes.lab2.Television;
import java.util.Comparator;

public class TelevisionModelScreenSizeComparator implements Comparator<Television>{
    @Override
    public int compare(Television t1, Television t2) {
        if(t1==null||t2==null)
            throw new IllegalArgumentException("null parameter in TelevisionModelScreenSizeComparator");
        if (t1.getModel() == t2.getModel())
            return t1.getScreenSize()-t2.getScreenSize();
        return CharSequence.compare(t1.getModel(), t2.getModel());
    }
}
