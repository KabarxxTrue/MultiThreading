import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class LeafTask extends Task {
    private final long secondDuration;
    private final CyclicBarrier cyclicBarrier;

    public LeafTask(long id, long secondDuration, CyclicBarrier cyclicBarrier) {
        super(id);
        this.secondDuration = secondDuration;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void perform() {
        try {
            System.out.printf("%s is started\n", this);
            TimeUnit.SECONDS.sleep(secondDuration);
            System.out.printf("%s has finished\n", this);
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
    }
}
