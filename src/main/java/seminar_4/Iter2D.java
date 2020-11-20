package seminar_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iter2D<T> implements Iterator<T> {
    private final T[][] array;
    private int index = 0;

    public Iter2D(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < this.array.length * this.array[0].length;
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        return this.array[index / this.array[0].length][index++ % this.array[0].length];
    }
}
