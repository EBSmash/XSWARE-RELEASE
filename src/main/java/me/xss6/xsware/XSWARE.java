package me.xss6.xsware;

import me.xss6.xsware.command.Commands;
import me.xss6.xsware.event.Events;
import me.xss6.xsware.event.processor.EventProcessor;
import me.xss6.xsware.gui.XswareGuiNew;
import me.xss6.xsware.gui.hud.XswareHudGui;
import me.xss6.xsware.gui.hud.element.HudManager;
import me.xss6.xsware.hack.Hacks;
import me.xss6.xsware.manager.*;
import me.xss6.xsware.manager.fonts.DonatorFont;
import me.xss6.xsware.manager.fonts.GuiFont;
import me.xss6.xsware.manager.fonts.MenuFont;
import me.xss6.xsware.networking.chat.handler.ChatHandling;
import me.xss6.xsware.networking.chat.handler.ClientHandling;
import me.xss6.xsware.networking.proxy.XswareProxy;
import me.xss6.xsware.setting.Settings;
import me.xss6.xsware.util.RenderUtil2D;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;


@Mod(modid = XSWARE.MODID, name = XSWARE.MODNAME, version = XSWARE.MODVER)
public class XSWARE {

    public static final String MODID = "xsware";
    public static final String MODNAME = "XSWARE";
    public static final String MODVER = "2.5.5+";

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    // events
    public static Events EVENTS;
    public static EventProcessor EVENT_PROCESSOR;

    // commands
    public static Commands COMMANDS;

    // hacks
    public static Hacks HACKS;

    // settings
    public static Settings SETTINGS;

    // gui
    public static XswareGuiNew GUI2;
    public static XswareHudGui HUDGUI;

    // managers
    public static MenuFont MENU_FONT_MANAGER;
    public static HelpManager HELP_MANAGER;
    public static GuiFont GUI_FONT_MANAGER;
    public static DonatorFont DONATOR_FONT_MANAGER;
    public static FriendManager FRIEND_MANAGER;
    public static EnemyManager ENEMY_MANAGER;
    public static PopManager POP_MANAGER;
    public static ServerManager SERVER_MANAGER;
    public static PositionManager POS_MANAGER;
    public static RotationManager ROTATION_MANAGER;
    public static ConfigManager CONFIG_MANAGER;
    public static SongManager SONG_MANAGER;
    public static CapeManager CAPE_MANAGER;
    public static CosmeticManager COSMETIC_MANAGER;
    public static AltManager ALT_MANAGER;
    public static ClientHandling CLIENT_HANDLING;
    public static ChatHandling CHAT_HANDLING;
    public static HudManager HUD_MANAGER;
    public static KDManager KD_MANAGER;
    public static XswareProxy PROXY;

    // megs weird thingy
    public static RenderUtil2D RENDER_UTIL_2D;

    @Mod.Instance
    public static XSWARE INSTANCE;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("loading " + MODNAME);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        this.load();
        LOGGER.info(MODNAME + " : " + MODVER + " has been loaded");
        Display.setTitle("XSWARE | v" + MODVER);
    }

    public void load() {
        EVENT_PROCESSOR = new EventProcessor();
        EVENTS = new Events();
        SETTINGS = new Settings();
        RENDER_UTIL_2D = new RenderUtil2D();
        COMMANDS = new Commands();
        HACKS = new Hacks();
        HUD_MANAGER = new HudManager();
        this.loadManagers();
        CLIENT_HANDLING = new ClientHandling();
        CHAT_HANDLING = new ChatHandling();
        CONFIG_MANAGER.loadConfig();
        GUI2 = new XswareGuiNew();
        HUDGUI = new XswareHudGui();
    }

    public static void unLoad() {
        CONFIG_MANAGER.saveConfig();
    }

    public void loadManagers() {
        MENU_FONT_MANAGER = new MenuFont();
        GUI_FONT_MANAGER = new GuiFont();
        FRIEND_MANAGER = new FriendManager();
        ENEMY_MANAGER = new EnemyManager();
        POP_MANAGER = new PopManager();
        SERVER_MANAGER = new ServerManager();
        POS_MANAGER = new PositionManager();
        HELP_MANAGER = new HelpManager();
        ROTATION_MANAGER = new RotationManager();
        CONFIG_MANAGER = new ConfigManager();
        SONG_MANAGER = new SongManager();
        CAPE_MANAGER = new CapeManager();
        DONATOR_FONT_MANAGER = new DonatorFont();
        COSMETIC_MANAGER = new CosmeticManager();
        ALT_MANAGER = new AltManager();
        KD_MANAGER = new KDManager();
    }

}
