package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        }
        return null;
    }

    private void initializeDeck() {
        for (Card.CardType cardType : Card.CardType.values()) {
            for (String cardTypeName : cardType.getCardTypes()) {
                for (int value = 2; value <= 14; value++) {
                    String cardName = cardType.getFullNamePrefix() + Card.getValueName(value) + " of " + cardTypeName;
                    cards.add(new Card(value, cardName, cardTypeName));
                }
            }
        }
    }
}