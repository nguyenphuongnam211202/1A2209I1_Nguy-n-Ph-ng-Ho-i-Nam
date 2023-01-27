package javaCollectionFramework.arrayList;

import java.util.Collection;

public class Product  {
    private String nameProduct;
    private String idProduct;
    private int costProduct;

    public Product(){
    }

    public Product(String nameProduct, String idProduct, int costProduct) {
        this.nameProduct = nameProduct;
        this.idProduct = idProduct;
        this.costProduct = costProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public int getCostProduct() {
        return costProduct;
    }

    public void setCostProduct(int costProduct) {
        this.costProduct = costProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameProduct='" + nameProduct + '\'' +
                ", idProduct='" + idProduct + '\'' +
                ", costProduct=" + costProduct +
                '}';
    }
}
