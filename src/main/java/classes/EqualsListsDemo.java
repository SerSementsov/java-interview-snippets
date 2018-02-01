package classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class EqualsListsDemo {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
        }};

        List<String> linkedList = new LinkedList<String>() {
            {
                add("1");
                add("2");
                add("3");
            }
        };

        System.out.println(arrayList.equals(linkedList));
        System.out.println(arrayList.equals(asList("1", "2", "3")));
        System.out.println(linkedList.equals(asList("1", "2", "3")));
    }
}
