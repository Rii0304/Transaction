package transaction.service;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import transaction.entity.AccountEntity;
import transaction.repository.AccountRepository;

import javax.transaction.Transactional;

@Service
public class AccountService {
//    @Autowired
//    private AccountRepository accountRepository;
//    private JpaTransactionManager transactionManager;
//    public AccountService(JpaTransactionManager transactionManager){
//        this.transactionManager = transactionManager;
//    }
//    public void transferMoney(int sourceAccountId, int targetAccounId, double amount){
//        TransactionDefinition definition = new DefaultTransactionDefinition();
//        TransactionStatus status = transactionManager.getTransaction(definition);
//        try{
//            AccountEntity sourceAccount = accountRepository.findById(sourceAccountId).get();
//            AccountEntity targetAccount = accountRepository.findById(targetAccounId).get();
//            sourceAccount.setBalance(sourceAccount.getBalance()-amount);
//            accountRepository.save(sourceAccount);
//            if (sourceAccount.getBalance()<0){
//                throw new Exception("amount to transfer more than balance");
//            }
//            targetAccount.setBalance(targetAccount.getBalance()+amount);
//            accountRepository.save(targetAccount);
//            transactionManager.commit(status);
//        } catch (Exception exception) {
//            transactionManager.rollback(status);
//            throw new RuntimeException(exception);
//        }
//    }

//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Transactional
//    public void transferMoney(int sourceAccountId, int targetAccounId, double amount){
//        AccountEntity sourceAccount = accountRepository.findById(sourceAccountId).get();
//        AccountEntity targetAccount = accountRepository.findById(targetAccounId).get();
//        sourceAccount.setBalance(sourceAccount.getBalance()-amount);
//        accountRepository.save(sourceAccount);
//        targetAccount.setBalance(targetAccount.getBalance()+amount);
//        accountRepository.save(targetAccount);
//    }

    @Autowired
    private AccountRepository accountRepository;

    @Transactional(rollbackOn = Exception.class)
    public void transferMoney(int sourceAccountId, int targetAccounId, double amount) throws Exception {
        AccountEntity sourceAccount = accountRepository.findById(sourceAccountId).get();
        AccountEntity targetAccount = accountRepository.findById(targetAccounId).get();
        sourceAccount.setBalance(sourceAccount.getBalance()-amount);
        accountRepository.save(sourceAccount);
        if (sourceAccount.getBalance()<0){
            throw new Exception("amount to transfer more than balance");
        }
        targetAccount.setBalance(targetAccount.getBalance()+amount);
        accountRepository.save(targetAccount);
    }
}
