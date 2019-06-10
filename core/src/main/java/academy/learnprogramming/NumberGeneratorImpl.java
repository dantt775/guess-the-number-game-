package academy.learnprogramming;

import java.util.Random;


public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
    private final Random random = new Random();

    private int maxNumber = 100;


    // == public method ==
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public void atleraMaxNumber(int value) {
        this.maxNumber=value;
    }
}
