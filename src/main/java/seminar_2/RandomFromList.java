package seminar_2;

public class RandomFromList {
    private int[] library;

    public RandomFromList(int[] values, int[] repeats) {
        int libLength = 0;
        for (int i = 0; i < repeats.length; i++) {
            libLength += repeats[i];
        }
        this.library = new int[libLength];
        int cursor = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < repeats[i]; j++, cursor++) {
                this.library[cursor] = values[i];
            }
        }
    }

    public int getRandom() {
        int elem = (int) Math.round(Math.random() * (this.library.length - 0.5));
        return this.library[elem];
    }
}
