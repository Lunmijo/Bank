package crud_classes.interfaces;

import db_entity.db_objects_i.OnlineTransaction;

import java.util.List;

public interface OnlineTransactions {

    OnlineTransaction findByID(int id);
    OnlineTransaction findByFromAccountID(int id);
    OnlineTransaction findByToAccountID(int id);

    List<OnlineTransaction> findAllByCurrency(String currency);
    List<OnlineTransaction> findAllByFromAccountID(int id);
    List<OnlineTransaction> findAllByToAccountID(int id);
    List<OnlineTransaction> findAllByCurrencyRateDay(String date);

    void save(OnlineTransaction onlineTransaction);
    void update(OnlineTransaction onlineTransaction);
    void delete(OnlineTransaction onlineTransaction);
}
