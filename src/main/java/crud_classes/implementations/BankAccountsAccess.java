package crud_classes.implementations;

import entity.BankAccountEntity;
import executors.BankAccountsQueryExecutor;
import executors.GeneralQueryExecutor;

import java.util.List;

public class BankAccountsAccess implements crud_classes.interfaces.BankAccounts {

    public BankAccountEntity findByID(int id) {
        String select = "select * from \"Bank_Accounts\" where \"ID\"=" + id;
        return BankAccountsQueryExecutor.getBankAccountByQuery(select);
    }

    public BankAccountEntity findByUserID(int id) {
        String select = "select * from \"Bank_Accounts\" where \"UserID\"=" + id;
        return BankAccountsQueryExecutor.getBankAccountByQuery(select);
    }

    public void save(BankAccountEntity bankAccount) {
        String insert = "insert into \"Bank_Accounts\"(\"ID\", \"UserID\", \"Currency\", \"AvaliableMoney\") values (" +
                bankAccount.getID() + ", " +
                "\'" + bankAccount.getUserID() + "\'" + ", " +
                "\'" + bankAccount.getCurrency() + "\'" + ", " +
                bankAccount.getAvaliableMoney() + ")";
        GeneralQueryExecutor.executeQueryWithoutResult(insert);
    }

    public void update(BankAccountEntity bankAccount) {
        String update = "update \"Bank_Accounts\" set \"AvaliableMoney\"=" + bankAccount.getAvaliableMoney();
        GeneralQueryExecutor.executeQueryWithoutResult(update);
    }

    public void delete(BankAccountEntity bankAccount) {
        String delete = "delete from \"Bank_Accounts\" where \"UserID\"= " + (Integer)bankAccount.getUserID();
        GeneralQueryExecutor.executeQueryWithoutResult(delete);
    }

    public List<BankAccountEntity> findAllByUserID(int id) {
        String select = "select * from \"Bank_Accounts\" where \"UserID\"=" + id;
        return BankAccountsQueryExecutor.getBankAccountsByQuery(select);
    }

}
