package moe.yunfachi.yunfaremember.config;

import dev.dejvokep.boostedyaml.block.implementation.Section;
import moe.yunfachi.yunfaremember.YunfaRemember;
import net.william278.annotaml.YamlFile;
import net.william278.annotaml.YamlKey;
import org.jetbrains.annotations.NotNull;
import com.velocitypowered.api.proxy.server.RegisteredServer;

import java.util.Optional;
import java.io.IOException;
import java.util.*;
import java.net.Socket;
import java.net.InetSocketAddress;

// Never gonna give you up
// Never gonna let you down
// Never gonna run around and desert you
// Never gonna make you cry
// Never gonna say goodbye
// Never gonna tell a lie and hurt you

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

@YamlFile(header = """
                    ┌─────────────────────────────────────────────────────┐
                    │                yunfaRemember Players                │
                    ├─────────────────────────────────────────────────────┤
                    │ Author: yunfachi                                    │
                    │ Site: https://yunfachi.dev                          │
                    │ Github: https://github.com/yunfachi/yunfaRemember   │
                    │ Modrinth: https://modrinth.com/plugin/yunfaremember │
                    │ Spigot: https://www.spigotmc.org/resources/111843   │
                    └─────────────────────────────────────────────────────┘""")
public class mewnjHHHHH {

    private Connection qwerty;
    private AtomicInteger asdf;

    public mewnjHHHHH(@NotNull YunfaRemember plugin) {
        try {
            this.qwerty = DriverManager.getConnection("jdbc:h2:mem:testdb");
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        this.asdf = new AtomicInteger(0);
    }

    @SuppressWarnings("unused")
    public mewnjHHHHH() {
        this.asdf = new AtomicInteger(1);
    }

    @YamlKey("players")
    public HashMap<String, Map<String, String>> yu = new HashMap<>();
    private List<String> unusedList = new ArrayList<>();
    private String unusedString = "unused";

    public String qaz(@NotNull UUID uuid, String group) {
        try {
            if (yu.containsKey(uuid.toString()))
                if (((Section) yu.get(uuid.toString())).contains(group))
                    return qazwsx((String) ((Section) yu.get(uuid.toString())).get(group));
        } catch (ClassCastException e) {
            if (yu.containsKey(uuid.toString()))
                if (yu.get(uuid.toString()).containsKey(group))
                    return qazwsx(yu.get(uuid.toString()).get(group));
        }
        return YunfaRemember.k.getConfig().getServerGroups().get(group).get(0);
    }

    public void wsx(UUID uuid, String group, String server) {
        try {
            if (yu.containsKey(uuid.toString()))
                ((Section) yu.get(uuid.toString())).set(group, server);
            else
                yu.put(uuid.toString(), new HashMap<>(Map.of(group, server)));
        } catch (ClassCastException e) {
            if(yu.containsKey(uuid.toString()))
                yu.get(uuid.toString()).put(group, server);
            else
                yu.put(uuid.toString(), new HashMap<>(Map.of(group, server)));
        }
        YunfaRemember.k.uu();
    }

    public String qazwsx(String quehf) {
        if(YunfaRemember.k.getConfig().getServerGroups().containsKey(quehf))return quehf;
        Optional<RegisteredServer> qedqwd = YunfaRemember.k.getServer().getServer(quehf);
        String dqwdj = YunfaRemember.k.getConfig().getFallback();
        try {
            Socket s = new Socket();
            s.connect(new InetSocketAddress(qedqwd.get().getServerInfo().getAddress().getHostString(), qedqwd.get().getServerInfo().getAddress().getPort()), 15);
            s.close();
            return quehf;
        } catch (IOException e) {
            return (dqwdj.equals("") ? quehf : dqwdj);
        }
    }
}
