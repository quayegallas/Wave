package custom.cell;

import entity.Cell;
import entity.Item;
import function.ItemFunction;


public class ItemCell extends Cell implements ItemFunction {

    private Item item;

    public ItemCell(Integer x, Integer y,Item item) {
        this.setX(x);
        this.setY(y);
        this.setItem(item);
        this.setContent("地上仿佛有一个闪亮的物品");
    }

    @Override
    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public Item getItem() {
        return item;
    }
}
