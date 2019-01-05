package custom.event;

import entity.Event;

public class GameOverEvent extends Event {
    public GameOverEvent(){
        this.setTitle("游戏结束");
        this.setContent("GameOver");
        this.setEnd("退出");
        this.setLevel(10);
    }
}
