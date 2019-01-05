package custom.event;

import entity.Event;

public class OrdinaryEvent extends Event {

    public OrdinaryEvent(String content) {
        this.setTitle("游戏继续");
        this.setContent(","+content);
        this.setEnd("继续");
        this.setLevel(1);
    }

    public OrdinaryEvent() {
        this.setTitle("游戏继续");
        this.setContent("");
        this.setEnd("继续");
        this.setLevel(1);
    }
}
