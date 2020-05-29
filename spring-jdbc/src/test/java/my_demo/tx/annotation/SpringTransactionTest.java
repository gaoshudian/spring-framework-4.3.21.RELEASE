package my_demo.tx.annotation;

import my_demo.tx.annotation.dao.BookShopDao;
import my_demo.tx.annotation.service.BookShopService;
import my_demo.tx.annotation.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringTransactionTest {

	private ApplicationContext ctx;
	private BookShopDao bookShopDao;
	private BookShopService bookShopService;
	private Cashier cashier;
	
	{
		ctx = new ClassPathXmlApplicationContext("my-demo/spring-tx-annotation.xml");
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}

	//普通事务
	@Test
	public void testBookShopService(){
		bookShopService.purchase("AA", "1001");
	}

	//嵌套事务
	@Test
	public void testTransactionlPropagation(){
		cashier.checkout("AA", Arrays.asList("1001", "1002"));
	}

	@Test
	public void testBookShopDaoUpdateUserAccount(){
		bookShopDao.updateUserAccount("AA", 200);
	}
	
	@Test
	public void testBookShopDaoUpdateBookStock(){
		bookShopDao.updateBookStock("1001");
	}
	
	@Test
	public void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}

}
