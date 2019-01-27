package crud_classes.interfaces;

import db_entity.db_objects_i.BankAccount;

import java.util.List;

public interface BankAccounts {

    BankAccount findByID(int id);
    BankAccount findByUserID(int id);

    void save(BankAccount bankAccount);
    void update(BankAccount bankAccount);
    void delete(BankAccount bankAccount);

    List<BankAccount> findAllByUserID(int id);
}
