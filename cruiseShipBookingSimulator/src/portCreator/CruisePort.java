package portCreator;

public class CruisePort {

    private String locName;
    private String countryCode;

    public CruisePort(final String locName, final String countryCode){
        if(locName==null || locName.isEmpty() || countryCode==null || countryCode.isEmpty())
            throw new IllegalArgumentException("Bad params in CruisePort constructor");
        this.locName=locName;
        this.countryCode=countryCode;
    }

    public String toString(){
        return this.countryCode+", "+this.locName;
    }


}
