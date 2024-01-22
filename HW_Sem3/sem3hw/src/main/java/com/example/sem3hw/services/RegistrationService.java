package com.example.sem3hw.services;

import com.example.sem3hw.domain.User;
import com.example.sem3hw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    //region Поля
    private DataProcessingService dataProcessingService;
    private UserService userService;
    private NotificationService notificationService;
    //endregion

    //Разработать метод processRegistration в котором:
    public void processRegistration(User user) {
        //- создается пользователь из параметров метода(Не понял в чем задумка, но воспользовался нашим готовым методом)
        User userFromBody = userService.createUser(user);
        //- созданный пользователь добавляется в репозиторий
        dataProcessingService.addUserToList(userFromBody);
        //- через notificationService выводится сообщение в консоль
        notificationService.sendNotification("Пользователь" + userFromBody.getName() + " был успешно создан!");
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
