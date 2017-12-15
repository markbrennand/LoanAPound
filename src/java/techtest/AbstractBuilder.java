package techtest;

public abstract class AbstractBuilder<T> {
    private T instance = create();

    public abstract T create();
    public abstract T build();

    protected T instance() {
        return instance;
    }
}
