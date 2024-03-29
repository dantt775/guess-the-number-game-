package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;

    private int guessCount = 10;

    @Override
    public String getMainMessage() {
        return "Main Message";
    }

    @Override
    public String getResultMessage() {
        return "Result Messsage";
    }

    @PostConstruct
    public void init(){
        log.info("game value: {}", game.toString());
    }
}
