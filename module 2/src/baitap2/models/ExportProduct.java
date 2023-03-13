package baitap2.models;

public class ExportProduct extends Product {
    private int exportPrice;
    private String exportNation;

    public ExportProduct(String id, String code, String name, int price, int quantity, String manufacture, int exportPrice, String exportNation) {
        super(id, code, name, price, quantity, manufacture);
        this.exportPrice = exportPrice;
        this.exportNation = exportNation;
    }

    public ExportProduct(String id, String[] data){
        super(id, data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]);
        exportPrice = Integer.parseInt(data[5]);
        exportNation = data[6];
    }

    public ExportProduct(String[] data){
        super(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5]);
        exportPrice = Integer.parseInt(data[6]);
        exportNation = data[7];
    }

    @Override
    public String toString() {
        return super.toString() + "ExportProduct{" +
                "exportPrice=" + exportPrice +
                ", exportNation='" + exportNation + '\'' +
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
                exportPrice + "," +
                exportNation;
    }

    public static String infoData(){
        return "CODE,NAME,PRICE,QUANTITY,MANUFACTURE,EXPORT_PRICE,EXPORT_NATION";
    }

    public int getExportPrice() {
        return exportPrice;
    }

    public String getExportNation() {
        return exportNation;
    }
}
