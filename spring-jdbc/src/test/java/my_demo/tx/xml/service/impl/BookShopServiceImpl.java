package my_demo.tx.xml.service.impl;


import my_demo.tx.xml.BookShopDao;
import my_demo.tx.xml.service.BookShopService;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDao;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    @Override
    public void purchase(String username, String isbn) {

        //1. 获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        //2. 更新数的库存
        bookShopDao.updateBookStock(isbn);

        //3. 更新用户余额
        bookShopDao.updateUserAccount(username, price);

        /**
         * 添加事务同步回调接口，这样在事务执行的各个阶段，spring会控制回调对应的方法
         */
        TransactionSynchronizationManager.registerSynchronization(
                new TransactionSynchronizationAdapter() {
                    @Override
                    public void beforeCompletion() {
                        System.out.println("beforeCompletion========");
                    }
                    @Override
                    public void afterCompletion(int status) {
                        System.out.println("afterCompletion========");
                    }
                    @Override
                    public void beforeCommit(boolean readOnly) {
                        System.out.println("beforeCommit========");
                    }
                    @Override
                    public void afterCommit() {
                        System.out.println("afterCommit========");
                    }
                }
        );

    }
}