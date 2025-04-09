package cruiseEnums;

public enum CruisePackage {
    ALLINCLUSIVE("All Inclusive",200), FREESHOWS("Free Shows",50),
    FREEDRINKS("Free Drinks",75), FREEFOOD("Free Food",100), NOPACK("No Package",0);

    private String name;
    private int charge;

    private CruisePackage(final String name, final int charge){
        if(name==null||name.isEmpty())
            throw new IllegalArgumentException("Bad params in CruisePackage constructor");
        this.name = name;
        this.charge=charge;
    }
    public String getName(){
        return this.name;
    }
    public int getCharge(){
        return this.charge;
    }

}
