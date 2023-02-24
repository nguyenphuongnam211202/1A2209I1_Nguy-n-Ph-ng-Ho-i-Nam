package service.impl;

import models.faccility.Facility;
import service.FacilityService;
import util.ReadAndWriteToCSV;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService {
    private static FacilityService villaService;
    private static FacilityService  roomService;
  private static FacilityService  houseService;
  private final String FILE_FACILITY = "src/data/DataFacility.csv";
    @Override
    public void add() {
       String choose;
        do {
            System.out.println("ADD FACILITY\n" +
                    "1.Add New Villa\n" +
                    "2.Add New House\n" +
                    "3.Add New Room\n" +
                    "4.Back to menu");
            Scanner scanner = new Scanner(System.in);
            choose = (scanner.nextLine());

            switch (choose) {
                case "1":
                    villaService = new VillaServiceImpl();
                    villaService.add();
                    break;
                case "2":
                    roomService = new RoomServiceImpl();
                    roomService.add();
                    break;
                case "3":
                    houseService = new HouseServiceImpl();
                    houseService.add();
                    break;
                case "4":
                   return;
                default:
                    System.out.println("choose again");
            }

        } while (true);
    }

    @Override
    public void display() {
        Map<Facility,Integer>  facilityIntegerMap = ReadAndWriteToCSV.readFacility(FILE_FACILITY);
        System.out.println("DISPLAY FACILITY");
        Set<Facility> facilities = facilityIntegerMap.keySet();
        for (Facility facility:facilities
             ) {
            System.out.println(facility);
        }
    }
    @Override
    public void displayListFacilityMaintenance() {

    }


}
