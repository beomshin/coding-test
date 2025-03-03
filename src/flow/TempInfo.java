package flow;

import java.util.Random;

public class TempInfo {

    public static final Random rand = new Random();

    private final String town;
    private final int temp;

    public TempInfo(String town, int temp) {
        this.town = town;
        this.temp = temp;
    }

    public static TempInfo fetch(String town) {
        if (rand.nextInt(10) == 0)
            throw new RuntimeException("error");
        return new TempInfo(town, rand.nextInt(100));
    }


    @Override
    public String toString() {
        return town + " : " + temp;
    }

    public String getTown() {
        return town;
    }

    public int getTemp() {
        return temp;
    }
}
