package srpfacadelab;

public class DamageTaker {
    public DamageTaker() {

    }

    public void  takeDamage(int damage, RpgPlayer player) {
        IGameEngine engine = player.getGameEngine();
        if (damage < player.getArmour()) {
            engine.playSpecialEffect("parry");
        }

        int damageToDeal = damage - player.getArmour();

        if (player.calculateInventoryWeight() < player.getCarryingCapacity()*0.5) {
            damageToDeal *= 0.75;
        }

        player.setHealth( player.getHealth() - damageToDeal );

        engine.playSpecialEffect("lots_of_gore");
    }
}