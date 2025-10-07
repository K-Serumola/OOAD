public class investments extends account implements withdrawable, interest {
    float interesRate;

    public investments(int accountNo,double balance, String branch, float interesRate) {
        super(accountNo,balance,branch);
        this.interesRate=interesRate;
    }
}