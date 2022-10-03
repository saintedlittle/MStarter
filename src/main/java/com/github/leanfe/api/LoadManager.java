package com.github.leanfe.api;

import com.github.leanfe.api.exceptions.AgentException;
import net.bytebuddy.agent.ByteBuddyAgent;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * A manager class that loads DLL and JAR files.
 * This is a class that contains functions and mechanisms for loading DLL and .JAD files required for Minecraft.
 * @since 1.0
 *
 * @author Leanfe
 */
public class LoadManager {

    /**
     * This field contains the path to the jar agent required by ByteBuddy.
     */
    protected final File AGENT_JAR;

    /**
     * The basic constructor of the class.
     *
     * @param AGENT_JAR the path to the jar agent required by ByteBuddy.
     */
    public LoadManager(File AGENT_JAR) {

        this.AGENT_JAR = AGENT_JAR;
    }

    /**
     * @throws IOException A terrible mistake has occurred.
     */
    protected void loadDll(String path) throws IOException {
        try {
            Field field = ClassLoader.class.getDeclaredField("usr_paths");
            field.setAccessible(true);
            String[] paths = (String[])field.get(null);
            for (String s : paths) {
                if (path.equals(s)) {
                    return;
                }
            }
            String[] tmp = new String[paths.length+1];
            System.arraycopy(paths,0,tmp,0,paths.length);
            tmp[paths.length] = path;
            field.set(null,tmp);
            System.setProperty("java.library.path", System.getProperty("java.library.path") + File.pathSeparator + path);
        } catch (IllegalAccessException e) {
            throw new IOException("Failed to get permissions to set library path");
        } catch (NoSuchFieldException e) {
            throw new IOException("Failed to get field handle to set library path");
        }
    }

    /**
     * The method for load any jar file.
     * @param myJar The path to .JAR file to load to the JVM.
     * @throws AgentException An exception that is thrown when an agent error occurs. See {@link com.github.leanfe.api.exceptions.AgentException}
     */
    protected void loadJar(File myJar) throws AgentException {
        try {
            ByteBuddyAgent.attach(AGENT_JAR, String.valueOf(ProcessHandle.current().pid()), myJar.getPath());
        } catch (IllegalStateException e) {
            throw new AgentException("\033[1m;31mAn error occurred while loading the JAR file!\033[0m \n " +
                    "\033[31mJAR FILE: " + myJar.getName() + " !!!\033[0m");
        }
    }

    /**
     * The method for load all DLL and .jar files needed for start a minecraft.
     *
     * @param dllPath The path to all .dll files for minecraft.
     * @param pathJar The path to all .jar files for minecraft.
     * @param minecraftJar The path to .jar file minecraft.
     * @throws IOException Error opening the directory.
     * @throws AgentException An exception that is thrown when an agent error occurs. See {@link com.github.leanfe.api.LoadManager#loadJar(File)}
     *
     */
    public void load(String dllPath, String pathJar, String minecraftJar) throws IOException, AgentException {
        loadDll(dllPath);

        loadJar(new File(minecraftJar));

        for (File file : Objects.requireNonNull(new File(pathJar).listFiles())) {
            if (file.getName().endsWith(".jar")) {
                loadJar(file);
            }
        }

    }

}
