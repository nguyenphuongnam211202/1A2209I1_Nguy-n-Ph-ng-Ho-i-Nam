package common.check_person;

public class CheckId {
    public  static  boolean checkId(String id){
        String regexId = "^[0-9]{9}$";
        return id.matches(regexId);
    }
    }