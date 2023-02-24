package models.faccility;

public class Villa extends Facility {
    private String roomStandard;
    private String poolArea;
    private String numberOfFloors;

    public Villa() {
        super();
    }

    public Villa(String nameService, String areaOfUse, String rentalCost, String maxMinPeople, String rentalType, String roomStandard, String poolArea, String numberOfFloors) {
        super(nameService, areaOfUse, rentalCost, maxMinPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa" + super.toString()+
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea='" + poolArea + '\'' +
                ", numberOfFloors='" + numberOfFloors + '\''+"]";
    }
    public  String toVillaOfCSVFile(){
        return this.getNameService() +","+this.getAreaOfUse() +","+this.getRentalCost()+","+this.getMaxMinPeople()+","+this.getRentalType()+
                ","+this.roomStandard+","+this.poolArea+","+this.numberOfFloors;
    }
}
