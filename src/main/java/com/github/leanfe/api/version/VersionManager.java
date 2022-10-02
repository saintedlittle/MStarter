package com.github.leanfe.api.version;

import com.github.leanfe.api.LoadManager;
import com.github.leanfe.api.exceptions.AgentException;

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
     * Stores the path to the ByteBuddy Agent.
     */
    private final File AGENT_JAR;

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
     * Enum with all the versions available for load.
     */
    public enum Versions {
        /**
         * The 1.8 minecraft version.
         */
        VERSION_8,
        /**
         * The 1.9 minecraft version.
         */
        VERSION_9,
        /**
         * The 1.10 minecraft version.
         */
        VERSION_10,
        /**
         * The 1.11 minecraft version.
         */
        VERSION_11,
        /**
         * The 1.12 minecraft version.
         */
        VERSION_12,
        /**
         * The 1.13 minecraft version.
         */
        VERSION_13,
        /**
         *  The 1.14 minecraft version.
         */
        VERSION_14,
        /**
         *  The 1.15 minecraft version.
         */
        VERSION_15,
        /**
         *  The 1.16 minecraft version.
         */
        VERSION_16,
        /**
         *  The 1.17 minecraft version.
         */
        VERSION_17,
        /**
         *  The 1.18 minecraft version.
         */
        VERSION_18,
        /**
         *  The 1.19 minecraft version.
         */
        VERSION_19;
    }

    private static class VERSION_1_8 extends Version {
        /**
         * The 1.8 version constructor.
         *
         * @param pathDll the path to all dll-files.
         * @param pathJAR the path to all jar-files.
         */
        public VERSION_1_8(String pathDll, String pathJAR, String minecraftClassName, String minecraftJarfilePath) {
            super("1.8", pathDll, pathJAR, minecraftClassName, minecraftJarfilePath);
        }
    }

    private static class VERSION_1_9 extends Version {
        /**
         * The 1.9 version constructor.
         *
         * @param pathDll the path to all dll-files.
         * @param pathJAR the path to all jar-files.
         */
        public VERSION_1_9(String pathDll, String pathJAR, String minecraftClassName, String minecraftJarfilePath) {
            super("1.9", pathDll, pathJAR, minecraftClassName, minecraftJarfilePath);
        }
    }

    private static class VERSION_1_10 extends Version {

        /**
         * The 1.10 version constructor.
         *
         * @param pathDll the path to all dll-files.
         * @param pathJAR the path to all jar-files.
         */
        public VERSION_1_10(String pathDll, String pathJAR, String minecraftClassName, String minecraftJarfilePath) {
            super("1.10", pathDll, pathJAR, minecraftClassName, minecraftJarfilePath);
        }
    }

    private static class VERSION_1_11 extends Version {

        /**
         * The 1.11 version constructor.
         *
         * @param pathDll the path to all dll-files.
         * @param pathJAR the path to all jar-files.
         */
        public VERSION_1_11(String pathDll, String pathJAR, String minecraftClassName, String minecraftJarfilePath) {
            super("1.11", pathDll, pathJAR, minecraftClassName, minecraftJarfilePath);
        }
    }

    private static class VERSION_1_12 extends Version {

        /**
         * The 1.12 version constructor.
         *
         * @param pathDll the path to all dll-files.
         * @param pathJAR the path to all jar-files.
         */
        public VERSION_1_12(String pathDll, String pathJAR, String minecraftClassName, String minecraftJarfilePath) {
            super("1.12", pathDll, pathJAR, minecraftClassName, minecraftJarfilePath);
        }
    }

    private static class VERSION_1_13 extends Version {

        /**
         * The 1.13 version constructor.
         *
         * @param pathDll the path to all dll-files.
         * @param pathJAR the path to all jar-files.
         */
        public VERSION_1_13(String pathDll, String pathJAR, String minecraftClassName, String minecraftJarfilePath) {
            super("1.13", pathDll, pathJAR, minecraftClassName, minecraftJarfilePath);
        }
    }

    private static class VERSION_1_14 extends Version {

        /**
         * The 1.14 version constructor.
         *
         * @param pathDll the path to all dll-files.
         * @param pathJAR the path to all jar-files.
         */
        public VERSION_1_14(String pathDll, String pathJAR, String minecraftClassName, String minecraftJarfilePath) {
            super("1.14", pathDll, pathJAR, minecraftClassName, minecraftJarfilePath);
        }
    }

    private static class VERSION_1_15 extends Version {

        /**
         * The 1.15 version constructor.
         *
         * @param pathDll the path to all dll-files.
         * @param pathJAR the path to all jar-files.
         */
        public VERSION_1_15(String pathDll, String pathJAR, String minecraftClassName, String minecraftJarfilePath) {
            super("1.15", pathDll, pathJAR, minecraftClassName, minecraftJarfilePath);
        }
    }

    private static class VERSION_1_16 extends Version {

        /**
         * The 1.16 version constructor.
         *
         * @param pathDll the path to all dll-files.
         * @param pathJAR the path to all jar-files.
         */
        public VERSION_1_16(String pathDll, String pathJAR, String minecraftClassName, String minecraftJarfilePath) {
            super("1.16", pathDll, pathJAR, minecraftClassName, minecraftJarfilePath);
        }
    }

    private static class VERSION_1_17 extends Version {

        /**
         * The 1.17 version constructor.
         *
         * @param pathDll the path to all dll-files.
         * @param pathJAR the path to all jar-files.
         */
        public VERSION_1_17(String pathDll, String pathJAR, String minecraftClassName, String minecraftJarfilePath) {
            super("1.17", pathDll, pathJAR, minecraftClassName, minecraftJarfilePath);
        }
    }

    private static class VERSION_1_18 extends Version {

        /**
         * The 1.18 version constructor.
         *
         * @param pathDll the path to all dll-files.
         * @param pathJAR the path to all jar-files.
         */
        public VERSION_1_18(String pathDll, String pathJAR, String minecraftClassName, String minecraftJarfilePath) {
            super("1.18", pathDll, pathJAR, minecraftClassName, minecraftJarfilePath);
        }
    }

    private static class VERSION_1_19 extends Version {

        /**
         * The 1.19 version constructor.
         *
         * @param pathDll the path to all dll-files.
         * @param pathJAR the path to all jar-files.
         */
        public VERSION_1_19(String pathDll, String pathJAR, String minecraftClassName, String minecraftJarfilePath) {
            super("1.19", pathDll, pathJAR, minecraftClassName, minecraftJarfilePath);
        }
    }


    /**
     * The basic constructor of the version manager.
     * @param path_to_agent The path to the ByteBuddy agent.
     * @param version Version for load.
     */
    public VersionManager(String path_to_agent, Versions version) {
        AGENT_JAR = new File(path_to_agent);
        loadManager = new LoadManager(AGENT_JAR);

        switch (version) {
            case VERSION_8 -> totalVersion = new VERSION_1_8("native8", "jars", "net.minecraft.launchwrapper.Launch", "version/minecraft.jar");
            case VERSION_9 -> totalVersion = new VERSION_1_9("native9", "jars", "net.minecraft.launchwrapper.Launch", "version/minecraft.jar");
            case VERSION_10 -> totalVersion = new VERSION_1_10("native10", "jars", "net.minecraft.launchwrapper.Launch", "version/minecraft.jar");
            case VERSION_11 -> totalVersion = new VERSION_1_11("native11", "jars", "net.minecraft.launchwrapper.Launch", "version/minecraft.jar");
            case VERSION_12 -> totalVersion = new VERSION_1_12("native12", "jars", "net.minecraft.launchwrapper.Launch", "version/minecraft.jar");
            case VERSION_13 -> totalVersion = new VERSION_1_13("native13", "jars", "net.minecraft.launchwrapper.Launch", "version/minecraft.jar");
            case VERSION_14 -> totalVersion = new VERSION_1_14("native14", "jars", "net.minecraft.launchwrapper.Launch", "version/minecraft.jar");
            case VERSION_15 -> totalVersion = new VERSION_1_15("native15", "jars", "net.minecraft.launchwrapper.Launch", "version/minecraft.jar");
            case VERSION_16 -> totalVersion = new VERSION_1_16("native16", "jars", "net.minecraft.launchwrapper.Launch", "version/minecraft.jar");
            case VERSION_17 -> totalVersion = new VERSION_1_17("native17", "jars", "net.minecraft.launchwrapper.Launch", "version/minecraft.jar");
            case VERSION_18 -> totalVersion = new VERSION_1_18("native18", "jars", "net.minecraft.launchwrapper.Launch", "version/minecraft.jar");
            case VERSION_19 -> totalVersion = new VERSION_1_19("native19", "jars", "net.minecraft.launchwrapper.Launch", "version/minecraft.jar");
            default -> totalVersion = new VERSION_1_19("native19", "jars", "net.minecraft.launchwrapper.Launch", "version/minecraft.jar");
        }
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
        if (!isLoaded)
            try {
                version.setMinecraftMainClassObject(loadManager.load(version.getPathDll(), version.getPathJar(), version.getMinecraftJarfileName(), version.getMainClassName()));
            } catch (IOException | AgentException e) {
                System.err.println(e.getMessage());
            }
        isLoaded = true;
    }
}