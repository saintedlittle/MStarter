package com.github.leanfe.api.version;

import com.github.leanfe.api.exceptions.VersionException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    private final String name;
    /**
     * Contains the path to the folder with natives.
     */
    private final String pathDll;
    /**
     * Contains the path to the folder with jar files.
     */
    private final String pathJar;
    /**
     * Contains the name of the main minecraft class.
     */
    private final String mainClassName;
    /**
     * Contains the name of the minecraft jar file.
     */
    private final String minecraftJarfileName;
    /**
     * Contains an object of the main minecraft class.
     */
    private Object minecraftMainClassObject;

    /**
     * The Version constructor.
     *
     * @param name                 the name of version.
     * @param pathDll              the path to all dll-files.
     * @param pathJAR              the path to all jar-files.
     * @param mainClassName        the minecraft main class name.
     * @param minecraftJarfileName the minecraft jarfile name.
     */
    public Version(String name, String pathDll, String pathJAR, String mainClassName, String minecraftJarfileName) {
        this.name = name;
        this.mainClassName = mainClassName;
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
     */
    @Override
    public void addArgument(String value) {

    }

    /**
     * Just launches the main class from a tightened jar.
     * @param args An array of arguments for minecraft.
     * @return stream, with the application running.
     *
     * @throws VersionException If an error occurred during version processing.
     */
    @Override
    public Thread start(String[] args) throws VersionException {
        Runnable runnable;

        if (minecraftMainClassObject == null) {
            throw new VersionException();
        } else {
            runnable = () -> {
                Method method = null;
                try {
                    method = minecraftMainClassObject.getClass().getDeclaredMethod("main");
                    Object instance = minecraftMainClassObject.getClass().newInstance();
                    Object result = method.invoke(instance);
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                         IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            };
            Thread thread = new Thread(runnable, "Instance with args");
            thread.start();
            return thread;
        }

    }

    /**
     * Just launches the main class from a tightened jar.
     * @return stream, with the application running.
     *
     * @throws VersionException - If an error occurred during version processing.
     */
    @Override
    public Thread start() throws VersionException {
        Runnable runnable;
        if (minecraftMainClassObject == null) {
            throw new VersionException();
        } else {
            runnable = () -> {
                Method method = null;
                try {
                    method = minecraftMainClassObject.getClass().getDeclaredMethod("main");
                    Object instance = minecraftMainClassObject.getClass().newInstance();
                    Object result = method.invoke(instance);
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                         IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            };
            Thread thread = new Thread(runnable, "Instance");
            thread.start();
            return thread;
        }
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
     * Gets minecraft main class name.
     *
     * @return The minecraft main class name.
     */
    public String getMainClassName() {
        return mainClassName;
    }

    /**
     * Gets minecraft jarfile name.
     *
     * @return The minecraft jarfile name.
     */
    public String getMinecraftJarfileName() {
        return minecraftJarfileName;
    }

    /**
     * Sets minecraft main class object.
     *
     * @param minecraftMainClassObject The minecraft main class object.
     */
    public void setMinecraftMainClassObject(Object minecraftMainClassObject) {
        this.minecraftMainClassObject = minecraftMainClassObject;
    }

}