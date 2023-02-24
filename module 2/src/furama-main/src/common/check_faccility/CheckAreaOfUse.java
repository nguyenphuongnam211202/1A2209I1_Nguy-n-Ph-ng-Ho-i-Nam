package common.check_faccility;

public class CheckAreaOfUse {
    public static boolean checkAreaOfUse(String area){
        String regexArea = "^[3-9]{2,}(\\,[0-9])*$";
        return area.matches(regexArea);
    }
}
