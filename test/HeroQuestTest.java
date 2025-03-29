import option2.HeroQuest;
import option2.Item;
import option2.Player;
import option2.QuestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroQuestTest {

    private HeroQuest heroQuest;
    private Item item;
    private Player player;


    @BeforeEach
    void SetUp() {
        item = new Item();
        player = new Player();
        heroQuest = new HeroQuest(player, item);
        heroQuest.getPlayer().setPlayerName("Conan");
        heroQuest.getPlayer().setPlayerHealth(100);
        heroQuest.getPlayer().setPlayerStrength(20);
        heroQuest.getPlayer().setPlayerMagic(10);
        heroQuest.getPlayer().setPlayerCraftingSkill(10);
    }

    @BeforeEach
    void SetUpSecond() {
        heroQuest.getItem().setItemName("Amulet of Strength");
        heroQuest.getItem().setItemKind("Strength");
        heroQuest.getItem().setItemPower(10);
    }

    @Test
    void playerToString() {
        var result = heroQuest.playerToString();

        var expected = "Conan's Attributes:\nHealth: 100\nStrength: 20\nMagic: " +
                "10\nCrafting " +
                "Skill: 10\n";

        assertEquals(expected, result);
    }


    @Test
    void playerFallsDown() {
        heroQuest.getPlayer().setPlayerStrength(3);
        heroQuest.playerFallsDown();
        assertEquals(90, heroQuest.getPlayer().getPlayerHealth());
    }


    @Test
    void playerFallsDownNoDamage() {
        heroQuest.playerFallsDown();
        assertEquals(100, heroQuest.getPlayer().getPlayerHealth());
    }


    @Test
    void itemToString() {
        var result = heroQuest.itemToString();
        var expected = "Item: Amulet of Strength\nKind: Strength\nPower: 10\n";
        assertEquals(expected, result);
    }

    @Test
    void itemReduceByUsage() {
        heroQuest.itemReduceByUsage();
        assertEquals(5, heroQuest.getItem().getItemPower());
    }


    @Test
    void itemReduceByUsageToJunk() {
        heroQuest.getItem().setItemPower(1);
        heroQuest.itemReduceByUsage();
        assertEquals(0, heroQuest.getItem().getItemPower());
        assertEquals("Junk", heroQuest.getItem().getItemKind());
    }


    @Test
    void itemApplyEffectToPlayer() {
        heroQuest.itemApplyEffectToPlayer();
        assertEquals(30, heroQuest.getPlayer().getPlayerStrength());
    }

    @Test
    void itemApplyEffectToPlayerJunk() {
        heroQuest.getItem().setItemKind("Junk");
        heroQuest.itemApplyEffectToPlayer();
        assertEquals(20, heroQuest.getPlayer().getPlayerStrength());
    }


    @Test
    void itemRepair() {
        heroQuest.itemRepair();
        assertEquals(26, heroQuest.getItem().getItemPower());
    }
}
