package common.check_faccility;

public class CheckNumber {
    public static boolean checkNumber(String number){
        String regexNumber = "^[1-9][0-9]*$";
        return number.matches(regexNumber);
    }
}
