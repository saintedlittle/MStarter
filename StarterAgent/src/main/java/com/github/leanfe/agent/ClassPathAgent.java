package com.github.leanfe.agent;

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.util.jar.JarFile;

/**
 * ClassPathAgent.
 * The agent for ByteBuddy.
 *
 * @since 1.0
 * @author Leanfe
 */
public class ClassPathAgent {
    /**
     * Agent.
     *
     * @param args            the args
     * @param instrumentation the instrumentation.
     * @throws IOException any trobules with load.
     */
    public static void agentmain(String args, Instrumentation instrumentation) throws IOException {
        instrumentation.appendToSystemClassLoaderSearch(new JarFile(args));
    }
}