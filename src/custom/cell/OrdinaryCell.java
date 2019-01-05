package custom.cell;

import entity.Cell;
import entity.Event;

public class OrdinaryCell extends Cell {
    public OrdinaryCell(Integer x,Integer y){
        this.setX(x);
        this.setY(y);
        this.setContent("这似乎是一个普通的房间");
    }
    public OrdinaryCell(Integer x, Integer y, Event event){
        this.setX(x);
        this.setY(y);
        this.setContent("这似乎是一个普通的房间");
        this.setEvent(event);
    }
}
