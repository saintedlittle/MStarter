package com.github.leanfe.api.version;

/**
 * Vanilla Version interface.
 * An interface that contains basic methods for working with the Version.
 *
 * @since 1.0
 * @author Leanfe
 */
public interface IVersion {

    /**
     * The method is needed to move .dll files in the folder with the JRE,
     * and also connects the JAR file of the version to the application.
     *
     * @return status code.
     */
    @Deprecated
    int load();

    /**
     * Add argument.
     *
     * @param value The argument for Minecraft that will be passed to it. See GitHub
     */
    void addArgument(String value);

    /**
     * The method performs the simplest function.
     * Just launches the main class from a tightened jar.
     *
     * @return stream, with the application running.
     */
    Thread start();

}
