import java.util.List;

public class MainTask extends CompositeTask<SubTask> {

    public MainTask(long id, List<SubTask> subTasks) {
        super(subTasks, id);
    }

    @Override
    protected void perform(SubTask subTask) {
        new Thread(subTask::perform).start();
    }
}