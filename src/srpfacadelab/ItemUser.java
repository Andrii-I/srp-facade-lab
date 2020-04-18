package srpfacadelab;

import java.util.List;

public class ItemUser {

    public ItemUser() {

    }

    public void useItem(Item item, RpgPlayer player, IGameEngine engine) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = engine.getEnemiesNear(player);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }
}