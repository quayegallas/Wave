package entity;

import custom.event.GameOverEvent;

public abstract class Cell {
    private Integer x;
	private Integer y;// 1234556
    private String content;
    private Event event;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        if(event instanceof GameOverEvent){
            this.setContent("前方到达了出口,");
        }
    }
}
