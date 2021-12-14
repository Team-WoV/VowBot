package me.kmaxi.wynnvp;

import net.dv8tion.jda.api.entities.*;

import java.util.Objects;
import java.util.function.Consumer;

public class Utils {


    public static boolean isStaff(Member member) {
        for (Role role : member.getRoles()) {
            if (role.getIdLong() == Config.roleID) {
                return true;
            }
        }
        return false;
    }

    public static String convertNumber(int number) {
        switch (number) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
        }
        return ":x:";
    }

    public static String getUnicode(int number) {
        switch (number) {
            case 1:
                return "\u0031\uFE0F\u20E3";
            case 2:
                return "\u0032\uFE0F\u20E3";
            case 3:
                return "\u0033\uFE0F\u20E3";
            case 4:
                return "\u0034\uFE0F\u20E3";
            case 5:
                return "\u0035\uFE0F\u20E3";
            case 6:
                return "\u0036\uFE0F\u20E3";
            case 7:
                return "\u0037\uFE0F\u20E3";
            case 8:
                return "\u0038\uFE0F\u20E3";
            case 9:
                return "\u0039\uFE0F\u20E3";
            case 0:
                return "\u274C";
        }
        return "\u274C";
    }

    public static int whichNumberWasReacted(String emote) {
        switch (emote) {
            case "\u0031\uFE0F\u20E3":
                return 1;
            case "\u0032\uFE0F\u20E3":
                return 2;
            case "\u0033\uFE0F\u20E3":
                return 3;
            case "\u0034\uFE0F\u20E3":
                return 4;
            case "\u0035\uFE0F\u20E3":
                return 5;
            case "\u0036\uFE0F\u20E3":
                return 6;
            case "\u0037\uFE0F\u20E3":
                return 7;
            case "\u0038\uFE0F\u20E3":
                return 8;
            case "\u0039\uFE0F\u20E3":
                return 9;
        }
        return 0;
    }



    public static void formatName(String name, Guild guild, Consumer<String> callback) {

        if (guild.getCategoryById(Config.spamCategoryID) == null){
            System.out.println("ERROR! SPAM CATEGORY IS NULL");
            return;
        }

        Objects.requireNonNull(guild.getCategoryById(Config.spamCategoryID))
                .createTextChannel(name)
                .queue(textChannel -> callback.accept(textChannel.getName()));
    }


    public static void sendPrivateMessage(User user, String content) {
        // openPrivateChannel provides a RestAction<PrivateChannel>
        // which means it supplies you with the resulting channel
        user.openPrivateChannel().queue((channel) ->
                channel.sendMessage(content).queue());
    }
}
