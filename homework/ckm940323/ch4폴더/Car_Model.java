package homework.ckm940323.ch4폴더;

import java.util.Scanner;

import ch3.Exs_ch3_2_user_array_doc;

public class Car_Model {
    // 모델 클래스
    
    String name;
    String company;
    String year;
    String regDate;

    //생성자
    public Car_Model(String name, String company, String year, String regDate) {
        this.name = name;
        this.company = company;
        this.year = year;
        this.regDate = regDate;

    }
    //메소드
    public void showInfo() {
        System.out.println("자동차 이름"+this.name);
        System.out.println("자동차 제조사"+this.company);
        System.out.println("자동차 연식"+this.year);
        System.out.println("자동차 등록일"+this.regDate);
    }

    // 검색을 위해서 해당 이름과 이메일 정보를 조회하는기능.
    // 이름 조회 기능 (게터) : 자동 생성 또는 라이브러리에서.
    // 이름조회기능 : 게터
    public String getName() {
        return name;
    }

    // 이메일 조회기능 : 게터
    public String getCompany() {
        return company;
    }

    public static void Car_ui(Scanner scanner) {
        // Ex3-6-4, 배열을 이용한 회원 관리 프로그램 예시
        int menu;
        do {
            System.out.println("차량 등록 프로그램 예시");
            System.out.println("=================================================================");
            System.out.println("1. 차종 추가 , 2. 조회, 3. 수정, 4. 삭제, 5.더미 데이터 추가(5개) , 6. 검색기능,  0. 종료");
            System.out.println("=================================================================");
            System.out.print("메뉴를 선택하세요(0 ~ 6): ");
            menu = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거
            switch (menu) {
                case 1:
                    homework.ckm940323.ch4폴더.Car.addCar(scanner); // 차종 추가
                    break;
                case 2:
                    homework.ckm940323.ch4폴더.Car.viewCar(); //  조회
                    break;
                case 3:
                    homework.ckm940323.ch4폴더.Car.updateCar(scanner); //  수정
                    break;
                case 4:
                    homework.ckm940323.ch4폴더.Car.deleteCar(scanner); //  삭제
                    break;
                case 5:
                    homework.ckm940323.ch4폴더.Car.addDummyCar(); // 더미 데이터 추가
                    System.out.println("더미 데이터 5개가 추가되었습니다.");
                    break;
                case 6:
                    homework.ckm940323.ch4폴더.Car.searchCar(scanner); //  검색
                    System.out.println("회원 검색 기능이 실행되었습니다.");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 시도하세요.");
            }

        } while (menu != 0); // 메뉴가 0이 아닐 때까지 반복
    }
}
