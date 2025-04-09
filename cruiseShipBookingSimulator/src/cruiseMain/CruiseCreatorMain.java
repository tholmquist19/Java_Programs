package cruiseMain;
import cruiseCreator.*;

public class CruiseCreatorMain {

    public static void main(final String[] args){

        CruiseManager cruise = new CruiseManager();
        cruise.makeCruises();
        cruise.designCruise();
        cruise.displayCruiseSystemDetails();
        User newUser = new User();
        System.out.println();
        newUser.add(cruise.getCruise());
        System.out.println();
        cruise.getCruise().updatePrice(200);
    }
}
