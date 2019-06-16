package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.DefaultLifecycleProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the Number game");

        //create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get NumberGenerator bean from context (container)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // call method next to get random number
        int number = numberGenerator.next();

        // log generated number
        log.info("Main number = {}", number);

        //get game bean from context (container)

        Game game = context.getBean(Game.class);

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        log.info("#### message: {}", messageGenerator.getMainMessage());

        // close context (container)
        context.close();




    }


}
