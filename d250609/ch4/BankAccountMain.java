package d250609.ch4;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.showInfo("추교문", 12000);
            System.out.println("총 계좌개설건수 : "+BankAccount.accountCount);
            System.out.println("====================================================");
        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.showInfo("김철수",  13450);
            System.out.println("총 계좌개설건수 : "+BankAccount.accountCount);
            System.out.println("====================================================");
        BankAccount bankAccount3 = new BankAccount();
        bankAccount3.showInfo("이지훈",  5421);
            System.out.println("총 계좌개설건수 : "+BankAccount.accountCount);
            System.out.println("====================================================");
        BankAccount bankAccount4 = new BankAccount();
        bankAccount4.showInfo("박재민",  4321);
            System.out.println("총 계좌개설건수 : "+BankAccount.accountCount);

        
    }
}
