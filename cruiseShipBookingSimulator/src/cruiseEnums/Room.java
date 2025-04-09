package cruiseEnums;

public enum Room {

    INCABIN('A', 18, "In Cabin",50), PORTCABIN('B',13, "Port Cabin",70),
    BALCONYCABIN('C', 24, "Balcony Cabin",100),
    CABINSUITE('D', 1, "Cabin Suite",150);

    private Character deckName;
    private int roomNum;
    private String name;
    private int cost;

    private Room(final Character deckName, final int roomNum, final String name, final int cost){
        if(deckName==null||roomNum<0||name==null||name.isEmpty()||cost<0)
            throw new IllegalArgumentException("Bad params in Room constructor");
        this.deckName=deckName;
        this.roomNum=roomNum;
        this.name=name;
        this.cost=cost;
    }

    public Character getDeckName(){
        return this.deckName;
    }
    public int getRoomNum(){
        return this.roomNum;
    }
    public String getName(){
        return this.name;
    }
    public int getCost(){
        return this.cost;
    }
}
