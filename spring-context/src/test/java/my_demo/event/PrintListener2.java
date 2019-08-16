package my_demo.event;

import org.springframework.context.ApplicationListener;

public class PrintListener2 implements ApplicationListener<MsgEvent> {

    @Override
    public void onApplicationEvent(MsgEvent event) {
        System.out.println("监听器2...");
    }
}