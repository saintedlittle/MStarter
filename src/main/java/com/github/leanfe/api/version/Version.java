package com.github.leanfe.api.version;

import net.minecraft.client.main.Main;

import java.io.File;
import java.util.ArrayList;

/**
 * The Version type.
 * An abstract version class that contains a basic implementation.
 *
 * @since 1.0
 * @author Leanfe
 */
public abstract class Version implements IVersion {

    /**
     * Contains the name of the version.
     */
    protected String name;
    /**
     * Contains the path to the folder with natives.
     */
    protected String pathDll;
    /**
     * Contains the path to the folder with jar files.
     */
    protected String pathJar;

    /**
     * Contains the name of the minecraft jar file.
     */
    protected String minecraftJarfileName;

    protected ArrayList<String> args = new ArrayList<>();

    /**
     * The Version constructor.
     *
     * @param name                 the name of folder with version.
     * @param pathDll              the path to all dll-files.
     * @param pathJAR              the path to all jar-files.
     * @param minecraftJarfileName the minecraft jarfile name.
     */
    protected Version(String name, String pathDll, String pathJAR, String minecraftJarfileName) {
        this.name = name;
        this.minecraftJarfileName = minecraftJarfileName;
        this.pathDll = pathDll;
        this.pathJar = pathJAR;

    }

    /**
     * The method for downloading the version.
     * @return status code.
     */
    @Override
    @Deprecated
    public int load() {
        return 0;
    }

    /**
     * Adds an argument to the list, which will then be passed to the main method.
     * @param value The argument for Minecraft that will be passed to it. See <a href="https://github.com/Leanfe/MStarter">GitHub</a>
     *
     * @since 2.0 -> Use a default method for every operation.
     */
    @Override
    @Deprecated
    public void addArgument(String value) {
        args.add(value);
    }

    /**
     * Just launches the main class from a tightened jar.
     * @return stream, with the application running.
     *
     */
    @Override
    public Thread start() {
        Runnable runnable;

        runnable = () -> Main.main(args.toArray(new String[0]));
        Thread thread = new Thread(runnable, "Instance with args");
        thread.start();
        return thread;

    }


    /**
     * Gets version name.
     *
     * @return the version name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets path to all dll.
     *
     * @return The path to all dll.
     */
    public String getPathDll() {
        return pathDll;
    }

    /**
     * Gets path to all jar.
     *
     * @return The path to all jar.
     */
    public String getPathJar() {
        return pathJar;
    }


    /**
     * Gets minecraft jarfile name.
     *
     * @return The minecraft jarfile name.
     */
    public String getMinecraftJarfileName() {
        return minecraftJarfileName;
    }

    protected Version setBaseArgs(ArrayList<String> args) {
        args.add(" --version " + getName());
        args.add(" --assetIndex " + getName());
        args.add(" --versionType release");
        args.add(" --userProperties {}");
        return this;
    }

    public Version settingPlayer(String username, String UUID) {
        args.add(" --username " + username);
        args.add(" --uuid " + UUID);
        args.add(" --userType legacy");
        return this;
    }

    public Version setDirectory(File path) {
        args.add(" --gameDir " + path.getAbsolutePath());
        args.add(" --assetsDir " + path + File.separator + "assets");
        return this;
    }

    public Version setWidth(String width) {
        args.add(" --width " + width);
        return this;
    }

    public Version setHeight(String height) {
        args.add(" --height " + height);
        return this;
    }

    public Version setServer(String server, String port) {
        args.add(" --server " + server);
        args.add(" --port " + port);
        return this;
    }

    public Version setDemo(boolean demo) {
        if (demo) args.add(" --demo");
        return this;
    }


}