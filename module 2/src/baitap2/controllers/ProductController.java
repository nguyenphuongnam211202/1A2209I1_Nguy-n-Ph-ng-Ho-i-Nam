package baitap2.controllers;

import baitap2.models.ExportProduct;
import baitap2.models.ImportProduct;
import baitap2.models.Product;
import baitap2.utils.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductController {
    private static int id = 4;
//    private static List<Product> repo = new ArrayList<>();
    private static List<Product> repo = ReadWriteFile.ReadFile();

//    static {
//        ReadWriteFile.WriteFile(new ExportProduct("1", "EX0001", "Laptop", 1000, 10, "VietNam", 1100, "China"));
//        ReadWriteFile.WriteFile(new ExportProduct("2", "EX0001", "Laptop", 1000, 10, "VietNam", 1100, "China"));
//        ReadWriteFile.WriteFile(new ExportProduct("3", "EX0001", "Laptop", 1000, 10, "VietNam", 1100, "China"));
//    }

    public static List<Product> getRepo() {
        return repo;
    }

    public static void setRepo(List<Product> repo) {
        ProductController.repo = repo;
    }

    public void add(String[] data) {
        if (data.length == 8){
            ReadWriteFile.WriteFile(new ImportProduct(String.valueOf(id++), data));
            return;
        }
        ReadWriteFile.WriteFile(new ExportProduct(String.valueOf(id++), data));
    }

    public boolean remove(String id) {
        Product e = findById(id);
        if (e != null){
            repo.remove(e);
            ReadWriteFile.WriteFile(repo);
            return true;
        }
        return false;
    }

    public List<Product> findAll() {
        return ReadWriteFile.ReadFile();
    }

    public Product findById(String id) {
        return repo.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Product> findByCodeOrName(String data){
        return repo.stream().filter(i -> i.getCode().toLowerCase().contains(data.toLowerCase()) ||
                        i.getName().toLowerCase().contains(data.toLowerCase()))
                .collect(Collectors.toList());
    }
}
