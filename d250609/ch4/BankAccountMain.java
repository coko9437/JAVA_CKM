package d250609.ch4;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("추교문");
        bankAccount1.showInfo( 12000);
            // System.out.println("총 계좌개설건수 : "+BankAccount.accountCount);
            System.out.println("====================================================");
        BankAccount bankAccount2 = new BankAccount("김철수");
        bankAccount2.showInfo( 13450);
            // System.out.println("총 계좌개설건수 : "+BankAccount.accountCount);
            System.out.println("====================================================");
        BankAccount bankAccount3 = new BankAccount("이지훈");
        bankAccount3.showInfo(  5421);
            // System.out.println("총 계좌개설건수 : "+BankAccount.accountCount);
            System.out.println("====================================================");
        BankAccount bankAccount4 = new BankAccount("박재민");
        bankAccount4.showInfo(  4321);
            // System.out.println("총 계좌개설건수 : "+BankAccount.accountCount);

        
    }
}
