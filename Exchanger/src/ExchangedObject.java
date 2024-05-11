public class ExchangedObject {
    private final long id;

    public ExchangedObject(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id = " + this.id + "]";
    }
}
