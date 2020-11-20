package seminar_6.undoable;


/**
 *  A {@code Undoable} is interface, that allows store actions with objects
 *  and returns it back
 *  {@link Undoable} has methods:
 *      {@code undo()} - for canceling actions
 *      {@code redo()} - for returning canceling back
 *      {@code undoAll()} - for cancelling all of the actions
 *      {@code redoAll()} - for returning all of the cancelling back
 * and class of the {@code Exception} - {@link Undoable.UndoableException}.
 *
 * @author T1MON
 */
public interface Undoable {

    /**
     * Cancels one action with variable back.
     */
    void undo();

    /**
     * Cancels one action with variable, that was reterned by {@code undo} or {@code undoAll} forward.
     */
    void redo();

    /**
     * @param   repeats amount of actions to undoing.
     */
    void undo(int repeats);

    /**
     * @param   repeats amount of actions to redoing.
     */
    void redo(int repeats);

    /**
     * Cancels all the actions with variable back.
     */
    void undoAll();

    /**
     * Cancels all the actions with variable, that was reterned by {@code undo} or {@code undoAll}  forward.
     */
    void redoAll();

    /**
     * @return possibility of undoing object
     */
    boolean hasUndo();

    /**
     * @return possibility of redoing object
     */
    boolean hasRedo();

    /**
     * Superclass for Undoable children's exceptions.
     */
    class UndoableException extends Exception {
        /**
         * Constructs a {@code UndoableException} with the
         * specified detail message.
         *
         * @param   s   the detail message.
         */
        public UndoableException(String s) {
            super(s);
        }

        /**
         * Constructs a {@code UndoableException}
         */
        public UndoableException() {}

        /* Thrown if amount of repeats is more then it is possible */
        static final class WrongRepeats extends UndoableException {
            /**
             * Constructs a {@code WrongRepeats} with the
             * specified detail message.
             *
             * @param   possible   length of value's history.
             * @param   repeats    requested amount of repeats.
             */
            public WrongRepeats(int possible, int repeats) {
                super("Available repeats is " + possible + ", but " + repeats + " was requested");
            }
        }

        /* Thrown if undo if undoing is impossible */
        static final class UndoNotAvailable extends UndoableException { }

        /* Thrown if undo if redoing is impossible*/
        static final class RedoNotAvailable extends UndoableException { }

        /* Thrown if was got type, that this class can't undo or redo*/
        static final class UnknownTypeOfAction extends UndoableException {}
    }
}
