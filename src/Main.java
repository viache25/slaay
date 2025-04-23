import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create hero
        Gunslinger gunslinger = new Gunslinger();
        
        // Create enemies
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(EnemyData.createEnemy("Bandit"));
        
        // Start combat
        Combat combat = new Combat(gunslinger, enemies);
        combat.startCombat();
        
        // Simulate a few turns
        while (!combat.isCombatOver()) {
            combat.heroTurn();
            combat.enemyTurn();
            combat.printCombatState();
        }
    }
}