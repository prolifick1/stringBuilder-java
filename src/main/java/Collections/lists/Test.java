package Collections.lists;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        FirstArrayList<Integer> list = new FirstArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(4);
        list.add(5);
        list.add(6);
        list.set(3, 3);

        //list.remove(6);
        list.remove((Integer) 6);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }


    }
}
