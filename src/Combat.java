import java.util.ArrayList;
import java.util.List;

public class Combat {
    private Hero hero;
    private List<Enemy> enemies;
    private int currentEnemyIndex;
    private int currentTurn;
    private int heroMana;
    private static final int MAX_MANA = 5;
    
    public Combat(Hero hero, List<Enemy> enemies) {
        this.hero = hero;
        this.enemies = new ArrayList<>(enemies);
        this.currentEnemyIndex = 0;
        this.currentTurn = 1;
        this.heroMana = MAX_MANA;
    }
    
    public void startCombat() {
        System.out.println("Combat begins!");
        printCombatState();
    }
    
    public void heroTurn() {
        System.out.println("\n=== Hero's Turn ===");
        System.out.println("Mana: " + heroMana + "/" + MAX_MANA);
        // Here we'll handle card playing later
    }
    
    public void enemyTurn() {
        System.out.println("\n=== Enemy's Turn ===");
        Enemy currentEnemy = enemies.get(currentEnemyIndex);
        // Get the next action in sequence
        Enemy.EnemyAction nextAction = currentEnemy.getNextAction();
        System.out.println(currentEnemy.name + " will use: " + nextAction.getDescription());
        nextAction.perform(currentEnemy, hero);
        
        // Move to next enemy or reset index
        currentEnemyIndex = (currentEnemyIndex + 1) % enemies.size();
        if (currentEnemyIndex == 0) {
            currentTurn++;
            heroMana = MAX_MANA; // Restore mana at the start of hero's turn
        }
    }
    
    public void printCombatState() {
        System.out.println("\nTurn " + currentTurn);
        System.out.println(hero.name + " HP: " + hero.currentHealth + "/" + hero.maxHealth);
        for (Enemy enemy : enemies) {
            System.out.println(enemy.name + " HP: " + enemy.currentHealth + "/" + enemy.maxHealth);
        }
    }
    
    public boolean isCombatOver() {
        if (hero.currentHealth <= 0) return true;
        for (Enemy enemy : enemies) {
            if (enemy.currentHealth > 0) return false;
        }
        return true;
    }
} 