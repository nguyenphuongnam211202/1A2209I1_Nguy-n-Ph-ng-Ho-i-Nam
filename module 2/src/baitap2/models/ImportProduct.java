package baitap2.models;

public class ImportProduct extends Product {
    private int importPrice;
    private String importDistrict;
    private int vat;


    public ImportProduct(String id, String code, String name, int price, int quantity, String manufacture, int importPrice, String importDistrict, int vat) {
        super(id, code, name, price, quantity, manufacture);
        this.importPrice = importPrice;
        this.importDistrict = importDistrict;
        this.vat = vat;
    }

    public ImportProduct(String id, String[] data){
        super(id, data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]);
        importPrice = Integer.parseInt(data[5]);
        importDistrict = data[6];
        vat = Integer.parseInt(data[7]);
    }
    public ImportProduct(String[] data){
        super(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5]);
        importPrice = Integer.parseInt(data[6]);
        importDistrict = data[7];
        vat = Integer.parseInt(data[8]);
    }

    @Override
    public String toString() {
        return super.toString() + "ImportProduct{" +
                "importPrice=" + importPrice +
                ", importDistrict='" + importDistrict + '\'' +
                ", vat=" + vat +
                '}';
    }

    @Override
    public String infoString() {
        return super.getId() + "," +
                super.getCode() + "," +
                super.getName() + "," +
                super.getPrice() + "," +
                super.getQuantity() + "," +
                super.getManufacture() + "," +
                importPrice + "," +
                importDistrict + "," +
                vat;
    }

    public static String infoData(){
        return "CODE,NAME,PRICE,QUANTITY,MANUFACTURE,IMPORT_PRICE,IMPORT_DISTRICT,VAT";
    }

    public int getImportPrice() {
        return importPrice;
    }

    public String getImportDistrict() {
        return importDistrict;
    }

    public int getVat() {
        return vat;
    }
}
