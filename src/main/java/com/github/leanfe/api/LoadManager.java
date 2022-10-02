package com.github.leanfe.api;

import com.github.leanfe.api.exceptions.AgentException;
import net.bytebuddy.agent.ByteBuddyAgent;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
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
     * The method of loading the main class of the game.
     *
     * @param myJar     The path to the minecraft jar file.
     * @param className The name of the main class to load from the JAR class.
     * @throws ClassNotFoundException    The class not found exception.
     * @throws NoSuchMethodException     The no such method exception.
     * @throws InstantiationException    The instantiation exception.
     * @throws IllegalAccessException    The illegal access exception.
     * @throws InvocationTargetException The invocation target exception.
     * @throws MalformedURLException     Error loading the file URL.
     */
    protected Object loadMainJar(File myJar, String className)
            throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, MalformedURLException {
        URLClassLoader child = new URLClassLoader(
                new URL[] {
                        myJar.toURI().toURL()
                },
                this.getClass().getClassLoader()
        );
        Class<?> classToLoad = Class.forName(className, true, child);
        return classToLoad.newInstance();
    }

    /**
     * The method for load any jar file in folder.
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
     * @param minecraftClassName The name of the main minecraft class.
     * @throws IOException Error opening the directory.
     * @throws AgentException An exception that is thrown when an agent error occurs. See {@link com.github.leanfe.api.LoadManager#loadJar(File)}
     *
     * @return Minecraft main class object.
     */
    public Object load(String dllPath, String pathJar, String minecraftJar, String minecraftClassName) throws IOException, AgentException {
        loadDll(dllPath);
        Object obj = null;
        try {
            obj = loadMainJar(new File(minecraftJar), minecraftClassName);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Error loading the minecraft class!");
        }

        for (File file : Objects.requireNonNull(new File(pathJar).listFiles())) {
            if (file.getName().endsWith(".jar")) {
                loadJar(file);
            }
        }
        return Objects.requireNonNull(obj);
    }

}
