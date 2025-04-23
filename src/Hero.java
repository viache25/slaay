import java.util.ArrayList;
import java.util.List;

public class Hero {
    public String name;
    public int maxHealth;
    public int currentHealth;
    public List<Card> deck;

    public Hero(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.deck = new ArrayList<>();
    }
    
}
