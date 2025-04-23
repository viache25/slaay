import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnemyData {
    // Store all enemy configurations
    private static final Map<String, EnemyConfig> enemyConfigs = new HashMap<>();
    
    static {
        // Initialize enemy configurations
        EnemyConfig banditConfig = new EnemyConfig("Bandit", 30);
        banditConfig.addAction("Slash", (enemy, target) -> {
            target.currentHealth -= 8;
            System.out.println("Bandit slashes for 8 damage!");
        });
        banditConfig.addAction("Steal Health", (enemy, target) -> {
            target.currentHealth -= 5;
            enemy.currentHealth += 5;
            System.out.println("Bandit steals 5 health!");
        });
        enemyConfigs.put("Bandit", banditConfig);
        
        // Add more enemy configurations here...
    }
    
    public static Enemy createEnemy(String enemyName) {
        EnemyConfig config = enemyConfigs.get(enemyName);
        if (config == null) {
            throw new IllegalArgumentException("Enemy " + enemyName + " not found!");
        }
        return new Enemy(config.name, config.maxHealth, config.actions);
    }
    
    // Configuration class for enemies
    private static class EnemyConfig {
        String name;
        int maxHealth;
        List<Enemy.EnemyAction> actions;
        
        EnemyConfig(String name, int maxHealth) {
            this.name = name;
            this.maxHealth = maxHealth;
            this.actions = new ArrayList<>();
        }
        
        void addAction(String description, EnemyActionExecutor executor) {
            actions.add(new Enemy.EnemyAction() {
                @Override
                public void perform(Enemy enemy, Hero target) {
                    executor.execute(enemy, target);
                }
                
                @Override
                public String getDescription() {
                    return description;
                }
            });
        }
    }
    
    // Functional interface for enemy actions
    @FunctionalInterface
    private interface EnemyActionExecutor {
        void execute(Enemy enemy, Hero target);
    }
} 