package attestation_1.seminar_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DblIter<T> implements Iterator<T> {
    final private Iterator<T> firstIter;
    final private Iterator<T> secondIter;

    public DblIter(Iterator<T> iterator_1, Iterator<T> iterator_2) {
        this.firstIter = iterator_1;
        this.secondIter = iterator_2;
    }

    @Override
    public boolean hasNext() {
        return this.firstIter.hasNext() || this.secondIter.hasNext();
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        ArrayList<T> set = new ArrayList<T>();
        set.add(this.firstIter.hasNext() ? this.firstIter.next() : null);
        set.add(this.secondIter.hasNext() ? this.secondIter.next() : null);
        return (T) set;
    }
}
