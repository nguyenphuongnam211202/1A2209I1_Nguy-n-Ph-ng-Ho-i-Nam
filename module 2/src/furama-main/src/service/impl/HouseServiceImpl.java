package service.impl;

import common.check_faccility.CheckAreaOfUse;
import common.check_faccility.CheckNameFacility;
import common.check_faccility.CheckNumber;
import common.check_faccility.CheckPeople;
import models.faccility.House;
import service.FacilityService;
import util.ReadAndWriteToCSV;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HouseServiceImpl implements FacilityService {
    private final String FILE_FACILITY = "src/data/DataFacility.csv";
    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        String nameService = null;
        System.out.println("Add new villa");
        do {
            System.out.println("Enter name service");
            nameService = scanner.nextLine();
        } while (!(CheckNameFacility.checkNameFacility(nameService)));
        String areaOfUse = null;
        do {
            System.out.println("Enter area of use");
            areaOfUse = scanner.nextLine();
        } while (!(CheckAreaOfUse.checkAreaOfUse(areaOfUse)));
        String rentalCost = null;
        do {
            System.out.println("Enter rental cost");
            rentalCost = scanner.nextLine();
        } while (!CheckNumber.checkNumber(rentalCost));
        String maxMinPeople = null;
        do {
            System.out.println(" Enter people");
            maxMinPeople = scanner.nextLine();
        } while (!CheckPeople.checkPeople(maxMinPeople));
        String rentalType = null;
        do {
            System.out.println("Enter rental type");
            rentalType = scanner.nextLine();
        }
        while (!CheckNameFacility.checkNameFacility(rentalType));
        String roomStandard = null;
        do {
            System.out.println("Enter room standard");
            roomStandard = scanner.nextLine();
        } while (!CheckNameFacility.checkNameFacility(roomStandard));
        String numberOfFloors = null;
        do {
            System.out.println("Enter number of floors");
            numberOfFloors = scanner.nextLine();
        } while (!CheckNumber.checkNumber(numberOfFloors));
        Map<House,Integer> houseIntegerMap = new LinkedHashMap<>();
        houseIntegerMap.put(new House(nameService,areaOfUse,rentalCost,maxMinPeople,rentalType,roomStandard,numberOfFloors),0);
        ReadAndWriteToCSV.writeHouse(FILE_FACILITY,houseIntegerMap,true);

    }

    @Override
    public void display() {

    }

    @Override
    public void displayListFacilityMaintenance() {

    }
}
