public class Card {
    public String name;
    public String description;
    public int energyCost;
    public CardEffect effect;

    public Card(String name, String description, int energyCost, CardEffect effect) {
        this.name = name;
        this.description = description;
        this.energyCost = energyCost;
        this.effect = effect;
    }

    // This interface will define what a card effect can do
    public interface CardEffect {
        void apply(Hero hero, Object target); // target will be Enemy when we create it
    }
} 