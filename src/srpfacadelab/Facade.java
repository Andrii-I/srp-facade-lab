package srpfacadelab;

public class Facade {

    ItemUser itemUser;
    ItemPickuper itemPickuper;
    DamageTaker damageTaker;

    public Facade () {
        this.itemUser = new ItemUser();
        this.itemPickuper = new ItemPickuper();
        this.damageTaker = new DamageTaker();
    }

    public void useItem(Item item, RpgPlayer player) { 
        itemUser.useItem(item, player);
    }

    public boolean pickupItem(Item item, RpgPlayer player) {
        return itemPickuper.pickupItem(item, player);
    }
    
    public void takeDamage(int damage, RpgPlayer player) {
        damageTaker.takeDamage(damage, player);
    }
}