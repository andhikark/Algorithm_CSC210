import java.util.Scanner;

public class CrossWord{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[][] puzzle = {
        {'A', 'B', 'C', 'D', 'E'},
        {'F', 'G', 'H', 'I', 'J'},
        {'K', 'L', 'M', 'N', 'O'},
        {'P', 'Q', 'R', 'S', 'T'},
        {'U', 'V', 'W', 'X', 'Y'}
    };  

    String pattern = sc.nextLine() ;

    boolean found = search(puzzle, pattern);

    if (found) {
        System.out.println("Pattern found in the crossword!");
    } else {
        System.out.println("Pattern not found in the crossword.");
    }
}   

    public static boolean search(char[][] puzzle, String pattern) {
    for (int i = 0; i < puzzle.length; i++) {
        for (int j = 0; j < puzzle[0].length; j++) {
            // Case 1: From left to right
            if (j <= puzzle[0].length - pattern.length()) {
                int k = 0;
                while (k < pattern.length() && pattern.charAt(k) == puzzle[i][j + k]) {
                    k++;
                }
                if (k == pattern.length()) {
                    return true;
                }
            }

            // Case 2: From right to left
            if (j >= pattern.length() - 1) {
                int k = 0;
                while (k < pattern.length() && pattern.charAt(k) == puzzle[i][j - k]) {
                    k++;
                }
                if (k == pattern.length()) {
                    return true;
                }
            }

            // Case 3: From up to bottom
            if (i <= puzzle.length - pattern.length()) {
                int k = 0;
                while (k < pattern.length() && pattern.charAt(k) == puzzle[i + k][j]) {
                    k++;
                }
                if (k == pattern.length()) {
                    return true;
                }
            }

            // Case 4: From bottom to up
            if (i >= pattern.length() - 1) {
                int k = 0;
                while (k < pattern.length() && pattern.charAt(k) == puzzle[i - k][j]) {
                    k++;
                }
                if (k == pattern.length()) {
                    return true;
                }
            }

            // Case 5: Diagonal up right --> bottom-left to up-right
            if (j <= puzzle[0].length - pattern.length() && i >= pattern.length() - 1) {
                int k = 0;
                while (k < pattern.length() && pattern.charAt(k) == puzzle[i - k][j + k]) {
                    k++;
                }
                if (k == pattern.length()) {
                    return true;
                }
            }

            // Case 6: Diagonal up left --> bottom-right to up-left
            if (j >= pattern.length() - 1 && i >= pattern.length() - 1) {
                int k = 0;
                while (k < pattern.length() && pattern.charAt(k) == puzzle[i - k][j - k]) {
                    k++;
                }
                if (k == pattern.length()) {
                    return true;
                }
            }

            // Case 7: Diagonal bottom right --> up-left to bottom-right
            if (j <= puzzle[0].length - pattern.length() && i <= puzzle.length - pattern.length()) {
                int k = 0;
                while (k < pattern.length() && pattern.charAt(k) == puzzle[i + k][j + k]) {
                    k++;
                }
                if (k == pattern.length()) {
                    return true;
                }
            }

            // Case 8: Diagonal bottom left --> up-right to bottom-left
            if (j >= pattern.length() - 1 && i <= puzzle.length - pattern.length()) {
                int k = 0;
                while (k < pattern.length() && pattern.charAt(k) == puzzle[i + k][j - k]) {
                    k++;
                }
                if (k == pattern.length()) {
                    return true;
                }
            }
        }
    }

    return false;
}
}


