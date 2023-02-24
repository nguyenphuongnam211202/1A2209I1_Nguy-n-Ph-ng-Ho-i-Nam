package common.check_person;

public class CheckName {
    public  static  boolean checkName(String name){
        String regexName = "^([A-Z][a-z]+)(\\s[A-Z][a-z]+)*$";
        return name.matches(regexName);
    }
}
