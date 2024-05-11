import java.util.Queue;
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<Queue<ExchangedObject>> exchanger = new Exchanger<>();

        ExchangedObjectFactory objectFactory = new ExchangedObjectFactory();
        final int producedObjectCount = 3;
        ProducingTask producingTask = new ProducingTask(exchanger, objectFactory, producedObjectCount);
        ConsumingTask consumingTask = new ConsumingTask(exchanger);

        new Thread(producingTask).start();
        new Thread(consumingTask).start();
    }
}