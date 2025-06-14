package util.random;

public class RandomUtil {
   
    
    public static double generateRandom() {
        double randomValue = Math.random(); // 데이터타입 : double, 변수명 : randomValue
        return randomValue;
    }
    
    public static int generateRandomInRange(int min, int max) {
    // min : 1, max : 10 ...->   1 <= randomValue < 10            
        int randomValue = (int) (Math.random() * (max - min +1)) + min;
        return randomValue;


    }
    
    // 로또 번호 생성 기능
    public static void generateLottoNumbers() {
        int n1 = generateRandomInRange(1, 45);
        int n2;
        do {
            n2 = generateRandomInRange(1, 45);
        } while (n2 == n1); // 중복 체크
        int n3;
        do {
            n3 = generateRandomInRange(1, 45);
        } while (n3 == n1 || n3 == n2); // 중복 체크
        int n4;
        do {
            n4 = generateRandomInRange(1, 45);
        } while (n4 == n1 || n4 == n2 || n4 == n3); // 중복 체크
        int n5;
        do {
            n5 = generateRandomInRange(1, 45);
        } while (n5 == n1 || n5 == n2 || n5 == n3 || n5 == n4); // 중복 체크
        int n6;
        do {
            n6 = generateRandomInRange(1, 45);
        } while (n6 == n1 || n6 == n2 || n6 == n3 || n6 == n4 || n6 == n5); // 중복 체크
        System.out.println("이상용의 자동 로또 번호 생성기 사용한 번호 : "
                + n1 + ", " + n2 + ", " + n3 + ", " + n4 + ", " + n5 + ", " + n6);

    }
}
