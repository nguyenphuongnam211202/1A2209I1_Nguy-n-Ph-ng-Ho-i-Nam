package models.faccility;

public class Room extends Facility {
    private String freeServiceIncluded;

    public Room() {

    }

    public Room(String nameService, String areaOfUse, String rentalCost, String maxMinPeople, String rentalType, String freeServiceIncluded) {
        super(nameService, areaOfUse, rentalCost, maxMinPeople, rentalType);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return "Room" + super.toString()+
                "freeServiceIncluded='" + freeServiceIncluded + '\'' +"]";
    }
    public  String toRoomOfCSVFile(){
        return this.getNameService() +","+this.getAreaOfUse() +","+this.getRentalCost()+","+this.getMaxMinPeople()+","+this.getRentalType()+
                ","+this.freeServiceIncluded;
    }
}
