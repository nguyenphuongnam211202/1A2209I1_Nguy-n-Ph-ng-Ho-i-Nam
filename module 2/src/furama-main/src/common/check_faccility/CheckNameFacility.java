package common.check_faccility;

public class CheckNameFacility {
   public static boolean checkNameFacility(String name){
           String regexName = "^[A-Z][a-z]+$";
           return name.matches(regexName);
   }

}
