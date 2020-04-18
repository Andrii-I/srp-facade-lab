package srpfacadelab;
public class ItemPickuper {

    public ItemPickuper() {

    }

    public void pickupItem(Item item, RpgPlayer player, IGameEngine engine) {
        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth( player.getHealth() + item.getHeal());

            if (player.getHealth() > player.getMaxHealth())
                player.setHealth( player.getMaxHealth() );

            if (item.getHeal() > 500) {
                engine.playSpecialEffect("green_swirly");
            }

            if (item.isUnique() && item.isRare()) {
                engine.playSpecialEffect("blue_swirly");
            }
        }
    }
}