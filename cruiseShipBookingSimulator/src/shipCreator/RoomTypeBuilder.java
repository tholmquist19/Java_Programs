package shipCreator;
import cruiseEnums.Room;

public class RoomTypeBuilder {

    private Room roomType;

    public RoomTypeBuilder(final Room roomType){
        if(roomType==null)
            throw new IllegalArgumentException("Bad params in RoomTypeBuilder");
        this.roomType=roomType;
    }

    public String toString(){
        return "You chose the "+roomType.getName()+" room. Your room is "+roomType.getDeckName()+roomType.getRoomNum();
    }
}
