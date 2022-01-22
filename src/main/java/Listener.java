import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Listener extends ListenerAdapter {

    public static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        LOGGER.info("{} is ready!", event.getJDA().getSelfUser().getAsTag());
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        JDA jda = event.getJDA();
        User author = event.getAuthor();
        Message message = event.getMessage();
        String raw = event.getMessage().getContentRaw();
        MessageChannel channel = event.getChannel();

        if(channel.getType().equals(ChannelType.TEXT)) {
            Guild guild = event.getGuild();
            TextChannel textChannel = message.getTextChannel();
            Member member = event.getMember();

            String name;
            if(message.isWebhookMessage()) {
                name = author.getName();
            } else {
                assert member != null;
                name = member.getEffectiveName();
            }
        }

        if(raw.equals(Config.getPrefix() + "ping")) {
            channel.sendMessageFormat("""
                            Pong!
                            %sms
                            """, jda.getGatewayPing())
                    .queue();
        }
    }
}
