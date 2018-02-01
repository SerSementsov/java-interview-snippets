package misc;

//todo: move to interview_prep project
public class AutoCloseableDemo {
    public static void main(String[] args) {
        try (A a = new A(); B b = new B(); C c = new C()) {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class A implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("closing to_move.A");
    }

    @Override
    public String toString() {
        return "to_move.A{}";
    }
}

class B implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new RuntimeException("closing to_move.B");
    }

    @Override
    public String toString() {
        return "to_move.B{}";
    }
}

class C implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new RuntimeException("closing to_move.C");
    }

    @Override
    public String toString() {
        return "to_move.C{}";
    }
}