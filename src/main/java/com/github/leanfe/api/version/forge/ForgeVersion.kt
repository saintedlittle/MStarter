package com.github.leanfe.api.version.forge

import com.github.leanfe.api.version.Version

/**
 * The Forge version type.
 * Used to create and use versions of Forge.
 *
 * @author Leanfe
 * @since 2.0
 */
class ForgeVersion(name: String?, pathDll: String?, pathJAR: String?, minecraftJarfileName: String?) : Version(name, pathDll, pathJAR, minecraftJarfileName) {
    /**
     * The Forge Version constructor.
     *
     * @param name                 the name of folder with version.
     * @param pathDll              the path to all dll-files.
     * @param pathJAR              the path to all jar-files.
     * @param minecraftJarfileName the minecraft jarfile name.
     */
    init {
        setBaseArgs(args)
    }

    /**
     * Set base arguments.
     * @param args - List of arguments.
     * @return instance of version.
     */
    override fun setBaseArgs(args: ArrayList<String>): Version {
        args.add(" --version " + name)
        args.add(" --assetIndex " + name)
        args.add(" --tweakClass net.minecraftforge.fml.common.launcher.FMLTweaker")
        args.add(" --versionType Forge")
        args.add(" --userProperties {}")
        return this
    }
}