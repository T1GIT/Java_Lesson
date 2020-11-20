package seminar_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringOrIter<T> implements Iterator<T> {
    final String string = "String in there";
    final Iterator<T> iterator;

    public StringOrIter(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        if (Math.random() > 0.5) {
            return (T) this.string;
        } else {
            return (T) this;
        }
    }
}
