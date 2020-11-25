package attestation_1.seminar_7;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Crosses_zeros {
    private final int SIZE = 3;
    private final char[][] field = new char[SIZE][SIZE];
    private final char[] sign = new char[]{'X', 'O'};
    private final int AMOUNT_OF_PLAYERS = sign.length;
    private final String[] names = new String[AMOUNT_OF_PLAYERS];
    private final Scanner scr = new Scanner(System.in);

    public void start() {
        for (char[] chars: field) Arrays.fill(chars, ' ');
        inputNames();
        int winnerNum = mainloop();
        printField();
        if (winnerNum == -1) System.out.println("   Draw");
        else System.out.println("   Winner: " + names[winnerNum]);

    }

    private void inputNames() {
        for (int i = 0; i < AMOUNT_OF_PLAYERS; i++) {
            System.out.print("Input player name: ");
            names[i] = scr.nextLine();
        }
    }

    private void printField() {
        for (char[] chars : field) {
            for (char aChar : chars) System.out.print(aChar + "  "); System.out.println();
        }
    }

    private boolean checkWin(char sym) {
        int counter = 0;
        // check: -
        for (char[] chars : field) {
            for (char aChar : chars) if (aChar == sym) counter++;
            if (counter == SIZE) return true;
            else counter = 0;
        }
        // check: |
        for (int col = 0; col < SIZE; col++) {
            for (int row = 0; row < SIZE; row++) if (field[row][col] == sym) counter++;
            if (counter == SIZE) return true;
            else counter = 0;
        }
        // check: \
        for (int rc = 0; rc < SIZE; rc++) if (field[rc][rc] == sym) counter++;
        if (counter == SIZE) return true;
        else counter = 0;
        //  check: /
        for (int rc = 0; rc < field[0].length; rc++) if (field[rc][SIZE - 1 - rc] == sym) counter++;
        return counter == SIZE;
    }

    private boolean checkDraw() {
        for(char[] chars: field) for (char ch : chars) if (ch == ' ') return false;
        return true;
    }

    private int mainloop() {
        int curPlayer = new Random().nextInt(AMOUNT_OF_PLAYERS);
        while (true) {
            printField();
            System.out.print("Player " + names[curPlayer] + " give coordinates (x y): ");
            int x = scr.nextInt(); int y = scr.nextInt();
            while (x < 0 || x >= SIZE || y < 0 || y >= SIZE || field[y][x] != ' ') {
                System.out.print("Coordinates isn't correct, retype (x y): ");
                x = scr.nextInt(); y = scr.nextInt();
            }
            field[y][x] = sign[curPlayer];
            if (checkDraw()) return -1;
            if (checkWin(sign[curPlayer])) return curPlayer;
            else curPlayer = (curPlayer + 1) % AMOUNT_OF_PLAYERS;
        }
    }
}
