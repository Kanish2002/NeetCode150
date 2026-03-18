import java.util.HashSet;
import java.util.LinkedHashMap;

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
                if(!rows[i].add(val) || !cols[j].add(val) || !box[i/3][j/3].add(val)) return false;
            }
        }
        return true;

    }
}



