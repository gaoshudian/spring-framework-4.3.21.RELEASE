package my_demo.tx.xml;

import my_demo.tx.xml.service.BookShopService;
import my_demo.tx.xml.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Arrays;


public class SpringTransactionTest {

    private ApplicationContext ctx;
    private BookShopService bookShopService;
    private Cashier cashier;

    {
        ctx = new ClassPathXmlApplicationContext("my-demo/spring-tx-xml.xml");
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }

    /**
     * 嵌套事务测试
     */
    @Test
    public void testTransactionlPropagation() {
        cashier.checkout("AA", Arrays.asList("1001", "1002"));
    }

    /**
     * 单层事务测试
     */
    @Test
    public void testBookShopService() {
        bookShopService.purchase("AA", "1001");
    }

}
