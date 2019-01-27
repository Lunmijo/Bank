package crud_classes.interfaces;

import db_entity.db_objects_i.User;

import java.util.List;

public interface Users {
    User findByID(int id);
    User findByBankAccountID(int id);

    void save(User user);
    void delete(User user);
    void update(User user);


    List<User> getAllUsersByID(int id);
    List<User> getAllUsersByLastName(String lastName);
}
