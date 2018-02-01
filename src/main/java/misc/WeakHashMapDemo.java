package misc;

import java.util.WeakHashMap;

//todo: move to interview_prep project
public class WeakHashMapDemo {

    public static void main(String[] args) {
        WeakHashMap<User, String> map = new WeakHashMap<>();
        User user = new User("123");
        map.put(user, "321");

        System.out.println("map contents: " + map);

        user = null;


        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (map.isEmpty()) {
                System.out.println("object has finally garbage collected at iteration = " + i + " and map is empty now!");
                return;
            } else {
                System.out.println("object is alive at iteration = " + i);
            }
        }
    }


    static class User {
        String name;

        public User(String s) {
            name = s;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("finalizing :)");
        }
    }

}
