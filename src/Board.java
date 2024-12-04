import java.util.Random;

public class Board {
    private final char[][] grid;
    private final int rows;
    private final int cols;
    private final Random random = new Random();

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public boolean dropDisc(int col, char disc) {
        if (col < 0 || col >= cols) return false;
        for (int i = rows - 1; i >= 0; i--) {
            if (grid[i][col] == '.') {
                grid[i][col] = disc;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(char disc) {
        // Check horizontal, vertical, and diagonal wins
        return false; // Implementation here
    }

    public int getRandomMove() {
        return random.nextInt(cols);
    }

    public void printBoard() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}


