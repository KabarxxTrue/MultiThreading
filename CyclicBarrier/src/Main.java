import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        final int subTaskCountInMainTask = 2;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(
                subTaskCountInMainTask,
                () -> System.out.println("*************************")
        );

        LeafTask firstLeafTask = new LeafTask(0, 5, cyclicBarrier);
        LeafTask secondLeafTask = new LeafTask(1, 3, cyclicBarrier);
        LeafTask thirdLeafTask = new LeafTask(2, 1, cyclicBarrier);
        SubTask firstSubTask = new SubTask(0, List.of(firstLeafTask, secondLeafTask, thirdLeafTask));

        LeafTask fourthLeafTask = new LeafTask(3, 6, cyclicBarrier);
        LeafTask fifthLeafTask = new LeafTask(4, 4, cyclicBarrier);
        LeafTask sixthLeafTask = new LeafTask(5, 2, cyclicBarrier);
        SubTask secondSubTask = new SubTask(1, List.of(fourthLeafTask, fifthLeafTask, sixthLeafTask));

        MainTask mainTask = new MainTask(0, List.of(firstSubTask, secondSubTask));
        mainTask.perform();
    }
}