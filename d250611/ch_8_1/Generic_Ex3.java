package d250611.ch_8_1;

import java.util.ArrayList;

public class Generic_Ex3<T> {
    // 제너릭을 이용한 Stack 자료구조
    // FILO (First In Last Out)
    // 
    private ArrayList<T> list = new ArrayList<>();

    // 데이터 담기(저장 즉. set)
    public void push(T value) {
        list.add(value);
    }

    // 데이터 꺼내기 (즉. get)
    public T pop() {
        // 데이터유무확인(유효성체크)
        if(list.isEmpty()) {
            return null;
        }
        // list = {1, 2, 3, 4, 5} 현재 5개 있음.
        return list.remove(list.size() - 1);
                        // list.size() : 5개 의미함.
                            // list.size() - 1 : 마지막 인덱스 번호.
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public static void main(String[] args) {
        Generic_Ex3<Integer> stack = new Generic_Ex3<>();
            // 스택이라는 자료 구조에 반복문을 이용해서 샘플값 5개 넣는과정.
            for(int i = 1; i<=5; i++) {
                stack.push(i);
            }
            // 모두 꺼냈을 경우는 비워져있다는것을 표현하기
            while (!stack.isEmpty()) {
                System.out.println("스택 자료 구조 형식으로 데이터 꺼내기 ");
                    System.out.println("값 : " + stack.pop());
            }
    }

}
