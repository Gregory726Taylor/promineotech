package cardgame;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> drawnCards;
    private int score;

    public Player(String name) {
        this.drawnCards = new ArrayList<>();
        this.score = 0;
    }

    public void draw(Card card) {
        drawnCards.add(card);
    }

    public Card flip() {
        if (!drawnCards.isEmpty()) {
            Card card = drawnCards.remove(drawnCards.size() - 1);
            return card;
        }
        return null;
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
    
    // Other methods and members as needed
}
