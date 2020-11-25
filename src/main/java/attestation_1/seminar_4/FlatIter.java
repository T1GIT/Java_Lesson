package attestation_1.seminar_4;

import java.util.ArrayList;
import java.util.Iterator;

public class FlatIter<T> implements Iterator<T> {
    final ArrayList<T> storage = new ArrayList<T>();
    int index = 0;

    public FlatIter(Iterator<T> iterator) {
        while (iterator.hasNext()) {
            this.storage.add(iterator.next());
        }
    }

    @Override
    public boolean hasNext() {
        return this.index < this.storage.size();
    }

    @Override
    public T next() {
        return this.storage.get(index++);
    }
}
