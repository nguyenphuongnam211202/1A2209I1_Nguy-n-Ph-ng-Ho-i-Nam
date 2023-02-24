package util;

import models.person.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteEmployeeToCSV {
    public static List<Employee> readFile(String filePath) {
        File file = new File(filePath);
        List<Employee> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                String[] arr = string.split(",");
                list.add(new Employee(arr[0], arr[1], LocalDate.parse(arr[2]),
                        arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9]));
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void writeFile(String filePath, List<Employee> list, boolean append) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i).toOfCSVFile());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
