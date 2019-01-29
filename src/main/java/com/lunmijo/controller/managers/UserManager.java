package com.lunmijo.controller.managers;

import com.lunmijo.model.entity.BankAccountEntity;
import com.lunmijo.model.entity.UserEntity;
import com.lunmijo.model.repositories.UsersRepository;

public class UserManager {

    public void addUser(String firstName, String lastName) {
        UserEntity user = new UserEntity(firstName, lastName);
        UsersRepository.save(user);
        BankAccountEntity bankAccountEntity = new BankAccountEntity(user.getID(), "UAH", 2000);
        UsersRepository.addBankAccount(user.getID(), bankAccountEntity);
    }
    //TODO: добавить остальные операции
}
