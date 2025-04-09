package cscd212comparators.lab3;
import cscd212classes.lab3.*;
import java.util.Comparator;

public class TeamPayrollComparator implements Comparator<Team>{

    public TeamPayrollComparator(){}

    @Override
    public int compare(final Team t1, final Team t2) {
        if (t1 == null || t2 == null)
            throw new IllegalArgumentException("Bad Params in compare");
        return t1.getPayroll() - t2.getPayroll();
    }
}
