package questions.older;

public class Question02 {
    public static void main(String[] args) {

    }
}

// 饿汉式 线程安全
class Singleton1 {
    private static final Singleton1 instance = new Singleton1();
    private Singleton1() {}
    public static Singleton1 getInstance() {
        return instance;
    }
}

// 懒汉式 线程安全
class Singleton2 {
    private static volatile Singleton2 instance = null;
    private Singleton2() {}
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null)
                    instance = new Singleton2();
            }
        }
        return instance;
    }
}