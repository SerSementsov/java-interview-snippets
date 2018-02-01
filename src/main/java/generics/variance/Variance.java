package generics.variance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Variance {
    public static void main(String[] args) {
        List<Doge> doges = new ArrayList<>();


        List<Doge> src = new ArrayList<>();
        src.add(new Doge("Buddy"));
        src.add(new Doge("Max"));
        src.add(new Doge("Jake"));

//        copyContents(doges, src);

    }


    static <T> void copyContents(List<T> dest, List<T> src) {
        Collections.copy(dest, src);
    }


}


class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void feed() {
        System.out.println("feeding... " + this.getName());
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}

class Pet extends Animal {
    public Pet(String name) {
        super(name);
    }

    void call() {
        System.out.println("calling " + this.getName());
    }
}

class Kitty extends Pet {

    public Kitty(String name) {
        super(name);
    }

    void meow() {
        System.out.println("meow by " + this.getName());
    }
}

class Doge extends Pet {
    public Doge(String name) {
        super(name);
    }

    void bark() {
        System.out.println("bark! by " + this.getName());
    }
}