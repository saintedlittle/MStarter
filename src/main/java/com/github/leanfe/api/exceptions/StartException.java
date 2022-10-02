package com.github.leanfe.api.exceptions;

/**
 * Start Exception.
 * The exception when have any error with launch.
 *
 * @since 1.0
 * @author Leanfe
 */
public class StartException extends RuntimeException {

    /**
     * Throws when there is any error at startup.
     */
    public StartException() {
        super("MINECRAFT CLASS OBJECT = NULL!!!!");
    }
}
