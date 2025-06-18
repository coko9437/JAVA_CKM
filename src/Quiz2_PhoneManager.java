import java.util.ArrayList;
import java.util.Scanner;

public class Quiz2_PhoneManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Quiz2_Phone> phones = new ArrayList<>();
            // 배열

            System.out.print("인원수 >> ");
                int count = scanner.nextInt();
                    scanner.nextLine();
                for (int i=0; i<count; i++) {
                    System.out.print("이름과 전화번호(번호는 연속적으로 입력), 주소 >> ");
                        String[] info = scanner.nextLine().split(" ", -1);
                    if (info.length < 3) {
                        System.out.println("다시입력하세요.");
                        i--;
                        continue;
                    }
                    phones.add(new Quiz2_Phone(info[0], info[1], info[2]));
                    
                }
                System.out.println("저장되었습니다...");
                System.out.println();
            while (true) {
                System.out.print("검색할 이름 >> ");
                    String Sname = scanner.nextLine();
                if (Sname.equals("exit")) {
                System.out.print("프로그램을 종료합니다...");
                    break;    
                }
                
                Quiz2_Phone Search = null; //검색한사람 담을변수

                for (Quiz2_Phone member : phones) {
                        if(member.name.equals(Sname)) {
                            Search = member;
                            break;
                        }
                }

                if (Search != null) {
                    Search.showInfo();
                } else {
                    System.out.println(Sname+" 은(는) 없습니다.");
                }
            }
            scanner.close();

    }
   
}
