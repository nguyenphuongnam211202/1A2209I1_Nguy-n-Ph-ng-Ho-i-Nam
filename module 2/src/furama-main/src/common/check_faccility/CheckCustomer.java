package common.check_faccility;

import models.person.Customer;
import util.ReadAndWriteToCSV;

import java.util.List;

public class CheckCustomer {
    private static final String FILE_CUSTOMER = "src/data/DataCustomer.csv";

    public static boolean checkCMND(String id) {
        List<Customer> customers = ReadAndWriteToCSV.readCustomer(FILE_CUSTOMER);

        for (int i = 0; i < customers.size(); i++) {
            if (id.equals(customers.get(i).getCode())) {
                return false;
            }
        }
        return true;
    }
}

