import java.util.Scanner;

public class Atm {
    static Scanner ac = new Scanner(System.in);
    static int[] noOfCurrency = {0, 0, 0, 0};
    static int[] currency = {100, 200, 500, 2000};
    static int total = 0;
    static String name = "Chandhru";
    static int uspin = 9876;
    static int usbalance = 98000;

   //user

    public static void withdraw() {
        System.out.println("Enter Withdraw Amount :");
        System.out.println("Multiples Of :");
        for (int i = 0; i < 4; i++) {
            if (noOfCurrency[i] > 0)
                System.out.print(currency[i] + "s ");
        }
        int withDrawAmt = ac.nextInt();
        if (withDrawAmt > total) {
            System.out.println("Enter Minimum Amount.... ");
        } else {
            int noOfNote = 0;
            for (int j = 3; j >= 0; j--) {
                while (withDrawAmt >= currency[j] && noOfCurrency[j] > 0) {
                    withDrawAmt -= currency[j];
                    noOfCurrency[j]--;
                    noOfNote++;
                }
            }if(noOfNote > 1) {
                System.out.println("Collect Your number of notes : " + noOfNote);
            }else{
                System.out.println("Collect Your note : " + noOfNote);
            }
            total -= withDrawAmt;
            usbalance -= withDrawAmt;
            System.out.println("Amount Withdrawed Succesfully...");
            System.out.println("Collect Your Amount...");
        }
    }

    public static void pinChange() {
        System.out.println("Enter Your Old Pin : ");
        int n = ac.nextInt();
        if (n == uspin) {
            System.out.println("Enter new pin");
            uspin = ac.nextInt();
            System.out.println("Your Pin Has Been changed Succesfully");
        }else{
            System.out.println("Wrong pin...Enter Correct pin");
        }
    }

    public static void deposit() {
        int total = usbalance;
        int dep = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter No of " + currency[i] + "->");
            int n = ac.nextInt();
            noOfCurrency[i] += n;
            total += currency[i] * n;
            usbalance += currency[i] * n;
            dep += currency[i]*n;
        }
        System.out.println("Amount deposited Successfully..."+"Amount deposited = "+dep);
    }


    private static void checkBalance() {
        System.out.println("Balance : " + usbalance);
    }

    public static void userlogin() {
        System.out.println("You Have Choosen User Login");
        System.out.println("Enter User Name and Password");
        String userName = ac.next();
        int userPassword = ac.nextInt();
        int usop = 0;
        if (userName.equals(name) && userPassword == uspin) {
            do {
                System.out.println("Welcome");
                System.out.println("1.Withdraw Amount");
                System.out.println("2.Check Balance");
                System.out.println("3.Pin change");
                System.out.println("4.Direct Deposit");
                System.out.println("5.Exit");
                System.out.println("Enter Your Choice");
                usop = ac.nextInt();
                switch (usop) {
                    case 1:
                        withdraw();
                        break;
                    case 2:
                        checkBalance();
                        break;
                    case 3:
                        pinChange();
                        break;
                    case 4:
                        deposit();
                        break;
                    case 5:
                        break;
                }
            } while (usop != 5);
        }else{
            System.out.println("Invalid UserName and Password");
        }
    }


    //Admin
    public static void addamount() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter No of " + currency[i] + "->");
            noOfCurrency[i] += ac.nextInt();
        }System.out.println("Amount Succesfully Loaded...");
    }

    public static void atmBalance() {
        int tot = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println("No of " + currency[i] + "->" + noOfCurrency[i]);
            tot += currency[i] * noOfCurrency[i];
        }
        total = tot;
        System.out.println(tot);
    }

    public static void admin() {
        System.out.println("You Have Choosen Admin Login");
        System.out.println("Enter Admin Name and Password");
        String adminName = ac.next();
        int adminPassword = ac.nextInt();
        int adop = 0;
        if (adminName.equals("Admin") && adminPassword == 98765) {
            do {
                System.out.println("Welcome Admin");
                System.out.println("1.Load");
                System.out.println("2.Check Balance");
                System.out.println("3.Exit");
                System.out.println("Enter Your Choice");
                adop = ac.nextInt();
                switch (adop) {
                    case 1:
                        System.out.println("Enter amount");
                        addamount();
                        break;
                    case 2:
                        System.out.println("ATM Balance");
                        atmBalance();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            } while (adop != 3);
        } else {
            System.out.println("check Admin Name and Password");
        }
    }



    public static void main(String[] args) {
        int ch = 0;
        do {
            System.out.println("Welcome");
            System.out.println("ATM Application");
            System.out.println("1.Admin Login");
            System.out.println("2.User Login");
            System.out.println("3.Exit");
            ch = ac.nextInt();
            switch (ch) {
                case 1:
                    admin();
                    break;
                case 2:
                    userlogin();
                    break;
                case 3:
                    break;
            }
        } while (ch != 3);
        System.out.println("Thanks for Using");
    }
}

