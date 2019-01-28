package crud_classes.interfaces;

import entity.BankAccountEntity;

import java.util.List;

public interface BankAccounts {

    BankAccountEntity findByID(int id);
    BankAccountEntity findByUserID(int id);

    void save(BankAccountEntity bankAccount);
    void update(BankAccountEntity bankAccount);
    void delete(BankAccountEntity bankAccount);

    List<BankAccountEntity> findAllByUserID(int id);
}
