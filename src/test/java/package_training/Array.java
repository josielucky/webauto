package package_training;

import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] array= new int[]{2,4,6,5,9,0};
        String a = "123";
        int b = Integer.valueOf(a);
        int c = Integer.parseInt(a);

        System.out.println(b);
        System.out.println(c);
        System.out.println(Arrays.toString(array));//[2, 4, 6, 5, 9, 0]
        System.out.println(array.getClass());//class [I

        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0;i < array.length; i++){
            list.add(array[i]);
        }
        System.out.println(list);//[2, 4, 6, 5, 9, 0]
        System.out.println(list.getClass());//class java.util.ArrayList
    }
}


