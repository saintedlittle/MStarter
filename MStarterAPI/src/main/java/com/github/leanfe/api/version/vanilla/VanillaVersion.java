package com.github.leanfe.api.version.vanilla;

import com.github.leanfe.api.version.Version;

/**
 * The Vanilla version type.
 * Used to create and use versions of Vanilla.
 *
 * @author Leanfe
 * @since 2.0
 */
public class VanillaVersion extends Version {

    /**
     * The Vanilla Version constructor.
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
