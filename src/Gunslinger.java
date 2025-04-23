public class Gunslinger extends Hero {
    public Gunslinger() {
        super("Gunslinger", 18);
        this.deck = GunslingerCards.getStarterDeck();
    }
    
    // Method to add a new card to the deck
    public void addCardToDeck(String cardName) {
        Card card = GunslingerCards.getCardByName(cardName);
        if (card != null) {
            deck.add(card);
        }
    }
    
    // Add Gunslinger-specific methods here later
    // For example: special abilities, animations, etc.
} 