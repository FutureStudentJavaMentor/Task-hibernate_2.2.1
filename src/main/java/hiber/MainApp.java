package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException{
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User(new Car("Mercedes-Benz"), "User0", "Lastname0", "user0@mail.ru"));
        userService.add(new User(new Car("Mercedes-Benz"), "User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User(new Car("Mercedes-Benz"), "User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User(new Car("Mercedes-Benz"), "User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User(new Car("Mercedes-Benz"), "User4", "Lastname4", "user4@mail.ru"));
        userService.add(new User(new Car("Mercedes-Benz"), "User5", "LastName5", "user5@mail.ru"));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("User Car - " + user.getCar());
        }

        User user = userService.getCarUser("Mercedes-Benz", 1);
        System.out.println(user);
        context.close();
    }
}
