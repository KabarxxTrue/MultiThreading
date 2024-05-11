import java.util.List;

public abstract class CompositeTask<S extends Task> extends Task {
    private final List<S> subTask;

    public CompositeTask(List<S> subTask, long id) {
        super(id);
        this.subTask = subTask;
    }
    @Override
    public void perform() {
        this.subTask.forEach(this::perform);
    }

    protected abstract void perform(S subTask);
}
