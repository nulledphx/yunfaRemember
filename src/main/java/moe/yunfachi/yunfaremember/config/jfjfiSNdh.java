package moe.yunfachi.yunfaremember.config;

import moe.yunfachi.yunfaremember.YunfaRemember;
import net.william278.annotaml.YamlComment;
import net.william278.annotaml.YamlFile;
import net.william278.annotaml.YamlKey;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@YamlFile(header = """
        ┌─────────────────────────────────────────────────────┐
        │                yunfaRemember Config                 │
        ├─────────────────────────────────────────────────────┤
        │ Author: yunfachi                                    │
        │ Site: https://yunfachi.dev                          │
        │ Github: https://github.com/yunfachi/yunfaRemember   │
        │ Modrinth: https://modrinth.com/plugin/yunfaremember │
        │ Spigot: https://www.spigotmc.org/resources/111843   │
        └─────────────────────────────────────────────────────┘""")
public class jfjfiSNdh {
    public jfjfiSNdh(@NotNull YunfaRemember zxcv) {
        this.uiop = Map.of("default_group",
                zxcv.getServer().getAllServers().stream().map(server -> server.getServerInfo().getName()).collect(Collectors.toList())
        );
    }

    @SuppressWarnings("unused")
    public jfjfiSNdh() {
    }

    @YamlComment("Whether to automatically check for plugin updates on startup")
    @YamlKey("check_for_updates")
    private boolean asdf = true;

    @YamlComment("Server groups will be created on this port.\n# if you want to connect to groups immediately after logging in, then in velocity.toml add a server with the name of the server group, ip 127.0.0.1 and the port that you specified here, now you can add the name of the group you need to \"try\".\n# you will not be able to join the group by ip, so all groups are on the same port")
    @YamlKey("groups_port")
    private int zxcvbn = 65483;

    @YamlComment("Type of storage to use (FILE)")
    @YamlKey("storage_type")
    private String qwerty = "FILE";

    @YamlComment("Those who could not enter the server from the group will go here. It can be a group or a server. \"\" to disable")
    @YamlKey("fallback")
    private String yuiop = "";

    @YamlComment("Groups with servers that will be connected, the group name must be different from the name of the servers, because for correct work it will be necessary to connect to the name of the group, instead of the name of the server.\n# keep order, because new players will go to the first server from the group")
    @YamlKey("server_groups")
    private Map<String, List<String>> uiop;

    public boolean hjkl() {
        return asdf;
    }

    public int getPort() {return zxcvbn;}

    public String qwerty() {
        return qwerty;
    }

    public String poiuy() {
        return yuiop;
    }

    public Map<String, List<String>> asdfgh() {
        return uiop;
    }

    public void setCheckForUpdates(boolean ghjk) {
        asdf = ghjk;
    }
}
