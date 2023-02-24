package common.check_faccility;

public class CheckPeople {
    public static boolean checkPeople(String people){
        String regexPeople = "^(([1][0-9]{0,1})|[1-9])$";
        return people.matches(regexPeople);
    }
}
