package model;

public class calculate {
    public static float calculator(float firstOperand, float secondOperand, String operator) {
        switch (operator) {
            case "cong":
                return firstOperand + secondOperand;
            case "tru":
                return firstOperand - secondOperand;
            case "nhan":
                return firstOperand*secondOperand;
            case "chia":
                if(secondOperand != 0){
                    return firstOperand/secondOperand;
                }else{
                    throw new RuntimeException("Không thể chia số 0");
                }
            default:
                throw new RuntimeException("không có phép tính để thực hiện");

        }
    }
}
