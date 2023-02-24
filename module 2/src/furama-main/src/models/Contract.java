package models;

public class Contract {
    private String contractNumber;
    private String codeBooking;
    private String soTienCocTruoc;
    private String tongSoTienThanhToan;
    private String codeCustomer;

    public Contract() {
    }

    public Contract(String contractNumber, String codeBooking, String soTienCocTruoc, String tongSoTienThanhToan, String codeCustomer) {
        this.contractNumber = contractNumber;
        this.codeBooking = codeBooking;
        this.soTienCocTruoc = soTienCocTruoc;
        this.tongSoTienThanhToan = tongSoTienThanhToan;
        this.codeCustomer = codeCustomer;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public String getSoTienCocTruoc() {
        return soTienCocTruoc;
    }

    public void setSoTienCocTruoc(String soTienCocTruoc) {
        this.soTienCocTruoc = soTienCocTruoc;
    }

    public String getTongSoTienThanhToan() {
        return tongSoTienThanhToan;
    }

    public void setTongSoTienThanhToan(String tongSoTienThanhToan) {
        this.tongSoTienThanhToan = tongSoTienThanhToan;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber='" + contractNumber + '\'' +
                ", codeBooking='" + codeBooking + '\'' +
                ", soTienCocTruoc='" + soTienCocTruoc + '\'' +
                ", tongSoTienThanhToan='" + tongSoTienThanhToan + '\'' +
                ", codeCustomer='" + codeCustomer + '\'' +
                '}';
    }
}
