import java.util.ArrayList;
import java.util.List;

public class GunslingerCards {
    // Store all possible cards that can be obtained
    private static final List<Card> cardPool = new ArrayList<>();
    
    static {
        // Initialize all possible cards
        cardPool.add(new Card("Quick Shot", "Deal 6 damage", 1, (hero, target) -> {
            System.out.println("Dealt 6 damage!");
        }));
        
        cardPool.add(new Card("Reload", "Draw 2 cards", 1, (hero, target) -> {
            System.out.println("Drew 2 cards!");
        }));
        
        cardPool.add(new Card("Fan the Hammer", "Deal 3 damage 3 times", 2, (hero, target) -> {
            System.out.println("Dealt 3 damage 3 times!");
        }));
        
        // Add more cards to the pool...
    }
    
    // Get the starter deck (subset of cards)
    public static List<Card> getStarterDeck() {
        List<Card> starterDeck = new ArrayList<>();
        // Add specific cards to starter deck
        starterDeck.add(getCardByName("Quick Shot"));
        starterDeck.add(getCardByName("Reload"));
        return starterDeck;
    }
    
    // Get a specific card by name
    public static Card getCardByName(String name) {
        for (Card card : cardPool) {
            if (card.name.equals(name)) {
                return card;
            }
        }
        return null;
    }
    
    // Get all available cards
    public static List<Card> getCardPool() {
        return new ArrayList<>(cardPool); // Return a copy to prevent modification
    }
} 