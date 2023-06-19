package cardgame;

import java.util.Random;

public class Card {
    private int value;
    private String name;
    private String cardType;

    public Card(int value, String name, String cardType) {
        this.value = value;
        this.name = name;
        this.cardType = cardType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void describe() {
        System.out.println("Card: " + name);
        System.out.println("Value: " + value);
        System.out.println("Card Type: " + cardType);
    }

    public enum CardType {
    	TWO(2, "Two", "Two of ", new String[]{"Clubs", "Hearts", "Spades", "Diamonds"}),
        THREE(3, "Three", "Three of ", new String[]{"Clubs", "Hearts", "Spades", "Diamonds"}),
        FOUR(4, "Four", "Four of ", new String[]{"Clubs", "Hearts", "Spades", "Diamonds"}),
        FIVE(5, "Five", "Five of ", new String[]{"Clubs", "Hearts", "Spades", "Diamonds"}),
        SIX(6, "Six", "Six of ", new String[]{"Clubs", "Hearts", "Spades", "Diamonds"}),
        SEVEN(7, "Seven", "Seven of ", new String[]{"Clubs", "Hearts", "Spades", "Diamonds"}),
        EIGHT(8, "Eight", "Eight of ", new String[]{"Clubs", "Hearts", "Spades", "Diamonds"}),
        NINE(9, "Nine", "Nine of ", new String[]{"Clubs", "Hearts", "Spades", "Diamonds"}),
        TEN(10, "Ten", "Ten of ", new String[]{"Clubs", "Hearts", "Spades", "Diamonds"}),
        JACK(11, "Jack", "Jack of ", new String[]{"Clubs", "Hearts", "Spades", "Diamonds"}),
        QUEEN(12, "Queen", "Queen of ", new String[]{"Clubs", "Hearts", "Spades", "Diamonds"}),
        KING(13, "King", "King of ", new String[]{"Clubs", "Hearts", "Spades", "Diamonds"}),
        ACE(14, "Ace", "Ace of ", new String[]{"Clubs", "Hearts", "Spades", "Diamonds"});
    	

        private final int value;
        private final String name;
        private final String fullNamePrefix;
        private final String[] cardTypes;

        CardType(int value, String name, String fullNamePrefix, String[] cardTypes) {
            this.value = value;
            this.name = name;
            this.fullNamePrefix = fullNamePrefix;
            this.cardTypes = cardTypes;
        }

        public int getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

        public String getFullName() {
            return fullNamePrefix + name;
        }

        public String getFullNamePrefix() {
            return fullNamePrefix;
        }

        public String[] getCardTypes() {
            return cardTypes;
        }
    }

        public static String getValueName(int value) {
            if (value >= 2 && value <= 10) {
                return String.valueOf(value);
            } else if (value == 11) {
                return "Jack";
            } else if (value == 12) {
                return "Queen";
            } else if (value == 13) {
                return "King";
            } else if (value == 14) {
                return "Ace";
            } else {
                throw new IllegalArgumentException("Invalid card value: " + value);
            }
        }
    


    public static void main(String[] args) {
        String[] cardTypes = {"Clubs", "Hearts", "Spades", "Diamonds"};

        Random random = new Random();
        String randomCardType = cardTypes[random.nextInt(cardTypes.length)];

        Card card = new Card(10, "Ten", randomCardType);
        card.describe();
    }
}