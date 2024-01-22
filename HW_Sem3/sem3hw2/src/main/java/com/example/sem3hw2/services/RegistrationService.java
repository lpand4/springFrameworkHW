package com.example.sem3hw2.services;

import com.example.sem3hw2.domain.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    //region Поля
    private DataProcessingService dataProcessingService;
    private UserService userService;
    private NotificationService notificationService;
    //endregion


    /**
     * Регистрация нового юзера
     * @param name имя
     * @param age возраст
     * @param email почта
     */
    public void processRegistration(String name, int age, String email){
        processRegistration(userService.createUser(name, age, email));
    }
    //Разработать метод processRegistration в котором:

    /**
     * Регистрация нового юзера
     * @param user новый юзер
     */
    public void processRegistration(User user) {
        //- создается пользователь из параметров метода(Не понял в чем задумка, но воспользовался нашим готовым методом)
        User userFromBody = userService.createUser(user);
        //- созданный пользователь добавляется в репозиторий
        dataProcessingService.addUserToList(userFromBody);
        //- через notificationService выводится сообщение в консоль
        notificationService.sendNotification("Пользователь " + userFromBody.getName() + " был успешно создан!");
    }

    //region Вспомогательные методы
    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public UserService getUserService() {
        return userService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }
    //endregion

}
