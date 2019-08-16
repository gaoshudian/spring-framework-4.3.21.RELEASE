package my_demo.event;

import org.springframework.context.ApplicationEvent;

public class MsgEvent extends ApplicationEvent {

    private String text;

    public MsgEvent(Object source) {
        super(source);
    }

    public MsgEvent(Object source, String text) {
        super(source);
        this.text = text;
    }

    public void print(){
        System.out.println("print even content:" + this.text);
    }
}
