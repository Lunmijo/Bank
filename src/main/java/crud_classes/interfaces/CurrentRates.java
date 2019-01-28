package crud_classes.interfaces;

import entity.CurrentRateEntity;

import java.util.List;

public interface CurrentRates {

    void saveRate(CurrentRateEntity currentRateEntity);
    void updateRate(CurrentRateEntity currentRateEntity);
    void deleteRate(CurrentRateEntity currentRateEntity);
    List<CurrentRateEntity> findAllByDate(String date);
    //нужно ли переопределять equals() & hashCode() ?
}
