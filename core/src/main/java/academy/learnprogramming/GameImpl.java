package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class GameImpl implements Game {

    private static final Logger  log = LoggerFactory.getLogger(GameImpl.class);



    private NumberGenerator numberGenerator;
    private int guessCount = 0;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;




    public void showNumber(){
        log.debug("GameImpl number is {} ", this.numberGenerator.getMaxNumber());
    }

    @Override
    public void reset() {
        smallest=0;
        guess=0;
        remainingGuesses=guessCount;
        biggest=numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {} ", this.number);

    }

    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess=guess;
    }

    @Override
    public int getSmallest() {
        return this.smallest;
    }

    @Override
    public int getBiggest() {
        return this.biggest;
    }

    @Override
    public int getRemaining() {
        return this.remainingGuesses;
    }


    @Override
    public void check() {
        checkValidNumberRange();

        if(this.validNumberRange){
            if(this.guess>this.number){
                this.biggest = this.guess-1;
            }

            if(this.guess < this.number){
                this.smallest = this.guess+1;
            }
        }
        this.remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return this.validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return this.guess==this.number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && this.remainingGuesses<=0;
    }

    private void checkValidNumberRange(){
        this.validNumberRange = (this.guess >= this.smallest) && (this.guess <= this.biggest);
    }
}
