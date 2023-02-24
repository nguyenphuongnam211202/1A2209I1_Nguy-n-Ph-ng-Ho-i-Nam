package common.check_person;

public class CheckCode {

    public static boolean checkCode(String code) {
        String regexCode = "^\\d+$";
        return code.matches(regexCode);

    }
}