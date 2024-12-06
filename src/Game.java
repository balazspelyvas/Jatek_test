import java.util.Scanner;

public class Game {
    private final Board board = new Board(6, 7);
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Üdvözöllek!");
        board.printBoard();

        while (true) {
            System.out.print("Válassz egy számot (1-7) a Sárgának (S): ");
            int column = scanner.nextInt() - 1;
            if (!board.dropDisc(column, 'Y')) {
                System.out.println("Érvénytelen lépés. Próbáld újra.");
                continue;
            }

            if (board.checkWin('S')) {
                System.out.println("Sárga nyert!");
                break;
            }

            int aiMove = board.getRandomMove();
            board.dropDisc(aiMove, 'P');
            System.out.println("Piros pöttyök az oszlopban: " + (aiMove + 1));

            if (board.checkWin('R')) {
                System.out.println("Piros nyert!");
                break;
            }

            board.printBoard();
        }
    }
}