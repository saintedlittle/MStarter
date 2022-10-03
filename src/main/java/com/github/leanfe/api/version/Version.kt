package com.github.leanfe.api.version

import net.minecraft.client.main.Main
import java.io.File

/**
 * The Version type.
 * An abstract version class that contains a basic implementation.
 *
 * @since 1.0
 * @author Leanfe
 */
abstract class Version
/**
 * The Version constructor.
 *
 * @param name                 the name of folder with version.
 * @param pathDll              the path to all dll-files.
 * @param pathJAR              the path to all jar-files.
 * @param minecraftJarfileName the minecraft jarfile name.
 */
protected constructor(
        /**
         * Contains the name of the version.
         */
        var name: String,
        /**
         * Contains the path to the folder with natives.
         */
        var pathDll: String?,
        /**
         * Contains the path to the folder with jar files.
         */
        var pathJar: String?,
        /**
         * Contains the name of the minecraft jar file.
         */
        var minecraftJarfileName: String?) : IVersion {

    protected var args = ArrayList<String?>()

    @Deprecated("", ReplaceWith("0"))
    override fun load(): Int {
        return 0
    }

    /**
     * Adds an argument to the list, which will then be passed to the main method.
     * @param value The argument for Minecraft that will be passed to it. See [GitHub](https://github.com/Leanfe/MStarter)
     *
     * @since 2.0 -> Use a default method for every operation.
     */
    @Deprecated("", ReplaceWith("args.add(value)"))
    override fun addArgument(value: String?) {
        args.add(value)
    }

    /**
     * Just launches the main class from a tightened jar.
     * @return stream, with the application running.
     */
    override fun start(): Thread? {
        val runnable = Runnable { Main.main(args.toTypedArray()) }
        val thread = Thread(runnable, "Instance with args")
        thread.start()
        return thread
    }

    /**
     * Set base arguments.
     * @param args List of arguments.
     * @return instance of version.
     */
    protected open fun setBaseArgs(args: ArrayList<String?>): Version? {
        args.add(" --version $name")
        args.add(" --assetIndex $name")
        args.add(" --versionType release")
        args.add(" --userProperties {}")
        return this
    }

    /**
     * Set player info.
     * @param username username.
     * @param UUID player uuid.
     * @return instance of version.
     */
    fun settingPlayer(username: String, UUID: String): Version {
        args.add(" --username $username")
        args.add(" --uuid $UUID")
        args.add(" --userType legacy")
        return this
    }

    /**
     * Change default run directory.
     * @param path path to new dir.
     * @return instance of version.
     */
    fun setDirectory(path: File): Version {
        args.add(" --gameDir " + path.absolutePath)
        args.add(" --assetsDir " + path + File.separator + "assets")
        return this
    }

    /**
     * Change default width.
     * @param width new width.
     * @return instance of version.
     */
    fun setWidth(width: String): Version {
        args.add(" --width $width")
        return this
    }

    /**
     * Change default height.
     * @param height new height.
     * @return instance of version.
     */
    fun setHeight(height: String): Version {
        args.add(" --height $height")
        return this
    }

    /**
     * Set server to connect.
     * @param server IP/domain
     * @param port PORT
     * @return instance of version.
     */
    fun setServer(server: String, port: String): Version {
        args.add(" --server $server")
        args.add(" --port $port")
        return this
    }

    /**
     * Set server to connect.
     * @param domain domain.
     * @return instance of version.
     */
    fun setServer(domain: String): Version {
        args.add(" --server $domain")
        return this
    }

    /**
     * Set demo for game.
     * @param demo true/false.
     * @return instance of version.
     */
    fun setDemo(demo: Boolean): Version {
        if (demo) args.add(" --demo")
        return this
    }
}