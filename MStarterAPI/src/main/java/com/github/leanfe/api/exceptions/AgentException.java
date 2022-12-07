package com.github.leanfe.api.exceptions;

/**
 * Agent Exception.
 * The Exception if ByteBuddy Agent is NULL.
 *
 * @since 1.0
 * @author Leanfe
 */
public class AgentException extends Exception {

    /**
     * Throws an exception that the ByteBuddy agent is NULL!
     */
    public AgentException() {
        super("Mistake!!! ByteBuddy agent -> NULL!");
    }

    /**
     * Throws an exception that the ByteBuddy agent could not load the JAR file!
     *
     * @param message An error message that contains the name of the JAR file.
     */
    public AgentException(String message) {
        super(message);
    }
}
