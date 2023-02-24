package common.check_person;

public class CheckEmail {
    public static boolean checkEmail(String email){
        String regexEmail = "^[a-z0-9]+@[a-z]+\\.[a-z]{2,4}$";
        return email.matches(regexEmail);
    }
}
