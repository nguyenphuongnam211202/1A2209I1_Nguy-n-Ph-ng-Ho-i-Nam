package models;

public class Booking {
    private String codeBooking;
    private String startDate;
    private  String endDate;
    private String codeCustomer;
    private String nameService;
    private String codeService;

    public Booking() {
    }

    public Booking(String codeBooking, String startDate, String endDate, String codeCustomer, String nameService, String codeService) {
        this.codeBooking = codeBooking;
        this.startDate = startDate;
        this.endDate = endDate;
        this.codeCustomer = codeCustomer;
        this.nameService = nameService;
        this.codeService = codeService;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "codeBooking='" + codeBooking + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", codeCustomer='" + codeCustomer + '\'' +
                ", nameService='" + nameService + '\'' +
                ", codeService='" + codeService + '\'' +
                '}';
    }
}
