public class Quiz4_StudentScore {

    private int length;

    public static void main(String[] args) {
        int[][] scores = {
    {80,60,70}, {90,95,80}, {75,80,100}, {80,70,95}, {100,65,80}
    };

    // 총점, 평균
    int[][] sum = new int[scores.length][1];

    double[][] avg = new double[scores.length][1];

    for(int i=0; i<scores.length; i++) {
        int pre_sum = 0;
        for(int j=0; j<scores[i].length; j++) {
            pre_sum += scores[i][j];
        }
        sum[i][0] = pre_sum;
        avg[i][0] = pre_sum/scores[i].length;
    }
    System.out.println("학생번호     국어   영어   수학    총점    평균");
    System.out.println("===============================================");
    for (int i = 0; i < scores.length; i++) {
        System.out.print((i+1)+"번 학생 :    ");
        for (int j = 0; j < scores[i].length; j++) {
            System.out.print(scores[i][j]+"     ");
        }
        
        System.out.print(sum[i][0]+"    "+ avg[i][0]);
            
            System.out.println();
            
    }
    
    }
}
