import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot {
    public Bot(String token) {
        try {
            JDABuilder
                    .createDefault(token)
                    .setActivity(Activity.playing("Valorant"))
                    .setStatus(OnlineStatus.IDLE)
                    .addEventListeners(new Listener())
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Bot(Config.getToken());
    }
}
