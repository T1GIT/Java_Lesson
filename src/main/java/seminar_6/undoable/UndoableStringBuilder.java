package seminar_6.undoable;


import java.io.IOException;


/**
 * A mutable sequence of characters. This class is the wrapper of the class
 * {@code StringBuilder}, but with possibility of returning actions back.
 * This class has almost all the same methods, as the {@code StringBuilder},
 * also {@link java.io.Serializable}, and has the same interface.
 * {@inheritDoc {@link StringBuilder}}
 * It has methods for working with history of changing its value:
 * {@code undo()}, {@code redo()} and etc.
 * @see Undoable
 *
 * @author T1MON
 * @see StringBuilder
 * @since 1.5
 */
public final class UndoableStringBuilder
    implements Undoable, Comparable<UndoableStringBuilder>, CharSequence, Appendable
{
    private final StringBuilder sb;
    private final History history;

    public UndoableStringBuilder() { this(-1, null); }
    public UndoableStringBuilder(int capacity) { this(capacity, null); }
    public UndoableStringBuilder(String start) { this(-1, start); }
    public UndoableStringBuilder(CharSequence seq) {this(-1, String.valueOf(seq));}

    private UndoableStringBuilder(int capacity, String start) {
        if (start == null) {
            if (capacity == -1) {
                sb = new StringBuilder();
            } else {
                sb = new StringBuilder(capacity);
            }
        } else {
            sb = new StringBuilder(start);
        }
        history = new History();
    }

    /**
     * Undoable functions.
     * All of them you can undo with method {@code undo()}
     * and redo, using method {@code redo()}.
     * Everyone writes in {@code history} stack, what you do with object
     * via this functions.
     * @see History
     */

    public <T> UndoableStringBuilder append(T obj) {
        String type = "append";
        sb.append(obj);
        history.add(type, obj);
        return this;
    }

    public Appendable appendCodePoint(int codePoint) {
        if (Character.isBmpCodePoint(codePoint)) { return append((char)codePoint); }
        return append(Character.toChars(codePoint));
    }

    public UndoableStringBuilder delete(int start, int end) {
        String type = "delete";
        String delString = sb.substring(start, end);
        sb.delete(start,end);
        history.add(type, start, end, delString);
        return this;
    }

    public UndoableStringBuilder deleteCharAt(int index) {
        String type = "deleteCharAt";
        char delChar = sb.charAt(index);
        sb.deleteCharAt(index);
        history.add(type, index, delChar);
        return this;
    }

    public UndoableStringBuilder replace(int start, int end, Object obj) {
        String type = "replace";
        String newVal = String.valueOf(obj);
        String oldVal = sb.substring(start, end);
        sb.replace(start, end, newVal);
        history.add(type, start, end, newVal, oldVal);
        return this;
    }

    public UndoableStringBuilder insert(int offset, Object obj) {
        String type = "insert";
        sb.insert(offset, obj);
        history.add(type, offset, obj);
        return this;
    }

    public UndoableStringBuilder insert(int index, char[] str, int offset, int len) {
        String type = "insert2";
        sb.insert(index, str, offset, len);
        history.add(type, index, str, offset, len);
        return this;
    }

    public UndoableStringBuilder insert(int dstOffset, CharSequence s, int start, int end)
    {
        String type = "insert3";
        sb.insert(dstOffset, s, start, end);
        history.add(type, dstOffset, s, start, end);
        return this;
    }

    public UndoableStringBuilder reverse() {
        String type = "reverse";
        sb.reverse();
        history.add(type);
        return this;
    }

    /**
     * Gets {@code History}'s node.
     * Extracts {@code type} and {@code args} from it.
     * Returns one action back by doing reversed function and moves {@code history.cursor} back.
     * @throws UndoableException.UndoNotAvailable if {@code history}'s stack ended.
     * @throws UndoableException.UnknownTypeOfAction if {@code history}'s node includes
     * unknown action type.
     */
    @Override
    public void undo() {
        try {
            if (!hasUndo()) throw new  UndoableException.UndoNotAvailable();
            Object[] args = history.down();
            String type = (String) args[0];
            // Repeated arguments in the actions
            int start; int end; int index;
            switch (type) {
                case "append":
                    int AppendLen = ((String) args[1]).length();
                    sb.delete(sb.length() - AppendLen, sb.length());
                    break;
                case "delete":
                    start = (int) args[1];
                    String delString = (String) args[3];
                    sb.insert(start, delString);
                    break;
                case "deleteCharAt":
                    index = (int) args[1];
                    char delChar = (char) args[2];
                    sb.insert(index, delChar);
                    break;
                case "replace":
                    String oldVal = (String) args[4];
                    start = (int) args[1];
                    sb.replace(start, start + oldVal.length(), oldVal);
                    break;
                case "insert":
                    int offset = (int) args[1];
                    int objLen = String.valueOf(args[2]).length();
                    sb.delete(offset, offset + objLen);
                    break;
                case "insert2":
                case "insert3":
                    index = (int) args[1];
                    int len = (int) args[4];
                    sb.delete(index, index + len);
                    break;
                case "reverse":
                    sb.reverse();
                    break;
                default:
                    throw new UndoableException.UnknownTypeOfAction();
            }
        } catch (UndoableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets {@code History}'s node.
     * Extracts {@code type} and {@code args} from it.
     * Returns one action forward by doing function and moves {@code history.cursor} forward.
     * @throws UndoableException.UndoNotAvailable if {@code history}'s stack ended.
     * @throws UndoableException.UnknownTypeOfAction if {@code history}'s node includes
     * unknown action type.
     */
    @Override
    public void redo() {
        try {
            if (!hasRedo()) throw new  UndoableException.RedoNotAvailable();
            Object[] args = history.up();
            String type = (String) args[0];
            // Repeated arguments in the actions
            Object obj; int index; int offset; int len; int start; int end;
            // Main body of redoing process
            switch (type) {
                case "append":
                    obj = args[1];
                    sb.append(obj);
                    break;
                case "delete":
                    start = (int) args[1];
                    end = (int) args[2];
                    sb.delete(start, end);
                    break;
                case "deleteCharAt":
                    index = (int) args[1];
                    sb.deleteCharAt(index);
                    break;
                case "insert":
                    offset = (int) args[1];
                    obj = args[2];
                    sb.insert(offset, obj);
                    break;
                case "insert2":
                    index = (int) args[1];
                    char[] str = (char[]) args[2];
                    offset = (int) args[3];
                    len = (int) args[4];
                    sb.insert(index, str, offset, len);
                    break;
                case "insert3":
                    int dstOffset = (int) args[1];
                    CharSequence s = (CharSequence) args[2];
                    start = (int) args[3];
                    end = (int) args[4];
                    sb.insert(dstOffset, s, start, end);
                    break;
                case "reverse":
                    sb.reverse();
                    break;
                default:
                    throw new UndoableException.UnknownTypeOfAction();
            }
        } catch (UndoableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Repeats undoing via {@code undo()} {@code repeat} times.
     * @param repeats amount of actions to undoing.
     */
    @Override
    public void undo(int repeats) {
        try {
            if (repeats > history.cursorPos) throw new UndoableException.WrongRepeats(history.cursorPos, repeats);
            for (int i = 0; i < repeats; i++) { undo(); }
        } catch (UndoableException.WrongRepeats e) {
            e.printStackTrace();
        }
    }

    /**
     * Repeats redoing via {@code redo()} {@code repeat} times.
     * @param repeats amount of actions to redoing.
     * @throws UndoableException.WrongRepeats if {@code repeats} is more then it can be.
     */
    @Override
    public void redo(int repeats) {
        try {
            System.out.println(repeats+" "+history.length+" "+history.cursorPos);
            if (repeats > history.length - history.cursorPos) throw new UndoableException.WrongRepeats(history.length - history.cursorPos, repeats);
            for (int i = 0; i < repeats; i++) { this.redo(); }
        } catch (UndoableException.WrongRepeats e) {
            e.printStackTrace();
        }
    }

    @Override
    public void undoAll() { while (history.cursor.args[0] != null) this.undo(); }

    @Override
    public void redoAll() { while (history.cursor.next != null) this.redo(); }

    @Override
    public boolean hasUndo() { return history.cursor.hasPrev(); }

    @Override
    public boolean hasRedo() { return history.cursor.hasNext(); }

    /**
     * {@code StringBuilder}'s own functions.
     * Have the same functionality and interface as them analogs
     * in the {@code StringBuilder}.
     */

    @Override
    public Appendable append(CharSequence csq) { return append((Object) csq); }
    @Override
    public Appendable append(CharSequence csq, int start, int end) { return replace(start, end, csq); }
    @Override
    public Appendable append(char c) { return append((Object) c); }
    @Override
    public int length() { return sb.length(); }
    @Override
    public char charAt(int index) { return sb.charAt(index); }
    @Override
    public CharSequence subSequence(int start, int end) { return sb.subSequence(start, end); }
    @Override
    public String toString() { return sb.toString(); }
    @Override
    public int compareTo(UndoableStringBuilder another) { return sb.compareTo(another.sb); }
    public int compareTo(StringBuilder another) { return sb.compareTo(another); }
    public int indexOf(String str) { return sb.indexOf(str); }
    public int lastIndexOf(String str) { return sb.lastIndexOf(str); }
    public String substring(int start, int end) { return sb.substring(start, end); }
    public String substring(int start) { return sb.substring(start); }

    /**
     * History class.
     * Contains my own realization of simple Stack with moving through elements without pop them.
     */
    private static class History {
        private final int HISTORY_MAX_LENGTH = 100;
        private final HistoryNode head;
        private HistoryNode cursor;
        private int cursorPos;
        private int length;

        public History() {
            this.head = new HistoryNode((Object) null);
            this.cursor = head;
            this.cursorPos = 0;
            this.length = 0;
        }

        public void add(Object ... args) {
            // Erases last action, if History is overflowed.
            if (length == HISTORY_MAX_LENGTH) {
                head.next = head.next.next;
                length--;
            }
            HistoryNode firstToRemove = cursor.next;
            cursor.setNext(args);
            cursor = cursor.next;
            cursorPos++;
            length++;
            // Removing all the next actions in case, if new action was inserted not in the end
            while (firstToRemove != null) {
                HistoryNode next = firstToRemove.next;
                firstToRemove.next = firstToRemove.prev = null;
                firstToRemove = next;
                length--;
            }
            System.gc();
        }

        public Object[] down() throws UndoableException.UndoNotAvailable {
            try {
                if (cursor.prev == null || (String) cursor.args[0] == null) throw new UndoableException.UndoNotAvailable();
                Object[] args = cursor.args;
                cursor = cursor.prev;
                cursorPos--;
                return args;
            } catch (UndoableException.UndoNotAvailable e) {
                e.printStackTrace();
            }
            return null;
        }

        public Object[] up() {
            try {
                if (cursor.next == null) throw new UndoableException.RedoNotAvailable();
                cursor = cursor.next;
                Object[] args = cursor.args;
                cursorPos++;
                return args;
            } catch (UndoableException.RedoNotAvailable e) {
                e.printStackTrace();
            }
            return null;
        }

        private static class HistoryNode {
            /**
             * Contains:
             *      {@code args[0]} - type ({@code String}.
             *      {@code args[1 - ...]} - arguments of action's function.
             *      {@code args[... - ...]} - arguments the function {@code undo} need to returning action back.
             */
            private final Object[] args;
            private HistoryNode prev = null;
            private HistoryNode next = null;

            public void setNext(Object... args) {
                next = new HistoryNode(args);
                next.prev = this;
            }

            public boolean hasNext() { return next != null; }
            public boolean hasPrev() { return args[0] != null; }

            public HistoryNode(Object... args) { this.args = args; }
        }

    }
}
