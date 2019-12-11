package fty.briefs.puissance4;

/**
 * Class that manages a game
 *
 * @author Franck THERY
 */
public class Game {

    // plateau 
    char[][] boardGame;
    // joueurs 
    char[] player = {'X', 'O'};

    /**
     * Init game
     *
     * @param row
     * @param col
     */
    public Game(int row, int col) {
        boardGame = new char[row][col];
    }

    /**
     * Unroll part
     */
    public void play() {
        boolean win = false;
        int coup = 0;
        char piece = ' ';
        resetBoard();
        while (!win && !boardFull()) {
            piece = player[coup];
            Screen.showBoard(boardGame);
            int col = Screen.showPlay(piece);
            while (!isColumnFree(col - 1)) {
                col = Screen.showReplay(piece);
            }
            addPiece(piece, col - 1);
            win = find();
            coup++;
            coup %= player.length;
        }
        // End game 
        if (boardFull() && !win) {
            Screen.showBoard(boardGame);
            Screen.matchNull();
        } else {
            Screen.showBoard(boardGame);
            Screen.winner(piece);
        }
    }

    /**
     * Look for the occurrence of the same part of the board horizontally,
     * vertically and on these diagonals
     */
    private boolean find() {
        // Check the horizontals
        for (int row = 0; row < boardGame.length; row++) {
            if (findAligned(0, row, 1, 0)) {
                return true;
            }
        }
        // Check the verticals
        for (int col = 0; col < boardGame[0].length; col++) {
            if (findAligned(col, 0, 0, 1)) {
                return true;
            }
        }
        // Diagonals (search from the bottom line)
        for (int col = 0; col < boardGame[0].length; col++) {
            // First diagonal ( / )
            if (findAligned(col, 0, 1, 1)) {
                return true;
            }
            // Second diagonal ( \ )
            if (findAligned(col, 0, -1, 1)) {
                return true;
            }
        }
        // Diagonals (search from the left and right columns)
        for (int row = 0; row < boardGame.length; row++) {
            // First diagonal ( / )
            if (findAligned(0, row, 1, 1)) {
                return true;
            }
            // Second diagonal ( \ )
            if (findAligned(Puissance4.COLUMS - 1, row, -1, 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Look for 4 pieces aligned on a line. This line is defined by the starting
     * point, or origin of coordinates (originCol, originRow), and by delta
     * displacement (deltaCol, deltaRow).
     *
     * @param originCol
     * @param originRow
     * @param deltaCol
     * @param deltaRow
     * @return
     */
    private boolean findAligned(int originCol, int originRow, int deltaCol, int deltaRow) {
        char piece = ' ';
        int count = 0;
        int currentCol = originCol;
        int currentRow = originRow;

        while ((currentCol >= 0) && (currentCol < boardGame[0].length)
                && (currentRow >= 0) && (currentRow < boardGame.length)) {
            if (boardGame[currentRow][currentCol] != piece) {
                // If the coin changes, the counter is reset
                piece = boardGame[currentRow][currentCol];
                count = 1;
            } else {
                // Otherwise we increment it
                count++;
            }
            // We go out when the counter reaches 4
            if ((piece != ' ') && (count == 4)) {
                return true;
            }

            // We move on to the next iteration
            currentCol += deltaCol;
            currentRow += deltaRow;
        }
        // No alignment was found
        return false;
    }

    /**
     * Check that there is at least one free box left in the column
     *
     * @param col
     * @return
     */
    public boolean isColumnFree(int col) {
        return boardGame[0][col] == ' ';
    }

    /**
     * Scratch of the matrix with the character ' '
     *
     */
    public void resetBoard() {
        for (char[] boardGame1 : boardGame) {
            for (int col = 0; col < boardGame1.length; col++) {
                boardGame1[col] = ' ';
            }
        }
    }

    /**
     * Adds a piece to the column (last empty line)
     *
     * @param player
     * @param col
     */
    private void addPiece(char player, int col) {
        for (int row = boardGame.length - 1; row >= 0; row--) {
            if (boardGame[row][col] == ' ') {
                boardGame[row][col] = player;
                return;
            }
        }
    }

    /**
     * Check that the board is not full (check the top line if there is an empty
     * column left)
     *
     * @return
     */
    private boolean boardFull() {
        for (int x = 0; x < boardGame[0].length; x++) {
            if (boardGame[0][x] == ' ') {
                return false;
            }
        }
        return true;
    }
}
