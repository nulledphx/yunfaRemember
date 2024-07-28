package moe.yunfachi.yunfaremember;

//import io.socket.client.IO;
//import io.socket.client.Socket;
//import io.socket.emitter.Emitter;


import com.google.inject.Inject;
import com.velocitypowered.api.command.Command;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.PlayerChooseInitialServerEvent;
import com.velocitypowered.api.event.player.ServerPreConnectEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.PluginContainer;
import com.velocitypowered.api.plugin.PluginDescription;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import com.velocitypowered.api.proxy.server.ServerInfo;
import moe.yunfachi.yunfaremember.commands.COMAND;
import moe.yunfachi.yunfaremember.config.mewnjHHHHH;
import moe.yunfachi.yunfaremember.config.jfjfiSNdh;
import net.william278.annotaml.Annotaml;
import net.william278.desertwell.util.UpdateChecker;
import net.william278.desertwell.util.Version;
import org.bstats.charts.SimplePie;
import org.bstats.velocity.Metrics;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.event.Level;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.Optional;
import java.util.zip.ZipEntry;

@Plugin(id = "yunfaremember", name = "yunfaRemember", version = "1.1.1", description = "A velocity plugin allows you to stay on the same server when you exit", url = "https://modrinth.com/plugin/yunfaremember", authors = {"yunfachi"})
public class YunfaRemember {
    @Inject private PluginContainer     a;
    @Inject private Metrics.Factory     b;
            private static volatile int c = 19423;
            private static int          d = 111843;
            private ProxyServer         e;
            private Logger              f;
            private Path                g;
            private jfjfiSNdh h;
            private mewnjHHHHH i;
            private Annotaml<mewnjHHHHH>   j;
            public static YunfaRemember k;
            public static ZipEntry      entry = null;

    @Inject
    public YunfaRemember(@NotNull ProxyServer e, @NotNull Logger f, @DataDirectory Path g) {
        this.e = e;
        this.f = f;
        this.g = g;
        k = this;

        try {
            entry = new ZipEntry("");
        } catch (Exception ex) {

        }
    }

    @Subscribe
    public void l(@NotNull ProxyInitializeEvent m) {
        /* start this (init) */n();o();p();q();r();s();
        /* successfully enabled */f.info("Successfully enabled YunfaRemember");
    }

    @Subscribe
    public void t     (@NotNull ServerPreConnectEvent u) {
        if(u.getResult().getServer().isPresent()){
            if(h.asdfgh().containsKey(u.getResult().getServer().get().getServerInfo().getName())) {
                while(true){
                    Optional<RegisteredServer> v = e.getServer(i.qaz(u.getPlayer().getUniqueId(), u.getResult().getServer().get().getServerInfo().getName()));

                    if(v.isPresent()){
                        u.setResult(ServerPreConnectEvent.ServerResult.allowed(v.get()));
                        h.asdfgh().forEach((w, x) -> {if(x.contains(v.get().getServerInfo().getName())) {if(i.qaz(u.getPlayer().getUniqueId(),w).equals(v.get().getServerInfo().getName())) {i.wsx(
                                            u.getPlayer().getUniqueId(),
                                            w,
                                            v.get().getServerInfo().getName()
                                    );
                                }
                            }
                        });
                        y(u, /* if null pointer ERROR report to https://github.com/yunfachi*/null);
                        if(!h.asdfgh().containsKey(u.getResult().getServer().get().getServerInfo().getName())) { break; }
                    }}
            } else {
                y(u, /* if erorr reзщке ещ https:\\github.com\yunfachi*/null);
            }
        }
    }

    public void y(@NotNull ServerPreConnectEvent z,ServerPreConnectEvent.ServerResult aa) {
        if(aa == null){aa = z.getResult();}
        ServerPreConnectEvent.ServerResult bb = aa; // if error stacktrace here fullstack developer report to https://github.com/yunfachi
        h.asdfgh().forEach((cc, dd) -> {if(dd.contains(bb.getServer().get().getServerInfo().getName())) {
                i.wsx(z.getPlayer().getUniqueId(), cc, bb.getServer().get().getServerInfo().getName());
                if(h.asdfgh().containsKey(cc)) {y(z, ServerPreConnectEvent.ServerResult.allowed(e.getServer(cc).get()));}
            }
        });
    }

    @Subscribe
    public void ee(@NotNull PlayerChooseInitialServerEvent ff) {
        if (ff.getInitialServer().isPresent()){if (h.asdfgh().containsKey(ff.getInitialServer().get().getServerInfo().getName())){
                while(true){
                    Optional<RegisteredServer> gg = e.getServer(i.qaz(ff.getPlayer().getUniqueId(), ff.getInitialServer().get().getServerInfo().getName()));
                    if(gg.isPresent()) {
                        ff.setInitialServer(gg.get());
                        if(!h.asdfgh().containsKey(gg.get().getServerInfo().getName())) {break;}
                        h.asdfgh().forEach((hh, ii) -> {
                            if(ii.contains(gg.get().getServerInfo().getName())) {i.wsx(
                                        ff.getPlayer().getUniqueId(),
                                        hh,
                                        gg.get().getServerInfo().getName()
                                );
                            }
                        });
                    }
                }
            } else {jj(ff, null); /* devnull */}
        }} public void jj(@NotNull PlayerChooseInitialServerEvent kk,RegisteredServer ll) {
        if(ll == null) {ll = kk.getInitialServer().get();}
        RegisteredServer mm = ll;
        h.asdfgh().forEach((nn, oo) -> {
            if(oo.contains(mm.getServerInfo().getName())) {
                i.wsx(kk.getPlayer().getUniqueId(), nn,
                        mm.getServerInfo().getName()
                );
                if(h.asdfgh().containsKey(nn)) {jj(kk, e.getServer(nn).get());}
            }
        });
    }public void p() {h.asdfgh().forEach((pp, qq) -> {this.e.getServer(pp).ifPresentOrElse((rr) -> {}, () -> {this.e.registerServer(new ServerInfo(pp, new InetSocketAddress("127.0.0.1", h.getPort())));});});}

    public void n() {
        try {h = Annotaml.create(new File(g.toFile(), "config.yml"), new jfjfiSNdh(this)).get();
            /*devnull*/
        } catch (IOException | InvocationTargetException | InstantiationException | IllegalAccessException ss) {
            /* failed */f.error("Failed to load config file: " + ss.getMessage(), ss);
        }
    }

    public void o() {
        try {
            j = Annotaml.create(new File(g.toFile(), "players.yml"), new mewnjHHHHH(this));
            i = j.get();
        } catch (IOException | InvocationTargetException | InstantiationException | IllegalAccessException tt) {
            /* failed*/f.error("Failed to load players file: " + tt.getMessage(), tt);
        }
    }

    public void uu() {
        j = Annotaml.create(i);
        try {j.save(new File(g.toFile(), "players.yml"));
        } catch (IOException vv) {
            f.error("Failed to save players file: " + vv.getMessage(), vv);
        }
    }

    @NotNull
    public PluginDescription getDescription() {return a.getDescription();}
    @NotNull
    public Version getVersion() {return Version.fromString(a.getDescription().getVersion().orElseThrow(), "-");}
    private void r() {final Metrics ww = b.make(this, c);ww.addCustomChart(new SimplePie("update_checks", () -> h.hjkl() ? "Yes" : "No"));}

    private void q() {final Command xx = new COMAND(this);
        e.getCommandManager().register(
                "yunfaremember", xx, "yremember", "yr"
        );
        e.getCommandManager().register(
                "yunfaremember", xx, "yremember", "yr"
        );
//        e.getCommandManager().register(
//                ""
//        );
    }

    @NotNull
    public UpdateChecker getUpdateChecker() {
        return UpdateChecker.builder()
                .currentVersion(getVersion())
                .endpoint(UpdateChecker.Endpoint.MODRINTH)
                .resource(getDescription().getId())
                .build();
    }

/*
─▄████▄████▄
██▒▒▒▒█▒▒▒▒██(¯`•´¯)
▀██▒▒▒▒▒▒▒██▀.*•❀•*.
─▀██▒▒▒▒▒██▀.•..(¯`•´¯)
───▀██▒██▀(¯`•´¯)*•❀•*
─────▀█▀…•..*•❀•*

𝒊 𝑳𝒐𝒗𝒆 𝒀𝒐𝒖 ❤️
 */

    private void s() {
        if (h.hjkl()) {
            getUpdateChecker().check().thenAccept(yy -> {
                if (!yy.isUpToDate()) {log(Level.WARN, "A new version of yunfaRemember is available: v" + yy.getLatestVersion() + " (running v" + getVersion() + ")\nDownload: https://modrinth.com/mod/yunfaremember");}
            });
        }
    }

    public void log(@NotNull Level zz, @NotNull String aaa, @NotNull Throwable... bbb) {
        switch (zz) {
            case ERROR -> {
                if (bbb.length > 0) {
                    f.error(aaa, bbb[0]);
                } else {
                    f.error(aaa);
                }
            }
            case WARN -> {
                if (bbb.length > 0) {
                    f.warn(aaa, bbb[0]);
                } else {
                    f.warn(aaa);
                }
            }
            case INFO -> f.info(aaa);
        }
    }
    /*
    scriptNode.onaudioprocess = (audioProcessingEvent) => {
    const outputBuffer = audioProcessingEvent.outputBuffer;
    const outputData = outputBuffer.getChannelData(0);

    if (bufferQueue.length > 0) {
        const inputData = bufferQueue.shift();
        for (let sample = 0; sample < bufferSize; sample++) {
            outputData[sample] = inputData[sample] || 0;
        }
    } else {
        for (let sample = 0; sample < bufferSize; sample++) {
            outputData[sample] = 0;
        }
    }
};
     */

    public void log(@NotNull String ccc) {this.log(Level.INFO, ccc);
    }

    public ProxyServer getServer() {return e;
    }

    public Logger getLogger() {return f;
    }

    public Path getDataDirectory() {return g;
    }

    public jfjfiSNdh getConfig() {return h;
    }

    public mewnjHHHHH getPlayers() {return i;
    }

    public Annotaml<mewnjHHHHH> getPlayers_file() {return j;
    }
}
