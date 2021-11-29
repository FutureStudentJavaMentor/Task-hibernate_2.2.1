package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User(new Car("BMW 1"), "User0", "Lastname0", "user0@mail.ru"));
        userService.add(new User(new Car("BMW 2"), "User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User(new Car("BMW 3"), "User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User(new Car("BMW 4"), "User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User(new Car("BMW 5"), "User4", "Lastname4", "user4@mail.ru"));
        userService.add(new User(new Car("Mercedes-Benz AMG  C 63"), "Nikita", "Tern", "nik@mail.ru"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("User Car - " + user.getCar());
        }

//        new UserServiceImp().getCarUser(users.get(5).getCar());
        context.close();
    }
}
