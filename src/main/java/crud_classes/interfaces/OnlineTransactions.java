package crud_classes.interfaces;

import entity.OnlineTransactionEntity;

import java.util.List;

public interface OnlineTransactions {

    OnlineTransactionEntity findByID(int id);

    List<OnlineTransactionEntity> findAllByCurrency(String currency);
    List<OnlineTransactionEntity> findAllByFromAccountID(int id);
    List<OnlineTransactionEntity> findAllByToAccountID(int id);
    List<OnlineTransactionEntity> findAllByCurrencyRateDay(String date);

    void save(OnlineTransactionEntity onlineTransaction);
    void delete(OnlineTransactionEntity onlineTransaction);
}
