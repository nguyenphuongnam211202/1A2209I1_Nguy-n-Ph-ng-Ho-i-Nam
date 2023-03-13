package baitap2.utils;

import baitap2.models.ExportProduct;
import baitap2.models.ImportProduct;
import baitap2.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {

    private static final String PATH = ".\\src\\baitap2\\product.csv";
    public static final String SPLIT_COMMA = ",";

    public static List<Product> ReadFile(){
        List<Product> list = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(PATH))) {
            String line = null;
            while ((line = bf.readLine()) != null){
                if (line.trim() == null){
                    continue;
                }
                String[] strings = line.split(SPLIT_COMMA);
                if (strings.length == 9){
                    list.add(new ImportProduct(strings));
                } else {
                    list.add(new ExportProduct(strings));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    return list;
    }

    public static void WriteFile(Product product){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true))){
            bw.write(product.infoString());
            bw.write("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void WriteFile(List<Product> list){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))){
           for (Product product : list){
               bw.write(product.infoString());
               bw.write("\n");
           }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
