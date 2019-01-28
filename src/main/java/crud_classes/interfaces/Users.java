package crud_classes.interfaces;

import entity.UserEntity;

import java.util.List;

public interface Users {
    UserEntity findByID(int id);
    UserEntity findByBankAccountID(int id);

    void save(UserEntity user);
    void delete(UserEntity user);
    void update(UserEntity user);


    List<UserEntity> findAllUsers();
    List<UserEntity> findAllUsersByLastName(String lastName);
}
