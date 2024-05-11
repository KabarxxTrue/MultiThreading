import java.util.List;

public class SubTask extends CompositeTask<LeafTask> {

    public SubTask(long id, List<LeafTask> leafTasks) {
        super(leafTasks, id);
    }

    @Override
    protected void perform(LeafTask leafTask) {
        leafTask.perform();
    }
}
