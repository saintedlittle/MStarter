package com.github.leanfe.api

import com.github.leanfe.api.exceptions.AgentException
import net.bytebuddy.agent.ByteBuddyAgent
import java.io.File
import java.io.IOException
import java.util.*

/**
 * A manager class that loads DLL and JAR files.
 * This is a class that contains functions and mechanisms for loading DLL and .JAD files required for Minecraft.
 * @since 1.0
 *
 * @author Leanfe
 */
open class LoadManager
/**
 * The basic constructor of the class.
 *
 * @param AGENT_JAR the path to the jar agent required by ByteBuddy.
 */(
        /**
         * This field contains the path to the jar agent required by ByteBuddy.
         */
        private val AGENT_JAR: File) {
    /**
     * @throws IOException A terrible mistake has occurred.
     */
    @Throws(IOException::class)
    protected fun loadDll(path: String) {
        try {
            val field = ClassLoader::class.java.getDeclaredField("usr_paths")
            field.isAccessible = true
            val paths = field[null] as Array<*>
            for (s in paths) {
                if (path == s) {
                    return
                }
            }
            val tmp = arrayOfNulls<String>(paths.size + 1)
            System.arraycopy(paths, 0, tmp, 0, paths.size)
            tmp[paths.size] = path
            field[null] = tmp
            System.setProperty("java.library.path", System.getProperty("java.library.path") + File.pathSeparator + path)
        } catch (e: IllegalAccessException) {
            throw IOException("Failed to get permissions to set library path")
        } catch (e: NoSuchFieldException) {
            throw IOException("Failed to get field handle to set library path")
        }
    }

    /**
     * The method for load any jar file.
     * @param myJar The path to .JAR file to load to the JVM.
     * @throws AgentException An exception that is thrown when an agent error occurs. See [com.github.leanfe.api.exceptions.AgentException]
     */
    @Throws(AgentException::class)
    protected fun loadJar(myJar: File) {
        try {
            ByteBuddyAgent.attach(AGENT_JAR, ProcessHandle.current().pid().toString(), myJar.path)
        } catch (e: IllegalStateException) {
            throw AgentException("""[1m;31mAn error occurred while loading the JAR file![0m 
 [31mJAR FILE: ${myJar.name} !!![0m""")
        }
    }

    /**
     * The method for load all DLL and .jar files needed for start a minecraft.
     *
     * @param dllPath The path to all .dll files for minecraft.
     * @param pathJar The path to all .jar files for minecraft.
     * @param minecraftJar The path to .jar file minecraft.
     * @throws IOException Error opening the directory.
     * @throws AgentException An exception that is thrown when an agent error occurs. See [com.github.leanfe.api.LoadManager.loadJar]
     */
    @Throws(IOException::class, AgentException::class)
    fun load(dllPath: String, pathJar: String?, minecraftJar: String?) {
        loadDll(dllPath)
        loadJar(File(minecraftJar!!))
        for (file in Objects.requireNonNull(pathJar?.let { File(it).listFiles() })) {
            if (file.name.endsWith(".jar")) {
                loadJar(file)
            }
        }
    }
}