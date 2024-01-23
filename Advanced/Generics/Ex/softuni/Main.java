package Advanced.Generics.Ex.softuni;

import java.util.*;

public class Main {

    public static void main(String[] args) {
    }

    public static <T extends Comparable<T>> T getMin(List<T> list){
        T min = list.getFirst();
        for (T element : list) {
            if(element.compareTo(min) < 0){
                min = element;
            }
        }
        return min;
    }
}