package my_demo.event;

import org.springframework.context.ApplicationListener;

public class PrintListener implements ApplicationListener<MsgEvent> {

    @Override
    public void onApplicationEvent(MsgEvent event) {
        System.out.print("调用MsgEvent的print方法输出其内容:");
        event.print();
    }
}