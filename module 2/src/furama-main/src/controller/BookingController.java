package controller;

public class BookingController {
    public static void displayBookingManagement() {
        boolean flag = true;
        do {
            System.out.println("Menu" +
                    "\n 1.Add new booking" +
                    "\n 2.Display list booking" +
                    "\n 3.Create new contracts" +
                    "\n 4.Display list contracts" +
                    "\n 5.Edit contracts" +
                    "\n 6.Return main menu");


        } while (flag);
    }

}
