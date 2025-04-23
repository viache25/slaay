import java.util.ArrayList;
import java.util.List;


public class Enemy {
    public String name;
    public int maxHealth;
    public int currentHealth;
    public List<EnemyAction> actions;
    private int currentActionIndex;


    public Enemy(String name, int maxHealth, List<EnemyAction> actions) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.actions = new ArrayList<>(actions);
        this.currentActionIndex = 0;
    }

    // Interface for enemy actions
    public interface EnemyAction {
        void perform(Enemy enemy, Hero target);
        String getDescription();
    }

    // Get the next action in sequence
    public EnemyAction getNextAction() {
        EnemyAction action = actions.get(currentActionIndex);
        currentActionIndex = (currentActionIndex + 1) % actions.size();
        return action;
    }
} 