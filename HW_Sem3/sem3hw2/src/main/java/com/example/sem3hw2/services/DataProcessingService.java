package com.example.sem3hw2.services;

import com.example.sem3hw2.domain.User;
import com.example.sem3hw2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    //region Поля
    @Autowired
    private UserRepository repository;
    //endregion

    /**
     * Сортировка юзеров по возрасту
      * @param users список юзеров
     * @return отсортированный список юзеров
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Фмльтрация юзеров по возрасту(старше необходимого возраста)
     * @param users Список юзеров
     * @param age Возраст выше которого нужно отфильтровать
     * @return Список юзеров старше необходимого возраста
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Средний возраст всех юзеров
     * @param users список юзеров
     * @return средний возраст
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }


    /**
     * Получение списка юзеров
     * @return список юзеров
     */
    public List<User> getListOfUsers(){
        return repository.getAll();
    }

    /**
     * Добавление нового юзера
     * @param user новый юзер
     */
    public void  addUserToList(User user)
    {
        repository.addUser(user);
    }
}
