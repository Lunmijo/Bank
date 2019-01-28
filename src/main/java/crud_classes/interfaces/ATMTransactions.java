package crud_classes.interfaces;

import entity.ATMTransactionEntity;

import java.util.List;

public interface ATMTransactions {

    void save(ATMTransactionEntity atmTransactionEntity);
    void delete(ATMTransactionEntity atmTransactionEntity);
    ATMTransactionEntity findByID(int id);
    List<ATMTransactionEntity> findAllByBankAccountID(int id);
}
