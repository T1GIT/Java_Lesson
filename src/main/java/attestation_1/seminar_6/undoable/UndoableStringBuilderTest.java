package attestation_1.seminar_6.undoable;

import org.junit.jupiter.api.Test;

class UndoableStringBuilderTest {

    @Test
    void undo() {
        System.out.println("Test: undo()");
        UndoableStringBuilder usb = new UndoableStringBuilder("abc");
        usb.append("d");
        usb.undo();
        System.out.println(usb);
    }

    @Test
    void redo() {
        System.out.println("Test: redo()");
        UndoableStringBuilder usb = new UndoableStringBuilder("abc");
        usb.append("d");
        usb.undo();
        usb.redo();
        System.out.println(usb);
    }

    @Test
    void undoAll() {
        System.out.println("Test: undoAll()");
        UndoableStringBuilder usb = new UndoableStringBuilder("abc");
        usb.append("d");
        usb.append("e");
        usb.append("f");
        usb.undoAll();
        System.out.println(usb);
    }

    @Test
    void redoAll() {
        System.out.println("Test: redoAll()");
        UndoableStringBuilder usb = new UndoableStringBuilder("abc");
        usb.append("d");
        usb.append("e");
        usb.append("f");
        usb.undoAll();
        usb.redoAll();
        System.out.println(usb);
    }

    @Test
    void hasUndo() {
        System.out.println("Test: hasUndo()");
        UndoableStringBuilder usb = new UndoableStringBuilder("abc");
        usb.append("d");
        System.out.println(usb.hasUndo());
        usb.undoAll();
        System.out.println(usb.hasUndo());
    }

    @Test
    void hasRedo() {
        System.out.println("Test: hasRedo()");
        UndoableStringBuilder usb = new UndoableStringBuilder("abc");
        usb.append("d");
        usb.undo();
        System.out.println(usb.hasRedo());
        usb.redoAll();
        System.out.println(usb.hasRedo());
    }
}