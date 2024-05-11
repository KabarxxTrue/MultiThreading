import java.util.concurrent.TimeUnit;

public class ExchangedObjectFactory {
    private long nextId;

    public ExchangedObject create() {
        try {
            TimeUnit.SECONDS.sleep(2);
            return new ExchangedObject(this.nextId++);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
