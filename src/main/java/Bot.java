import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot {

    public static void main(String[] args) {
        try {
            JDA jda = JDABuilder
                    .createDefault(Config.getToken())
                    .setActivity(Activity.playing("Valorant"))
                    .setStatus(OnlineStatus.IDLE)
                    .addEventListeners(new Listener())
                    .build();
            jda.awaitReady();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
