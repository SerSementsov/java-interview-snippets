package generics;

public class HeapPollutionWithArraysExample {
    public static void main(String[] args) {
        Number[] numbers = new Number[]{1, 2, 3};
        numbers[0] = 1.5; // heap pollution

//        List<Number> numbersList = new ArrayList<Integer>(); //doesn't compile
//        numbersList.add(1.0);// could be heap pollution
    }
}
