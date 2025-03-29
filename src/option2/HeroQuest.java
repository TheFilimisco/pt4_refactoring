package option2;

import java.util.Objects;

public class HeroQuest {
    final private Player player;
    final private Item item;
    final private int TOP_MAX_STRENGTH_BY_DROP = 5;
    final private int HEALTH_DECREASES_BY_DROP = 10;
    final private int REPAIR_AMOUNT = 4;

    public HeroQuest(Player player, Item item) {
        this.player = player;
        this.item = item;
    }

    public Player getPlayer() {
        return player;
    }

    public Item getItem() {
        return item;
    }

    public String playerToString() {
        return String.format("%s's Attributes:\nHealth: %d\nStrength: %d\nMagic: %d\nCrafting Skill: %d\n",
                player.getPlayerName(), player.getPlayerHealth(), player.getPlayerStrength(), player.getPlayerMagic(), player.getPlayerCraftingSkill());
    }

    public void playerFallsDown() {
        System.out.println("Player drops off a cliff.");
        if (player.getPlayerStrength() < TOP_MAX_STRENGTH_BY_DROP) {
            player.setPlayerHealth(player.getPlayerHealth() - HEALTH_DECREASES_BY_DROP);
            System.out.println("Player's strength is too small. Health decreases by 10.");
        }
    }

    public String itemToString() {
        return String.format("Item: %s\nKind: %s\nPower: %d\n", item.getItemName(), item.getItemKind(), item.getItemPower());
    }

    public void itemReduceByUsage() {
        System.out.println(String.format("Using the item with kind '%s' and power %d", item.getItemKind(), item.getItemPower()));

        item.setItemPower(item.getItemPower() / 2);

        if (item.getItemPower() == 0) {
            item.setItemKind("Junk");
        }

    }

    public void itemApplyEffectToPlayer() {
        System.out.printf("Applying the effect of %s (%s):%n", item.getItemName(), item.getItemKind());
        switch (item.getItemKind()){
            case "Health":
                player.setPlayerHealth(player.getPlayerHealth() + item.getItemPower());
                break;
            case "Strength":
                player.setPlayerStrength(player.getPlayerStrength() + item.getItemPower());
                break;
            case "Magic":
                player.setPlayerMagic(player.getPlayerMagic() + item.getItemPower());
                break;
            default:
                // ignore unknown item kind
                break;
        }
    }

    public void itemRepair() {
        System.out.println("Using the repair skill to fix the item:");
        int repairAmount = getRepairAmount();
        item.setItemPower(item.getItemPower() + repairAmount);
        System.out.println(String.format("Repaired the item by %d points. Item's Durability: %d", repairAmount, item.getItemPower()));
    }

    private int getRepairAmount() {
        return ((player.getPlayerCraftingSkill() * 2) - REPAIR_AMOUNT);
    }


}