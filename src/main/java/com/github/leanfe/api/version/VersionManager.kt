package com.github.leanfe.api.version

import com.github.leanfe.api.LoadManager
import com.github.leanfe.api.exceptions.AgentException
import com.github.leanfe.api.version.forge.ForgeVersionClasses
import com.github.leanfe.api.version.vanilla.VanillaVersionClasses
import java.io.File
import java.io.IOException

/**
 * Class for manage versions.
 * A class for working with versions. Load/launch.
 *
 * @since 1.0
 * @author Leanfe
 */
class VersionManager {
    /**
     * Stores the Loader Manager object.
     */
    private val loadManager: LoadManager
    /**
     * Returns the current version of minecraft.
     * @return Total version;
     */
    /**
     * Stores the current version.
     */
    private val totalVersion: Version

    /**
     * The status of the loaded version or not.
     */
    private var isLoaded = false

    /**
     * The basic constructor of the version manager.
     * @param type The type of Version. (Vanilla/Forge)
     * @param path_to_agent The path to the ByteBuddy agent.
     * @param version Version for load.
     */
    constructor(type: VersionsType, path_to_agent: String?, version: Versions?) {
        loadManager = path_to_agent?.let { File(it) }?.let { LoadManager(it) }!!
        totalVersion = if (type == VersionsType.VANILLA) {
            when (version) {
                Versions.VANILLA_VERSION_8 -> VanillaVersionClasses.VERSION_1_8("vanilla_native8", "jars", "version/minecraft.jar")
                Versions.VANILLA_VERSION_9 -> VanillaVersionClasses.VERSION_1_9("vanilla_native9", "jars", "version/minecraft.jar")
                Versions.VANILLA_VERSION_10 -> VanillaVersionClasses.VERSION_1_10("vanilla_native10", "jars", "version/minecraft.jar")
                Versions.VANILLA_VERSION_11 -> VanillaVersionClasses.VERSION_1_11("vanilla_native11", "jars", "version/minecraft.jar")
                Versions.VANILLA_VERSION_12 -> VanillaVersionClasses.VERSION_1_12("vanilla_native12", "jars", "version/minecraft.jar")
                Versions.VANILLA_VERSION_13 -> VanillaVersionClasses.VERSION_1_13("vanilla_native13", "jars", "version/minecraft.jar")
                Versions.VANILLA_VERSION_14 -> VanillaVersionClasses.VERSION_1_14("vanilla_native14", "jars", "version/minecraft.jar")
                Versions.VANILLA_VERSION_15 -> VanillaVersionClasses.VERSION_1_15("vanilla_native15", "jars", "version/minecraft.jar")
                Versions.VANILLA_VERSION_16 -> VanillaVersionClasses.VERSION_1_16("vanilla_native16", "jars", "version/minecraft.jar")
                Versions.VANILLA_VERSION_17 -> VanillaVersionClasses.VERSION_1_17("vanilla_native17", "jars", "version/minecraft.jar")
                Versions.VANILLA_VERSION_18 -> VanillaVersionClasses.VERSION_1_18("vanilla_native18", "jars", "version/minecraft.jar")
                Versions.VANILLA_VERSION_19 -> VanillaVersionClasses.VERSION_1_19("vanilla_native19", "jars", "version/minecraft.jar")
                else -> VanillaVersionClasses.VERSION_1_19("native19", "jars", "version/minecraft.jar")
            }
        } else {
            when (version) {
                Versions.FORGE_VERSION_8 -> ForgeVersionClasses.VERSION_1_8("forge_native8", "jars", "version/minecraft.jar")
                Versions.FORGE_VERSION_9 -> ForgeVersionClasses.VERSION_1_9("forge_native9", "jars", "version/minecraft.jar")
                Versions.FORGE_VERSION_10 -> ForgeVersionClasses.VERSION_1_10("forge_native10", "jars", "version/minecraft.jar")
                Versions.FORGE_VERSION_11 -> ForgeVersionClasses.VERSION_1_11("forge_native11", "jars", "version/minecraft.jar")
                Versions.FORGE_VERSION_12 -> ForgeVersionClasses.VERSION_1_12("forge_native12", "jars", "version/minecraft.jar")
                Versions.FORGE_VERSION_13 -> ForgeVersionClasses.VERSION_1_13("forge_native13", "jars", "version/minecraft.jar")
                Versions.FORGE_VERSION_14 -> ForgeVersionClasses.VERSION_1_14("forge_native14", "jars", "version/minecraft.jar")
                Versions.FORGE_VERSION_15 -> ForgeVersionClasses.VERSION_1_15("forge_native15", "jars", "version/minecraft.jar")
                Versions.FORGE_VERSION_16 -> ForgeVersionClasses.VERSION_1_16("forge_native16", "jars", "version/minecraft.jar")
                Versions.FORGE_VERSION_17 -> ForgeVersionClasses.VERSION_1_17("forge_native17", "jars", "version/minecraft.jar")
                Versions.FORGE_VERSION_18 -> ForgeVersionClasses.VERSION_1_18("forge_native18", "jars", "version/minecraft.jar")
                Versions.FORGE_VERSION_19 -> ForgeVersionClasses.VERSION_1_19("forge_native19", "jars", "version/minecraft.jar")
                else -> ForgeVersionClasses.VERSION_1_19("forge_native19", "jars", "version/minecraft.jar")
            }
        }
    }

    /**
     * The basic constructor of the version manager.
     * @param path_to_agent The path to the ByteBuddy agent.
     * @param version Version for load.
     */
    constructor(path_to_agent: String?, version: Version) {
        loadManager = path_to_agent?.let { File(it) }?.let { LoadManager(it) }!!
        totalVersion = version
    }

    /**
     * Uploads a specific version of minecraft to the JVM.
     * @param version The version to load.
     */
    fun loadVersion(version: Version) {
        if (!isLoaded) {
            try {
                loadManager.load(version.pathDll, version.pathJar, version.minecraftJarfileName)
            } catch (e: IOException) {
                throw RuntimeException(e)
            } catch (e: AgentException) {
                throw RuntimeException(e)
            }
        }
        isLoaded = true
    }

    fun startVersion(version: Version): Thread? {
        return version.start()
    }
}