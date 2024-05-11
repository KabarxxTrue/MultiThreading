import java.util.concurrent.CountDownLatch;

public abstract class ResourceTask implements Runnable {
    private long id;
    private CountDownLatch latch;

    public ResourceTask(long id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        this.run(this.latch);
    }

    protected abstract void run(CountDownLatch latch);

    @Override
    public String toString() {
        return this.getClass().getName() + "[id = " + this.id + "]";
    }
}
