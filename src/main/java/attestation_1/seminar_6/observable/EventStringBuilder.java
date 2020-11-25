package attestation_1.seminar_6.observable;


public class EventStringBuilder {
    private final StringBuilder sb;
    private final EventManager eventManager = new EventManager(
            "append",
            "appendCodePoint",
            "delete",
            "deleteCharAt",
            "replace",
            "insert",
            "reverse");

    public void bind(String eventType, EventListener listener) { this.eventManager.bind(eventType, listener); }

    public EventStringBuilder() { this.sb = new StringBuilder(16); }

    public EventStringBuilder(int capacity) { this.sb = new StringBuilder(capacity); }

    public EventStringBuilder(String str) {
        this.sb = new StringBuilder(str);
    }
    
    public EventStringBuilder(CharSequence seq) {
        this.sb = new StringBuilder(seq);
    }
    
    public int compareTo(StringBuilder another) { return sb.compareTo(another); }

    public int compareTo(EventStringBuilder another) { return sb.compareTo(another.sb); }

    public <T> EventStringBuilder append(T obj) {
        sb.append(obj);
        eventManager.notify("append", sb);
        return this;
    }

    public EventStringBuilder append(CharSequence s, int start, int end) {
        sb.append(s, start, end);
        eventManager.notify("append", sb);
        return this;
    }

    public EventStringBuilder append(char[] str, int offset, int len) {
        sb.append(str, offset, len);
        eventManager.notify("append", sb);
        return this;
    }

    public EventStringBuilder appendCodePoint(int codePoint) {
        sb.appendCodePoint(codePoint);
        eventManager.notify("appendCodePoint", sb);
        return this;
    }

    public EventStringBuilder delete(int start, int end) {
        sb.delete(start, end);
        eventManager.notify("delete", sb);
        return this;
    }

    public EventStringBuilder deleteCharAt(int index) {
        sb.deleteCharAt(index);
        eventManager.notify("deleteCharAt", sb);
        return this;
    }

    public EventStringBuilder replace(int start, int end, String str) {
        sb.replace(start, end, str);
        eventManager.notify("replace", sb);
        return this;
    }

    public EventStringBuilder insert(int index, char[] str, int offset, int len) {
        sb.insert(index, str, offset, len);
        eventManager.notify("insert", sb);
        return this;
    }

    public <T> EventStringBuilder insert(int offset, T obj) {
        sb.insert(offset, obj);
        eventManager.notify("insert", sb);
        return this;
    }

    public EventStringBuilder insert(int dstOffset, CharSequence s, int start, int end) {
        sb.insert(dstOffset, s, start, end);
        eventManager.notify("insert", sb);
        return this;
    }

    public EventStringBuilder reverse() {
        sb.reverse();
        eventManager.notify("reverse", sb);
        return this;
    }

    public String toString() { return sb.toString(); }

    public int indexOf(String str) { return sb.indexOf(str); }

    public int indexOf(String str, int fromIndex) { return sb.indexOf(str, fromIndex); }

    public int lastIndexOf(String str) { return sb.lastIndexOf(str); }

    public int lastIndexOf(String str, int fromIndex) { return sb.lastIndexOf(str, fromIndex); }

    public int length() { return sb.length(); }

    public int capacity() { return sb.capacity(); }

    public void ensureCapacity(int minimumCapacity) { sb.ensureCapacity(minimumCapacity); }

    public void trimToSize() { sb.trimToSize(); }

    public void setLength(int newLength) { sb.setLength(newLength); }

    public char charAt(int index) { return sb.charAt(index); }

    public int codePointAt(int index) { return sb.codePointAt(index); }

//    It's so boring to write other methods from AbstractStringBuilder, but
//    you may imagine I did it.

//    other methods from AbstractStringBuilder in there ...

}
