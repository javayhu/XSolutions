/**
 * hujiawei 15/9/9
 */
public class StaticSingleton {

    private StaticSingleton() {
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }

}
