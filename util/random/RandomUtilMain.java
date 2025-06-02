package util.random;

public class RandomUtilMain {
    //메인 메소드가 있는 클래스, 실행용 클래스
    public static void main(String[] args) {
        System.out.println("Math.random()을 사용하여 생성된 난수 : "+ RandomUtil.generateRandom());
        System.out.println("1이상 10 이하 사이의 랜덤 정수 : "+ RandomUtil.generateRandomInRange(1, 45));
    
        //랜덤한 숫자를 생성하는 기능, 로또번호 생성
        // 각각의 6자리 숫자를 따로 받아서 출력만 한번에 생성하는 기능
        //정적 메소드를 만들어서 출력 문장에서 랜덤숫자 6개 보여주기

        //단순하게
        // int num1 = RandomUtil.generateRandomInRange(1, 45);
        // int num2 = RandomUtil.generateRandomInRange(1, 45);
        // int num3 = RandomUtil.generateRandomInRange(1, 45);
        // int num4 = RandomUtil.generateRandomInRange(1, 45);
        // int num5 = RandomUtil.generateRandomInRange(1, 45);
        // int num6 = RandomUtil.generateRandomInRange(1, 45);
        //     System.out.println(" 이번 회차 로또 예상번호는 : " +num1+","+num2+","+num3+","+num4+","+num5+","+num6+" 입니다.");

        //중복제거
        
        int min = 1;
        int max = 45;

        int num1 = RandomUtil.generateRandomInRange(min, max);

        int num2;
        do {
            num2 = RandomUtil.generateRandomInRange(min, max);
        } while (num2 == num1);

        int num3;
        do {
            num3 = RandomUtil.generateRandomInRange(min, max);
        } while (num3 == num1 || num3 == num2);

        int num4;
        do {
            num4 = RandomUtil.generateRandomInRange(min, max);
        } while (num4 == num1 || num4 == num2 || num4 == num3);

        int num5;
        do {
            num5 = RandomUtil.generateRandomInRange(min, max);
        } while (num5 == num1 || num5 == num2 || num5 == num3 || num5 == num4);

        int num6;
        do {
            num6 = RandomUtil.generateRandomInRange(min, max);
        } while (num6 == num1 || num6 == num2 || num6 == num3 || num6 == num4 || num6 == num5);
        
        System.out.println(" 이번 회차 로또 예상번호는 : " +num1+","+num2+","+num3+","+num4+","+num5+","+num6+" 입니다.");

        // 메소드 호춭하여 로또번호 생성
        System.out.println("나만의 로또 번호 생성기 프로그램");
            RandomUtil.generateLottoNumbers();
    }
      
}
