package javaCollectionFramework.linkedList;
import javaCollectionFramework.arrayList.Product;

public class Test {
    public static void main(String[] args) {
        Product vay = new Product("váy","1",12);
        Product ao = new Product("áo","2",19);
        Product quan = new Product("quần","3",2);
        Product quan2 = new Product("quần dài","4",4);

        ProductManager prM = new ProductManager();
        prM.addLast(vay);
        prM.addLast(ao);
        prM.addLast(quan);
        prM.addLast(quan2);


        prM.sortProduct();
        prM.display();
    }
}
