package homework.ckm940323.ch4폴더;

import java.util.Scanner;

import util.date.DateUtil;

import homework.ckm940323.ch4폴더.*;

public class Car {
    // 설계 클래스 (Array)
    static final int MAX_NUMBERS = 100;

    static String[] name = new String[MAX_NUMBERS];
    static String[] company = new String[MAX_NUMBERS];
    static String[] year = new String[MAX_NUMBERS];
    static String[] regDate = new String[MAX_NUMBERS];

    static Car_Model[] Car_Models = new Car_Model[MAX_NUMBERS];

    static int carCount = 0;

    // 차량 등록
    public static void addCar(Scanner scanner) {
        if (carCount < MAX_NUMBERS) {
            System.out.println("차종을 입력하세요.>>");
            String name = scanner.nextLine();

            System.out.println("제조사명을 입력하세요.>>");
            String company = scanner.nextLine();

            System.out.println("연식을 입력하세요.>>");
            String year = scanner.nextLine();

            String registrationDate = DateUtil.getCurrentDateTime();

            Car_Model car_model = new Car_Model(name, company, year, registrationDate);

            Car_Models[carCount] = car_model;
            carCount++;
            System.out.println("'자동차'가 추가되었습니다: " + name + ", " + company + ", " + year + ", " + registrationDate);
        } else {
            System.out.println("등록할 수 있는 용량을 초과하였습니다.");
        }
    }
    // 차량 조회

    public static void viewCar() {
        if (carCount == 0) {
            System.out.println("등록된 차량이 없습니다.");
            return; // 메서드(함수)를 나가기
        } //유효성 체크
        
        System.out.println("등록된 차량 목록");
        for (int i = 0; i < carCount; i++) {
            Car_Models[i].showInfo();
        }
    }
    // 차량 정보 수정

    public static void updateCar(Scanner scanner) {
        System.out.println("수정할 차량정보의 인덱스를 입력하세요.");

        int index = scanner.nextInt();

        if (index < 0 || index >= carCount) {
            System.out.println("(오류) 인덱스를 다시 입력하세요.");
            return;
        }

        System.out.println("이름을 무엇으로 바꿀까요? :>> ");
        String name = scanner.nextLine();
        System.out.println("제조사의 이름을 무엇으로 바꿀까요? :>> ");
        String company = scanner.nextLine();
        System.out.println("연식을 몇년으로 바꿀까요? :>> ");
        String year = scanner.nextLine();

        String registrationDate = DateUtil.getCurrentDateTime();
        Car_Model car = new Car_Model(name, company, year, registrationDate);

        Car_Models[index] = car;

        System.out.println("차량 정보가 수정되었습니다."
                + name + ", " + company + ", " + year + ", " + registrationDate);

    }

    // 차량 정보 삭제
    public static void deleteCar(Scanner scanner) {
        System.out.println("삭제할 차량의 인덱스 번호를 입력 :>> ");
        int index = scanner.nextInt();
        scanner.nextLine(); // 개행문자 제거

        if (index < 0 || index >= carCount) {
            System.out.println("인덱스를 다시 입력하세요.");
            return;
        }// 유효성체크

        Car_Model car_model = Car_Models[index];
        System.out.println("삭제할 회원 정보 :>> ");
        car_model.showInfo(); // 삭제하는 대상의 정보

        for (int i = index; i < carCount - 1; i++) {
            Car_Models[i] = Car_Models[i + 1];
        }

        Car_Models[carCount - 1] = null;

        carCount--;
        System.out.println("차량정보를 삭제하였음.");

    }

    // 더미데이터 5개 추가
    public static void addDummyCar() {
        for (int i = 0; i < 5; i++) {
            if (carCount < MAX_NUMBERS) {
                Car_Model dummy = new Car_Model("더미 차량" + (i + 1), "메르세데스벤츠" + (i + 1), "10년" + (i + 1),
                        DateUtil.getCurrentDateTime());

                Car_Models[carCount] = dummy;
                carCount++;
            } else {
                System.out.println("더미데이터 추가 실패 :(최대용량 초과)");

            }
        }
    }

    // 검색기능
    public static void searchCar(Scanner scanner) {
        System.out.println("검색할 차량의 이름 또는 제조사를 입력하세요 :>> ");
        String Search = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < carCount; i++) {
            if (Car_Models[i].getName().contains(Search) || Car_Models[i].getCompany().contains(Search)) {
                Car_Models[i].showInfo(); // 정보 출력
            }
        }
        if (!found) {
            System.out.println("검색 결과가 없습니다.");
        }
    }

}