package crud_classes.implementations;

import crud_classes.interfaces.ATMTransactions;
import entity.ATMTransactionEntity;
import executors.ATMTransactionsQueryExecutor;
import executors.GeneralQueryExecutor;

import java.util.List;

public class ATMTransactionsAccess implements ATMTransactions {

    public void save(ATMTransactionEntity atmTransactionEntity) {
        String insert = "insert into \"Bank_Accounts\"(\"ID\", \"BankAccountID\", \"Sum\") values (" +
                atmTransactionEntity.getID() + ", " +
                "\'" + atmTransactionEntity.getBankAccountID() + "\'" + ", " +
                atmTransactionEntity.getSum() + ")";
        GeneralQueryExecutor.executeQueryWithoutResult(insert);
    }

    public void delete(ATMTransactionEntity atmTransactionEntity) {
        String delete = "delete from \"ATM_Transactions\" where \"ID\"= " + (Integer)atmTransactionEntity.getID();
        GeneralQueryExecutor.executeQueryWithoutResult(delete);
    }

    //Transactions cannot be updated

    public ATMTransactionEntity findByID(int id) {
        return null;
    }

    public List<ATMTransactionEntity> findAllByBankAccountID(int id) {
        String select = "select * from \"Bank_Accounts\" where \"BankAccountID\"=" + id;
        return ATMTransactionsQueryExecutor.getTransactionsByQuery(select);
    }
}
