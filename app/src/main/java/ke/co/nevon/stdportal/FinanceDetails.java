package ke.co.nevon.stdportal;

public class FinanceDetails {
    String reg;
    String amountBilled;
    String amountpaid;
    String balance;

    public FinanceDetails(String reg, String amountBilled, String amountpaid, String balance) {
        this.reg = reg;
        this.amountBilled = amountBilled;
        this.amountpaid = amountpaid;
        this.balance = balance;
    }

    public String getReg() {
        return reg;
    }



    public String getAmountBilled() {
        return amountBilled;
    }

    public String getAmountpaid() {
        return amountpaid;
    }

    public String getBalance() {
        return balance;
    }
}
