package util;

import models.faccility.Facility;
import models.faccility.House;
import models.faccility.Room;
import models.faccility.Villa;
import models.person.Customer;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ReadAndWriteToCSV {
    public static List<String> readList(String filePath) {
        File file = new File(filePath);
        List<String> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    public static List<Customer> readCustomer(String pathFile) {
        List<Customer> customers = new ArrayList<>();
        List<String> list = readList(pathFile);
        String[] array;
        for (String strings : list
        ) {
            array = strings.split(",");
            customers.add(new Customer(array[0], array[1], LocalDate.parse(array[2]), array[3], array[4], array[5], array[6], array[7], array[8]));

        }
        return customers;
    }

    public static Map<Facility, Integer> readFacility(String pathFile) {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        List<String> list = readList(pathFile);
        String[] array;
        for (String stings : list
        ) {
            array = stings.split(",");
            if(array.length == 9){
                facilityIntegerMap.put(new Villa(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7]), Integer.parseInt(array[8]));
            }else if (array.length==8){
                facilityIntegerMap.put(new House(array[0],array[1],array[2],array[3],array[4],array[5],array[6]),Integer.parseInt(array[7]));
            }else {
                facilityIntegerMap.put(new Room(array[0],array[1],array[2],array[3],array[4],array[5]),Integer.parseInt(array[6]));
            }
        }
        return facilityIntegerMap;
    }

    public static void writeFile(String pathFile, List<String> list, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : list
            ) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeCustomer(String pathFile, List<Customer> customers, boolean append) {
        List<String> list = new ArrayList<>();
        for (Customer customer : customers
        ) {
            list.add(customer.toOfCSV());
        }
        writeFile(pathFile, list, append);
    }

    public static void writeVilla(String pathFile, Map<Villa, Integer> villaIntegerMap, boolean append) {
        List<String> list = new ArrayList<>();
        Set<Villa> villas = villaIntegerMap.keySet();
        for (Villa villa : villas) {
            list.add(villa.toVillaOfCSVFile() + "," + villaIntegerMap.get(villa));
        }
        writeFile(pathFile, list, append);
    }
    public  static  void writeRoom(String pathFile,Map<Room,Integer> roomIntegerMap,boolean append){
        List<String> list = new ArrayList<>();
        Set<Room> rooms = roomIntegerMap.keySet();
        for (Room room: rooms){
            list.add(room.toRoomOfCSVFile() + "," + roomIntegerMap.get(room));
        }
        writeFile(pathFile, list, append);
    }
    public  static  void writeHouse(String pathFile,Map<House,Integer> houseIntegerMap,boolean append){
        List<String> list = new ArrayList<>();
        Set<House> houses = houseIntegerMap.keySet();
        for (House house: houses){
            list.add(house.toHouseOfCSVFile() + "," + houseIntegerMap.get(house));
        }
        writeFile(pathFile, list, append);
    }


}
