package com.github.leanfe.api.version.forge;

import com.github.leanfe.api.version.Version;

import java.util.ArrayList;

public class ForgeVersion extends Version {

    /**
     * The Forge Version constructor.
     *
     * @param name                 the name of folder with version.
     * @param pathDll              the path to all dll-files.
     * @param pathJAR              the path to all jar-files.
     * @param minecraftJarfileName the minecraft jarfile name.
     */
    public ForgeVersion(String name, String pathDll, String pathJAR, String minecraftJarfileName) {
        super(name, pathDll, pathJAR, minecraftJarfileName);
        setBaseArgs(args);
    }

    @Override
    protected Version setBaseArgs(ArrayList<String> args) {
        args.add(" --version " + getName());
        args.add(" --assetIndex " + getName());
        args.add(" --tweakClass net.minecraftforge.fml.common.launcher.FMLTweaker");
        args.add(" --versionType Forge");
        args.add(" --userProperties {}");
        return this;
    }
}
