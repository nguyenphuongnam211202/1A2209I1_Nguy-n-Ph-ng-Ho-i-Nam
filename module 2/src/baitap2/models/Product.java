package baitap2.models;

public abstract class Product {
    private String id, code, name;
    private int price, quantity;
    private String manufacture;

    public Product(String id, String code, String name, int price, int quantity, String manufacture) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacture = manufacture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", manufacture='" + manufacture + '\'' +
                '}';
    }

    public abstract String infoString();

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getManufacture() {
        return manufacture;
    }
}
