package net.wyvest.damagetint.config;

import gg.essential.api.EssentialAPI;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import net.wyvest.damagetint.DamageTint;
import net.wyvest.damagetint.updater.DownloadGui;
import net.wyvest.damagetint.updater.Updater;

import java.awt.*;
import java.io.File;

public class Config extends Vigilant {
    @Property(
            type = PropertyType.SWITCH,
            name = "Toggle Mod",
            description = "Toggle the mod's functionality.",
            category = "General"
    )
    public static boolean toggle = true;

    @Property(
            type = PropertyType.SWITCH,
            name = "Chroma",
            description = "Whether or not to turn on a chroma effect. Overrides Damage Tint Colour (except the alpha / transparency colour modifier).",
            category = "General"
    )
    public static boolean chroma = false;

    @Property(
            type = PropertyType.NUMBER,
            name = "Chroma Speed",
            description = "Choose the speed of the chroma colour.",
            category = "General",
            min = 1,
            max = 10
    )
    public static int speed = 5;

    @Property(
            type = PropertyType.COLOR,
            name = "Damage Tint Colour",
            description = "Modify the damage tint when mobs take damage.",
            category = "General"
    )
    public static Color color = new Color(255, 0, 0, 76);

    @Property(
            type = PropertyType.SWITCH, name = "Fade Damage Tint",
            description = "Gradually fade the damage tint when hit.",
            category = "General"
    )
    public static boolean fade = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Show Update Notification",
            description = "Show a notification when you start Minecraft informing you of new updates.",
            category = "Updater"
    )
    public static boolean showUpdate = true;

    public Config() {
        super(new File(DamageTint.modDir, "damagetint.toml"), "Damage Tint");
        initialize();
    }

    @Property(
            type = PropertyType.BUTTON,
            name = "Update Now",
            description = "Update by clicking the button.",
            category = "Updater"
    )
    public void update() {
        if (Updater.shouldUpdate) EssentialAPI.getGuiUtil()
                .openScreen(new DownloadGui());
        else EssentialAPI.getNotifications()
                .push("Damage Tint", "No update had been detected at startup, and thus the update GUI has not been shown.");
    }
}