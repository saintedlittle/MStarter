package com.github.leanfe.api.version;

import com.github.leanfe.api.exceptions.VersionException;

/**
 * IVersion interface.
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
    public abstract int load();

    /**
     * Add argument.
     *
     * @param value The argument for Minecraft that will be passed to it. See GitHub
     */
    public abstract void addArgument(String value);

    /**
     * The method performs the simplest function.
     * Just launches the main class from a tightened jar.
     *
     * @return stream, with the application running.
     * @throws VersionException If an error occurred during version processing.
     * @param args Arguments for minecraft. See <a href="https://github.com/Leanfe/MStarter/wiki/Minecraft-CommandLine-args.">Wiki</a>
     */
    public abstract Thread start(String[] args) throws VersionException;

    /**
     * The method performs the simplest function.
     * Just launches the main class from a tightened jar.
     *
     * @return stream, with the application running.
     * @throws VersionException If an error occurred during version processing.
     */
    Thread start() throws VersionException;

}
