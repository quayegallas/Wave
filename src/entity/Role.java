package entity;

import function.ItemFunction;

public abstract class Role implements ItemFunction {
    private Integer x;
    private Integer y;
    private Item item;

    @Override
    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public Item getItem() {
        return item;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
