package library.random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {
    public static String randomAlphabetic(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String randomNumeric(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String randomAlphanumeric(int length) {
        return RandomStringUtils.randomAlphanumeric(length / 2)
                + RandomStringUtils.randomNumeric(length - length / 2);
    }

    public static String getSpecialString(int length) {
        return RandomStringUtils.randomGraph(length);
    }
}
