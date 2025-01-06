import java.util.Scanner;
class atm{
    float Balance;
    int [] PIN= {1408};

    public void checkPin(){
        System.out.print("Enter your PIN: ");
        Scanner sc=new Scanner(System.in);
        int EnteredPin=sc.nextInt();
        if(EnteredPin== PIN[0]){
            menu();
        }
        else {
            System.out.println("Enter the valid pin");
            checkPin();
        }
    }

    public void menu(){
        System.out.println("Enter your choice: ");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdrawal money");
        System.out.println("3. Deposit money");
        System.out.println("4. Change PIN");
        System.out.println("5. Exit");
        Scanner sc=new Scanner(System.in);
        int opt=sc.nextInt();
        if(opt==1){
            checkBalance();
        }
        else if (opt==2) {
            Withdrawal();
        }
        else if (opt==3) {
            Deposit();
        }
        else if (opt==4) {
            PINChange();
        }
        else if (opt==5) {
            return;
        }
        else{
            System.out.println("Enter the valid Choice");
            menu();
        }
    }

    public void checkBalance(){
        System.out.println("Balance: "+Balance);
        menu();
    }

    public void Withdrawal(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Amount: ");
        int amount=sc.nextInt();
        Scanner r=new Scanner(System.in);
        System.out.print("Enter the PIN: ");
        int p=r.nextInt();
        if(p==PIN[0]){
            if(amount>Balance){
                System.out.println("Insufficient Balance");
                menu();
            }
            else {
                Balance-=amount;
                System.out.println("Withdrawal Successful!!");
                menu();
            }
        }
        else{
            System.out.println("Invalid PIN");
            Withdrawal();
        }
    }

    public void Deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Amount: ");
        int amount=sc.nextInt();
        Balance+=amount;
        System.out.println("Deposit Successful");
        menu();
    }
    public void PINChange(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Old PIN: ");
        int OP=sc.nextInt();
        if (OP==PIN[0]){
            Scanner s = new Scanner(System.in);
            System.out.print("Enter the New PIN: ");
            int b=s.nextInt();
            PIN[0]=b;
            menu();
        }
        else {
            System.out.println("Enter the valid PIN: ");
            PINChange();
        }
    }
}

public class AtmMachine {
    public static void main(String[] args) {
        atm obj=new atm();
        obj.checkPin();
    }
}
