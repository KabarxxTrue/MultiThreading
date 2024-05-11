import java.util.concurrent.CountDownLatch;

public class ResourceHandlerFactory extends ResourceTaskFactory {

    @Override
    protected ResourceHandler createTask(long id, CountDownLatch latch) {
        return new ResourceHandler(id, latch);
    }
}
