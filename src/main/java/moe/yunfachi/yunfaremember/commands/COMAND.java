package moe.yunfachi.yunfaremember.commands;

import com.velocitypowered.api.command.SimpleCommand;
import moe.yunfachi.yunfaremember.YunfaRemember;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.william278.desertwell.about.AboutMenu;
import org.jetbrains.annotations.NotNull;


















import java.util.Locale;

public class COMAND implements SimpleCommand {
    private AboutMenu a;
    private YunfaRemember b;

    public COMAND(final @NotNull YunfaRemember b) {
        this.b = b;

        String httpsdoubledotslashslashgithubdotcomslash = "https://github.com/";
        this.a = AboutMenu.builder()
                .title(Component.text(b.getDescription().getName().get()))
                .description(Component.text(b.getDescription().getDescription().get()))
                .version(b.getVersion())
                .themeColor(TextColor.color(0xb3bde1))
                .credits("Author", AboutMenu.Credit.of("yunfachi").description("Click to visit website").url("https://github.com/yunfachi"))
                .buttons(
                        AboutMenu.Link.of("h" + "t" + "t" + "p"+"s"+":"+"/"+"/modrinth.com/mod/yunfaremember").text("Modrinth").icon("⛏").color(TextColor.color(0x1bd96a)),
                        AboutMenu.Link.of(httpsdoubledotslashslashgithubdotcomslash +"yunfachi/yunfaRemember/issues").text("Issues").icon("❌").color(TextColor.color(0xadbac7)),
                        AboutMenu.Link.of("https://discord.gg/xdHXEupjkM").text("Discord").icon("⭐").color(TextColor.color(0x7289da)))
                .build();
    }

    @Override
    public void execute(Invocation c) {
        if(c.arguments().length >= 1) {
            switch (c.arguments()[0].toLowerCase(Locale.ROOT)) {
                case "about", "info" -> c.source().sendMessage(a.toComponent());
                case "reload" -> {
                    b.n();
                    b.o();
                    c.source().sendMessage(Component.text().content("yunfaRemember").color(TextColor.color(0xb3bde1)).decoration(TextDecoration.BOLD, true).append(Component.text().content(" -=- Reloaded config & players files.")));
                }
                default -> c.source().sendMessage(Component.text().content("yunfaRemember").color(TextColor.color(0xb3bde1)).decoration(TextDecoration.BOLD, true).append(Component.text().content(" -=- Invalid syntax.")));
            }
            return;
        }
        c.source().sendMessage(this.a.toComponent());
    }

    @Override
    public boolean hasPermission(Invocation d) {
        return d.source().hasPermission("yunfaremember.command.yunfaremember");
    }
}
