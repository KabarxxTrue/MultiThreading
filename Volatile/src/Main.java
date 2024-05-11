import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final int resourcesCount = 3;
        CountDownLatch latch = new CountDownLatch(resourcesCount);
        ResourceLoaderFactory loaderFactory = new ResourceLoaderFactory();
        Thread[] threads = createResourceThreads(loaderFactory, resourcesCount, latch);
        ResourceHandlerFactory handlerFactory = new ResourceHandlerFactory();
        final int handlingThreadsCount = 4;
        Thread[] handlingThreads = createResourceThreads(handlerFactory, handlingThreadsCount, latch);

        ThreadUtil.startThreads(threads);
        ThreadUtil.startThreads(handlingThreads);
    }

    private static Thread[] createResourceThreads(ResourceTaskFactory factory,
                                                  int threadsCount,
                                                  CountDownLatch latch) {
        return IntStream.range(0, threadsCount)
                .mapToObj(i -> factory.create(latch))
                .map(Thread::new)
                .toArray(Thread[]::new);
    }
}
