package common.check_faccility;

import models.person.Employee;
import util.ReadAndWriteEmployeeToCSV;

import java.util.List;

public class CheckEmployee {
    private static final String FILE_EMPLOYEE = "src/data/DataEmployee.csv";

    public static boolean checkCMND1(String id) {
        List<Employee> employees = ReadAndWriteEmployeeToCSV.readFile(FILE_EMPLOYEE);
        for (int i = 0; i < employees.size(); i++) {
            if (id.equals(employees.get(i).getId())) {
                return false;
            }
        }
        return true;
    }
}
