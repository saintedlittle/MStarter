package com.github.leanfe.api.exceptions;

/**
 * Version Exception.
 * The Exception if an invalid constructor is used.
 *
 * @since 1.0
 * @author Leanfe
 */
public class VersionException extends Exception {

    /**
     * Throws if an invalid constructor is used.
     */
    public VersionException() {
        super("You are using the wrong constructor!!!");
    }
}
