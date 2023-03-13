package baitap2.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayScanner {
    public static final String REGEX_NUMBER = "[0-9]+";
    public static final String REGEX_STRING = "[A-Za-z]+";
    private static Scanner scanner = new Scanner(System.in);
    public static List<String> getDataFromConsole(String infoData) {
        String[] data = infoData.split(",");
        List<String> result = new ArrayList<>();
        for (String string: data){
            if (string.equals("CODE") || string.contains("PRICE")
                    || string.equals("QUANTITY") || string.equals("VAT")){
                result.add(checkValid(string, REGEX_NUMBER));
            continue;
            }
            if (string.equals("NAME") || string.contains("MANUFACTURE")
                    || string.equals("IMPORT_DISTRICT") || string.equals("EXPORT_NATION")){
                result.add(checkValid(string, REGEX_STRING));
            continue;
            }
        }
        return result;
    }

    private static String checkValid(String string, String regex) {
        boolean flag = true;
        try{
            while (true) {
                System.out.printf(flag ? "Input %s: " : "Input %s again: ", string);
                String input = scanner.next().trim();
                if (input.matches(regex)) {
                    return input;
                }
                flag = false;
                throw new RegexException(String.format("Must match regex %s",regex));
            }
        }catch (RegexException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
