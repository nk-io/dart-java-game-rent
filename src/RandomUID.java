import java.util.UUID;

//chance of two random UUIDs colliding is about 10^-37
public class RandomUID {

    public static String generateRandomID () {
        return UUID.randomUUID().toString();
    }

}

