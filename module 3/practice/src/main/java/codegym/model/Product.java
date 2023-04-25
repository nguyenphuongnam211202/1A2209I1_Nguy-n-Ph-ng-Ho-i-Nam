package codegym.model;

public class Product {
    private int id;

    private String name;
    private int cost;
    private int quantity;

    private String color;
    private String describe;
    private String category;

    public Product(int id, String name, int cost, int quantity, String color, String describe, String category) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.color = color;
        this.describe = describe;
        this.category = category;
    }

    public Product(String name, int cost, int quantity, String color, String describe, String category) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.color = color;
        this.describe = describe;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
