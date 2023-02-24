package common.check_person;

public class CheckPhone {
    public  static  boolean checkPhone(String phone){
        String regexPhone ="^(84)|0[0-9]{9}$";
        return phone.matches(regexPhone);
    }
}
