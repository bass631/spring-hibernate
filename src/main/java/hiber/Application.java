package hiber;

import hiber.configuration.DatabaseConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DatabaseConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.addUser(User.builder()
                .firstName("name1")
                .lastName("lastname1")
                .email("email1@email.com")
                .userCar(Car.builder()
                        .model("car1")
                        .series(1)
                        .build())
                .build());

        userService.addUser(User.builder()
                .firstName("name2")
                .lastName("lastname2")
                .email("email2@email.com")
                .userCar(Car.builder()
                        .model("car1")
                        .series(1)
                        .build())
                .build());


        for (User user : userService.findUsersListByModelAndSeriesCar("car1", 1)) {
            log.info(user.toString());
        }

        for (User user : userService.getListUsers()) {
            log.info(user.toString());
        }

        context.close();
    }
}
