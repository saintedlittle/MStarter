package com.github.leanfe.api.version.vanilla;

import com.github.leanfe.api.version.Version;

public class VanillaVersion extends Version {

    /**
     * The Version constructor.
     *
     * @param name                 the name of folder with version.
     * @param pathDll              the path to all dll-files.
     * @param pathJAR              the path to all jar-files.
     * @param minecraftJarfileName the minecraft jarfile name.
     */
    public VanillaVersion(String name, String pathDll, String pathJAR, String minecraftJarfileName) {
        super(name, pathDll, pathJAR, minecraftJarfileName);
        setBaseArgs(args);
    }
}
