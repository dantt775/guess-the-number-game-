package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.DefaultLifecycleProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);


    private static final String CONFIG_LOCATION = "beans.xml";


    public static void main(String[] args) {
        log.info("Guess the Number game");

        //create context (container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // get NumberGenerator bean from context (container)
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        // call method next to get random number
        int number = numberGenerator.next();

        // log generated number
        log.info("Main number = {}", number);

        //get game bean from context (container)

        Game game = context.getBean(Game.class);

        // close context (container)
        context.close();




    }


}
