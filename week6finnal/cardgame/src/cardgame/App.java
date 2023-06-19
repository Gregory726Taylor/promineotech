package cardgame;


public class App {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        for (int i = 0; i < 52; i++) {
            Card card = deck.draw();
            player1.draw(card);
        }

        for (int i = 0; i < 52; i++) {
            Card card = deck.draw();
            player2.draw(card);
        }

        for (int i = 0; i < 26; i++) {
            player1.flip();
            player2.flip();
        }

        for (int i = 0; i < 26; i++) {
            int player1CardValue = player1.flip().getValue();
            int player2CardValue = player2.flip().getValue();

            if (player1CardValue > player2CardValue) {
                player1.incrementScore();
            } else if (player2CardValue > player1CardValue) {
                player2.incrementScore();
            }
        }

        int player1Score = player1.getScore();
        int player2Score = player2.getScore();

        System.out.println("Final Score:");
        System.out.println("Player 1: " + player1Score);
        System.out.println("Player 2: " + player2Score);

        if (player1Score > player2Score) {
            System.out.println("Player 1 wins!");
        } else if (player2Score > player1Score) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
