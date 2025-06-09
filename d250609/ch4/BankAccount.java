package d250609.ch4;

public class BankAccount {
    String owner; //소유자
    static int accountCount; //계좌 개설 건수

    public static final double INTEREST_RATE = 0.02;

    public BankAccount() {
        this.owner = owner;
            accountCount++;
    }
    public void showInfo(String owner, int principal) {
        System.out.println("소유자 >>> "+ owner);
        System.out.println("현재 이자율 >>> " + INTEREST_RATE);
        double result = principal + (principal*INTEREST_RATE);
        System.out.println("1년후 예상 원금은 >>> " + result);

    }
}
