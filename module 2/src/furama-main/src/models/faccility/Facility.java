package models.faccility;

public class Facility {
    private String nameService;
    private String areaOfUse;
    private String rentalCost;
    private String maxMinPeople;
    private String rentalType;

    public Facility() {
    }
    public Facility(String nameService, String areaOfUse, String rentalCost, String maxMinPeople, String rentalType) {
        this.nameService = nameService;
        this.areaOfUse = areaOfUse;
        this.rentalCost = rentalCost;
        this.maxMinPeople = maxMinPeople;
        this.rentalType = rentalType;

    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getAreaOfUse() {
        return areaOfUse;
    }

    public void setAreaOfUse(String areaOfUse) {
        this.areaOfUse = areaOfUse;
    }

    public String getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(String rentalCost) {
        this.rentalCost = rentalCost;
    }

    public String getMaxMinPeople() {
        return maxMinPeople;
    }

    public void setMaxMinPeople(String maxMinPeople) {
        this.maxMinPeople = maxMinPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return
                " [nameService='" + nameService + '\'' +
                ", areaOfUse='" + areaOfUse + '\'' +
                ", rentalCost='" + rentalCost + '\'' +
                ", maxMinPeople='" + maxMinPeople + '\'' +
                ", rentalType='" + rentalType + '\''
                ;
    }
}