package com.example.sem2ex3.service;

import com.example.sem2ex3.model.User;
import com.example.sem2ex3.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /**
     * Поиск всех пользователей в базе
     * @return Список пользователей
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }
    /**
     * Сохранение нового пользователя в базу
     * @param user новый пользователь
     * @return
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    /**
     * Удаление пользователя по айди
     * @param id айди необходимого пользователя
     */
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
    /**
     * Поиск пользователя по айди
     * @param id айди необходимого пользователя
     * @return
     */
    public User getOne(int id) {
        return userRepository.getOne(id);
    }
    /**
     * Обновление пользователя
     * @param user новый пользователь
     * @return
     */
    public User updateUser(User user) {
        return userRepository.updateById(user);
    }


}
