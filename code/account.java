public abstract class account {
    //atributes
    int accountno;
    double balance;
    String branch;

    //constructor
    public account(int accountno, double balance, String branch) {
        this.accountno = accountno;
        this.balance = balance;
        this.branch = branch;
    }

    //getters
    public int getAccountno() {
        return accountno;
    }
    public double getBalance() {
        return balance;
    }
    public String getBranch() {
        return branch;
    }


    //methods
    public void deposit(double ammount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    }
    public static double checkBalance() {
        System.out.println("Your Balance is " + balance );
    }
}
