package javaCollectionFramework.arrayList;

public class test {
    public static void main(String[] args) {
        ProductManager prM = new ProductManager();
        Product  ao = new Product("áo","1",10);
        Product  quan = new Product("quần","2",12);
        Product  giay = new Product("giày","3",9);
        Product  vay = new Product("váy","4",6);
        Product vay2 = new Product("váy","5",11);
        
        prM.addProduct(ao);
        prM.addProduct(quan);
        prM.addProduct(giay);
        prM.addProduct(vay);
        prM.addProduct(vay2);
        prM.display();
        System.out.println("");
        prM.findProduct();
        prM.sortProduct();
        prM.display();
    }
}
