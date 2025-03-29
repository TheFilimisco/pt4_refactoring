package option2;

public class Item {
    private String itemName;
    private String itemKind;
    private int itemPower;

    public Item() {
    }

    public Item(String itemName, String itemKind, int itemPower) {
        this.itemName = itemName;
        this.itemKind = itemKind;
        this.itemPower = itemPower;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemKind() {
        return itemKind;
    }

    public void setItemKind(String itemKind) {
        this.itemKind = itemKind;
    }

    public int getItemPower() {
        return itemPower;
    }

    public void setItemPower(int itemPower) {
        this.itemPower = itemPower;
    }
}
