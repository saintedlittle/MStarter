package com.github.leanfe.api.version;

import com.github.leanfe.api.LoadManager;
import com.github.leanfe.api.exceptions.AgentException;
import com.github.leanfe.api.version.forge.ForgeVersionClasses;
import com.github.leanfe.api.version.vanilla.VanillaVersionClasses;

import java.io.File;
import java.io.IOException;

/**
 * Class for manage versions.
 * A class for working with versions. Load/launch.
 *
 * @since 1.0
 * @author Leanfe
 */
public class VersionManager {

    /**
     * Stores the Loader Manager object.
     */
    private final LoadManager loadManager;

    /**
     * Stores the current version.
     */
    private final Version totalVersion;

    /**
     * The status of the loaded version or not.
     */
    private boolean isLoaded = false;

    /**
     * The basic constructor of the version manager.
     * @param type The type of Version. (Vanilla/Forge)
     * @param path_to_agent The path to the ByteBuddy agent.
     * @param version Version for load.
     */
    public VersionManager(VersionsType type, String path_to_agent, Versions version) {
        loadManager = new LoadManager(new File(path_to_agent));
        if (type == VersionsType.VANILLA) {
            switch (version) {
                case VANILLA_VERSION_8 -> totalVersion = new VanillaVersionClasses.VERSION_1_8("vanilla_native8", "jars", "version/minecraft.jar");
                case VANILLA_VERSION_9 -> totalVersion = new VanillaVersionClasses.VERSION_1_9("vanilla_native9", "jars", "version/minecraft.jar");
                case VANILLA_VERSION_10 -> totalVersion = new VanillaVersionClasses.VERSION_1_10("vanilla_native10", "jars", "version/minecraft.jar");
                case VANILLA_VERSION_11 -> totalVersion = new VanillaVersionClasses.VERSION_1_11("vanilla_native11", "jars", "version/minecraft.jar");
                case VANILLA_VERSION_12 -> totalVersion = new VanillaVersionClasses.VERSION_1_12("vanilla_native12", "jars", "version/minecraft.jar");
                case VANILLA_VERSION_13 -> totalVersion = new VanillaVersionClasses.VERSION_1_13("vanilla_native13", "jars", "version/minecraft.jar");
                case VANILLA_VERSION_14 -> totalVersion = new VanillaVersionClasses.VERSION_1_14("vanilla_native14", "jars", "version/minecraft.jar");
                case VANILLA_VERSION_15 -> totalVersion = new VanillaVersionClasses.VERSION_1_15("vanilla_native15", "jars", "version/minecraft.jar");
                case VANILLA_VERSION_16 -> totalVersion = new VanillaVersionClasses.VERSION_1_16("vanilla_native16", "jars", "version/minecraft.jar");
                case VANILLA_VERSION_17 -> totalVersion = new VanillaVersionClasses.VERSION_1_17("vanilla_native17", "jars", "version/minecraft.jar");
                case VANILLA_VERSION_18 -> totalVersion = new VanillaVersionClasses.VERSION_1_18("vanilla_native18", "jars", "version/minecraft.jar");
                case VANILLA_VERSION_19 -> totalVersion = new VanillaVersionClasses.VERSION_1_19("vanilla_native19", "jars", "version/minecraft.jar");
                default -> totalVersion = new VanillaVersionClasses.VERSION_1_19("native19", "jars", "version/minecraft.jar");
            }
        } else {
            switch (version) {
                case FORGE_VERSION_8 -> totalVersion = new ForgeVersionClasses.VERSION_1_8("forge_native8", "jars", "version/minecraft.jar");
                case FORGE_VERSION_9 -> totalVersion = new ForgeVersionClasses.VERSION_1_9("forge_native9", "jars", "version/minecraft.jar");
                case FORGE_VERSION_10 -> totalVersion = new ForgeVersionClasses.VERSION_1_10("forge_native10", "jars", "version/minecraft.jar");
                case FORGE_VERSION_11 -> totalVersion = new ForgeVersionClasses.VERSION_1_11("forge_native11", "jars", "version/minecraft.jar");
                case FORGE_VERSION_12 -> totalVersion = new ForgeVersionClasses.VERSION_1_12("forge_native12", "jars", "version/minecraft.jar");
                case FORGE_VERSION_13 -> totalVersion = new ForgeVersionClasses.VERSION_1_13("forge_native13", "jars", "version/minecraft.jar");
                case FORGE_VERSION_14 -> totalVersion = new ForgeVersionClasses.VERSION_1_14("forge_native14", "jars", "version/minecraft.jar");
                case FORGE_VERSION_15 -> totalVersion = new ForgeVersionClasses.VERSION_1_15("forge_native15", "jars", "version/minecraft.jar");
                case FORGE_VERSION_16 -> totalVersion = new ForgeVersionClasses.VERSION_1_16("forge_native16", "jars", "version/minecraft.jar");
                case FORGE_VERSION_17 -> totalVersion = new ForgeVersionClasses.VERSION_1_17("forge_native17", "jars", "version/minecraft.jar");
                case FORGE_VERSION_18 -> totalVersion = new ForgeVersionClasses.VERSION_1_18("forge_native18", "jars", "version/minecraft.jar");
                case FORGE_VERSION_19 -> totalVersion = new ForgeVersionClasses.VERSION_1_19("forge_native19", "jars", "version/minecraft.jar");
                default -> totalVersion = new ForgeVersionClasses.VERSION_1_19("forge_native19", "jars", "version/minecraft.jar");

            }
        }
    }

    /**
     * The basic constructor of the version manager.
     * @param path_to_agent The path to the ByteBuddy agent.
     * @param version Version for load.
     */
    public VersionManager(String path_to_agent, Version version) {
        loadManager = new LoadManager(new File(path_to_agent));
        totalVersion = version;
    }

    /**
     * Returns the current version of minecraft.
     * @return Total version;
     */
    public Version getTotalVersion() {
        return totalVersion;
    }

    /**
     * Uploads a specific version of minecraft to the JVM.
     * @param version The version to load.
     */
    public void loadVersion(Version version) {
        if (!isLoaded) {
            try {
                loadManager.load(version.getPathDll(), version.getPathJar(), version.getMinecraftJarfileName());
            } catch (IOException | AgentException e) {
                throw new RuntimeException(e);
            }
        }
        isLoaded = true;
    }

    public Thread startVersion(Version version) {
        return version.start();
    }
}