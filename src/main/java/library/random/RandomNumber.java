package library.random;

public class RandomNumber {

    public static int random(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static int random(int length) {
        int min = (int) Math.pow(10, length);
        int max = (int) Math.pow(10, length + 1) - 1;

        return RandomNumber.random(min, max);
    }
}
