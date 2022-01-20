import io.github.cdimascio.dotenv.Dotenv;

public class Config {

    private static final Dotenv dotenv = Dotenv.load();

    public static String getToken() {
        return dotenv.get("TOKEN");
    }

    public static String getPrefix() {
        return dotenv.get("PREFIX");
    }

    public static String getOwnerID() {
        return dotenv.get("OWNER_ID");
    }
}
