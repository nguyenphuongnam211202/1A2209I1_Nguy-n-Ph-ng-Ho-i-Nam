package models.faccility;

public class House extends Facility {
    private  String roomStandard;
    private String numberOfFloors;

    public House() {
    }


    public House(String nameService, String areaOfUse, String rentalCost, String maxMinPeople, String rentalType, String roomStandard, String numberOfFloors) {
        super(nameService, areaOfUse, rentalCost, maxMinPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House" + super.toString()+
                "roomStandard='" + roomStandard + '\'' +
                ", numberOfFloors='" + numberOfFloors + '\'' +"]";
    }
    public  String toHouseOfCSVFile(){
        return this.getNameService() +","+this.getAreaOfUse() +","+this.getRentalCost()+","+this.getMaxMinPeople()+","+this.getRentalType()+
                ","+this.roomStandard+","+this.numberOfFloors;
    }
}
