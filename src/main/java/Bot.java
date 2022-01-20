import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot {
    public Bot(String token) {
        try {
            JDA jda = JDABuilder
                    .createDefault(token)
                    .setActivity(Activity.playing("Valorant"))
                    .setStatus(OnlineStatus.IDLE)
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Bot("OTMxMTAwMDQyMzQzODkwOTk0.Yd_gfQ.Bi72OPLObjO1Pwz6rpauVRDiO0c");
    }
}
