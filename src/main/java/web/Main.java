package web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import web.config.AppConfig;
import web.models.User;
import web.services.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        for(int i = 0; i < 5; i++) {
            User user = new User("Name" + i, "Lastname" + i, 1995 + i);
            userService.saveUser(user);
        }
        context.close();
    }
}
