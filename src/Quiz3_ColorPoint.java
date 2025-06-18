public class Quiz3_ColorPoint extends Point {
    
    private String color;
    
    public Quiz3_ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    private void setPoint(int x, int y){
        move(x, y);
    }

    private void setColor(String color) {
        this.color = color;
    }

    private void show() {

        System.out.println(color +"색으로 "+"("+getX()+", "+getY()+")");
    }
    public static void main(String[] args) {

        Quiz3_ColorPoint cp = new Quiz3_ColorPoint(5, 5, "YELLOW");
        cp.setPoint(10, 20);
        cp.setColor("GREEN");
        cp.show();

    }

    

    
}
