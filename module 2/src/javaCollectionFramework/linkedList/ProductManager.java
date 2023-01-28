package javaCollectionFramework.linkedList;

import javaCollectionFramework.arrayList.Product;

import java.util.*;

public class ProductManager {
    private LinkedList<Product> list;

    public ProductManager() {
        this.list = new LinkedList<Product>();
    }
    public ProductManager(LinkedList<Product> list) {
        this.list = list;
    }

    public void addLast(Product product){
        this.list.addLast(product);
    }


    public void edit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập id sản phẩm muốn sửa thông tin");
        String id = sc.nextLine();
        for (Product product : list) {
            if (product.getIdProduct().indexOf(id) >= 0) {
                System.out.print("sửa tên sản phẩm : ");
                product.setNameProduct(sc.nextLine());
                System.out.print("sửa giá sản phẩm : ");
                product.setCostProduct(sc.nextInt());
            }
        }
    }
    public void removeProduct(String id) {
        for (Product product : list) {
            if (product.getIdProduct().equals(id)) {
                this.list.remove(product);
            }
        }
    }

    public void findProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập tên sản phẩm muốn tìm");
        String name = sc.nextLine();
        for (Product product : list) {
            if (product.getNameProduct().equals(name)) {
                System.out.println(product);
            }
        }
    }

    public void sortProduct() {
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getCostProduct() < o2.getCostProduct()){
                    return -1;
                } else if (o1.getCostProduct()==o2.getCostProduct()) {
                    return 0;
                }else {
                    return 1;
                }
            }
        });
    }

    public void display() {
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }

}
