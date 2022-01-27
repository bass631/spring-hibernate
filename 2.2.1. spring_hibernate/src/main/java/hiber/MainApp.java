package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        User user1 = new User("Name1", "Lastname1", "name1@mail.com");
        User user2 = new User("Name2", "Lastname2", "name2@mail.com");
        User user3 = new User("Name3", "Lastname3", "name3@mail.com");
        User user4 = new User("Name4", "Lastname4", "name4@mail.com");

        Car car1 = new Car("Car1", 1);
        Car car2 = new Car("Car2", 2);
        Car car3 = new Car("Car3", 3);
        Car car4 = new Car("Car4", 4);

//        car1.setUser(user1);
//        user1.setUserCar(car1);
//        userService.add(user1);

        userService.add(user1.setUserCar(car1).setUser(user1));
        userService.add(user2.setUserCar(car2).setUser(user2));
        userService.add(user3.setUserCar(car3).setUser(user3));
        userService.add(user4.setUserCar(car4).setUser(user4));

        System.out.println(userService.findUserById("car1", 1));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        context.close();
    }
}
