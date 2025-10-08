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
        if (ammount > 0) {
            balance += ammount;
            System.out.println("Deposited: " + ammount);
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void checkBalance() {
        System.out.println("Your Balance is " + balance);
    }
}
