package patterns.singletons.holder;

public class Singleton {

    private Singleton(){}

    private static class SingletonHolder{
        private static final Singleton HOLDER_INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.HOLDER_INSTANCE;
    }

}
