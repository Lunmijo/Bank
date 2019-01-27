package crud_classes.interfaces;

import db_entity.db_objects_i.ATMTransaction;

public interface ATMTransactions {

    ATMTransaction findByID(int id);
    ATMTransaction findByBankAccountID(int id);
}
