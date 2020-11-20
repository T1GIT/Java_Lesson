package seminar_6.observable;


public interface EventListener {
    <T> void update(String eventType, T obj);
}
