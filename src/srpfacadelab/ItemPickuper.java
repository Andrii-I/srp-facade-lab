
package srpfacadelab;
public class ItemPickuper {

    public ItemPickuper() {

    }

    public boolean pickupItem(Item item, RpgPlayer player) {
        IGameEngine engine = player.getGameEngine();
        int weight = player.calculateInventoryWeight();
        if (weight + item.getWeight() > player.getCarryingCapacity()) 
            return false;

        if (item.isUnique() && player.checkIfItemExistsInInventory(item))
            return false;
        
        if (item.isUnique() && item.isRare()) {
            engine.playSpecialEffect("blue_swirly");
        }
        
        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth( player.getHealth() + item.getHeal() );

            if (player.getHealth() > player.getMaxHealth())
                player.setHealth(player.getMaxHealth());

            if (item.getHeal() > 500) {
                engine.playSpecialEffect("green_swirly");
            }

            return true;
        }

        if (item.isRare())
            engine.playSpecialEffect("cool_swirly_particles");

        player.addToInventory(item);

        player.calculateStats();

        return true;
    }
}