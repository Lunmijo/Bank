package crud_classes.interfaces;

import java.util.HashMap;

public interface CurrentRates {

    HashMap<String, Double> findAllbyDate(String date);
    //нужно ли переопределять equals() & hashCode() ?
}
