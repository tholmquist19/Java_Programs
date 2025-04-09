package shipCreator;
import cruiseEnums.*;

public class PackageBuilder {

    public CruisePackage cruisePack;

    public PackageBuilder(final CruisePackage cruisePack){
        if(cruisePack == null)
            throw new IllegalArgumentException("Bad params in packageBuilder constructor");
        this.cruisePack = cruisePack;
    }

    public String toString(){
        String packString="";
        if(cruisePack == CruisePackage.FREESHOWS)
            packString = "free viewing of all our shows";
        if(cruisePack == CruisePackage.FREEFOOD)
            packString = "free access to all marked foods";
        if(cruisePack == CruisePackage.FREEDRINKS)
            packString = "free access to all drinks";
        if(cruisePack == CruisePackage.ALLINCLUSIVE)
            packString = "free access to all food, drinks and shows";
        if(cruisePack == CruisePackage.NOPACK)
            packString = "all the basic amenities";

        return "You have selected the "+this.cruisePack.getName()+" package. This allows you "+packString+
                " during the duration of your cruise";
    }
}
