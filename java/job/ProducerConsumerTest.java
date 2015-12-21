
public class ProducerConsumerTest {

    public static void main(String[] args) {
        PublicResource resource = new PublicResource();
        new Thread(new ProducerThread(resource)).start();
        new Thread(new ConsumerThread(resource)).start();
        new Thread(new ProducerThread(resource)).start();
        new Thread(new ConsumerThread(resource)).start();
        new Thread(new ProducerThread(resource)).start();
        new Thread(new ConsumerThread(resource)).start();
    }
}

/**
 * 生产者线程，负责生产公共资源
 */
class ProducerThread implements Runnable {
    private PublicResource resource;

    public ProducerThread(PublicResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.increase();
        }
    }
}

/**
 * 消费者线程，负责消费公共资源
 */
class ConsumerThread implements Runnable {
    private PublicResource resource;

    public ConsumerThread(PublicResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.decrease();
        }
    }
}

/**
 * 公共资源类
 */
class PublicResource {
    private int number = 0;
    private int size = 10;

    /**
     * 增加公共资源
     */
    public synchronized void increase() {
        while (number >= size) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println("生产了1个，总共有" + number);
        notifyAll();
    }

    /**
     * 减少公共资源
     */
    public synchronized void decrease() {
        while (number <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println("消费了1个，总共有" + number);
        notifyAll();
    }
}
