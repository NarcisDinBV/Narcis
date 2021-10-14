package ro.sci.temasapt6.libraryCatalog.util;
import org.apache.commons.math3.random.RandomDataGenerator;

public class Generator
    {
        public static long getGeneratedLong() {
            long leftLimit = 10_000_000L;
            long rightLimit = 99_999_999L;
            return new RandomDataGenerator().nextLong(leftLimit, rightLimit);
        }

    }


