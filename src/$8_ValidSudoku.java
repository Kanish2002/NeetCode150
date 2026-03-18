import java.util.*;

/**
 * Problem: Valid Sudoku
 * 
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need 
 * to be validated according to the following rules:
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */

class Main {
    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        $8_ValidSudoku5 sol = new $8_ValidSudoku5();
        System.out.println("Is Valid: " + sol.isValidSudoku(board));
    }
}

// Solution 1: Using LinkedHashMap in O(N^2)
// Why changed: LinkedHashMap is overkill as we only need to check existence. 
// The manual 3x3 check inside the loop is also complex.
class $8_ValidSudoku1 {
    public boolean isValidSudoku(char[][] board) {


        for(int i = 0;i<board.length;i++){
            LinkedHashMap<Character,Integer> rows = new LinkedHashMap<Character,Integer>();
            LinkedHashMap<Character,Integer> columns = new LinkedHashMap<Character,Integer>();
            for(int j = 0;j < board[i].length;j++){
                if(board[i][j]!='.'){
                    if(rows.containsKey(board[i][j])) return false;
                    rows.put(board[i][j],1);
                }
                if(board[j][i]!='.'){
                    if(columns.containsKey(board[j][i])) return false;
                    columns.put(board[j][i],1);
                }
                if(i%3 == 2 && j%3== 2){
                    LinkedHashMap<Character,Integer> threeByThree = new LinkedHashMap<Character,Integer>();
                    for(int m = i-2;m <= i;m++){
                        for(int n = j-2;n <= j;n++){
                            if(board[m][n] != '.')
                                if(threeByThree.containsKey(board[m][n])) return false;
                                else threeByThree.put(board[m][n],1);
                        }
                    }
                }
            }
        }
        return true;
    }
}

// Solution 2: Optimized to HashSet and cleaner loops.
// Why changed: Replacing LinkedHashMap with HashSet improves efficiency. 
// Still processes 3x3 boxes multiple times.
class $8_ValidSudoku2 {
    public boolean isValidSudoku(char[][] board) {


        for(int i = 0;i<board.length;i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            for(int j = 0;j < board[i].length;j++){
                if(board[i][j]!='.'){
                    if(rows.contains(board[i][j])) return false;
                    rows.add(board[i][j]);
                }
                if(board[j][i]!='.'){
                    if(columns.contains(board[j][i])) return false;
                    columns.add(board[j][i]);
                }
                if(i%3 == 2 && j%3== 2){
                    HashSet<Character> box = new HashSet<Character>();
                    for(int m = i-2;m <= i;m++){
                        for(int n = j-2;n <= j;n++){
                            if(board[m][n] != '.')
                                if(box.contains(board[m][n])) return false;
                                else box.add(board[m][n]);
                        }
                    }
                }
            }
        }
        return true;

    }
}

class $8_ValidSudoku3 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character>[] box = new HashSet[9];

        for(int i = 0; i < box.length;i++) box[i] = new HashSet<Character>();
        for(int i = 0;i<board.length;i++){
            rows.clear();
            columns.clear();
            for(int j = 0;j < board[i].length;j++){
                if(board[i][j]!='.'){
                    if(!rows.add(board[i][j])) return false;
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    if(!box[boxIndex].add(board[i][j])) return false;
                }
                if(board[j][i]!='.'){
                    if(!columns.add(board[j][i])) return false;
                }
            }
        }
        return true;

    }
}

class $8_ValidSudoku4 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character>[] box = new HashSet[9];

        for(int i = 0; i < box.length;i++) box[i] = new HashSet<Character>();
        for(int i = 0;i<board.length;i++){
            rows.clear();
            columns.clear();
            for(int j = 0;j < board[i].length;j++){
                char r = board[i][j];
                char c = board[j][i];
                if(r !='.'){
                    if(!rows.add(r)) return false;
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    if(!box[boxIndex].add(r)) return false;
                }
                if(c !='.'){
                    if(!columns.add(c)) return false;
                }
            }
        }
        return true;

    }
}

// Solution 5: Array of HashSets O(N^2) time, O(N^2) space
// Why changed: This is the most efficient and clean approach. It uses arrays of HashSets 
// to track rows, columns, and boxes simultaneously in a single pass.
class $8_ValidSudoku5 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];

        for(int i = 0; i < 9;i++){
            box[i] = new HashSet<Character>();
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
        }

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j < board[i].length;j++){
                char val = board[i][j];
                if(val =='.'){
                    continue;
                }
                int boxIndex = (i / 3) * 3 + (j / 3);
                if(!rows[i].add(val) || !cols[j].add(val) || !box[boxIndex].add(val)) return false;
            }
        }
        return true;

    }
}

class $8_ValidSudoku6 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[][] box = new HashSet[3][3];

        for(int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                box[i][j] = new HashSet<>();
            }
        }

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j < board[i].length;j++){
                char val = board[i][j];
                if(val =='.'){
                    continue;
                }
            }
        }
        return true;
    }
}
