package transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import transaction.configuration.SpringConfig;
import transaction.entity.AccountEntity;
import transaction.repository.AccountRepository;
import transaction.service.AccountService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static AccountRepository accountRepository =(AccountRepository) context.getBean("accountRepository");
    public static void main(String[] args) throws Exception {

//        newAccount();
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.transferMoney(1,2,100);


    }
//    private static void newAccount(){
//        AccountEntity account1 = new AccountEntity();
//        account1.setName("owner-1");
//        account1.setBalance(50);
//        account1.setLooked(false);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            account1.setAccessTime(sdf.parse("2019-03-18"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        AccountEntity result = accountRepository.save(account1);
//        if (result != null) {
//            System.out.println("A new account save successfully, book ID = " + account1.getId());
//        }
//
//        AccountEntity account2 = new AccountEntity();
//        account2.setName("owner-2");
//        account2.setBalance(50);
//        account2.setLooked(false);
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            account2.setAccessTime(sdf2.parse("2019-03-18"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        AccountEntity result2 = accountRepository.save(account2);
//        if (result2 != null) {
//            System.out.println("A new account save successfully, book ID = " + account2.getId());
//        }
//    }
}