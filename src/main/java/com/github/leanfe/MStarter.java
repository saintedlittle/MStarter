package com.github.leanfe;

/**
 * Dummy class.
 * The simplest class that performs the function of showing a HELP message at startup JAR. <a href="https://github.com/Leanfe/MStarter">GitHub</a>
 *
 * @author Leanfe
 */
public class MStarter {

    private final static String[] message =
            {
             "\033[31m In general, this is a library for launching minecraft, \033[0m",
             "\033[31m but since you have launched it, \033[0m",
             "\033[1m then here is below HELP for the minecraft command line arguments. \033[0m",
             "        \033[1mArguments for working with memory. \033[0m \n" +
                     "        ==================================",
                    """
                            -Xmx

                            -Xms

                            -Xmn

                            -XX:HeapDumpPath=MojangTricksIntelDriversForPerformance_javaw.exe_minecraft.exe.heapdump""".indent(8),
             "        \033[1mThe main arguments to run. \033[0m\n" +
                     "        ==========================",
                    """

                            -Djava.library.path=C:Usersnov11AppDataRoaming/.minecraft/versions/1.12.2/natives (папка с native (dll))

                            -cp (прямые пути до джарников)

                            net.minecraft.launchwrapper.Launch (Это надо передать как отдельный параметр перед всем этим дерьмом, так как это класс для запуска самого инициализатора.

                            --height 480
                             --width 854

                             --gameDir C:\\Usersnov11\\AppData\\Roaming/.minecraft

                             --version 1.12.2-forge1.12.2-14.23.5.2775

                             --assetsDir C:\\Usersnov11\\AppData\\Roaming/.minecraft/assets

                             --assetIndex 1.12""".indent(8),
             "        \033[1mACCOUNT \033[0m\n" +
                     "        =======",
                    """

                            --username ISHIKAWA

                            --userType mojang

                            --accessToken aeef7bc935f9420eb6314dea7ad7e1e5

                            --uuid NULL""".indent(8),
             "        \033[1mFORGE \033[0m\n" +
                     "        =====",
                    """

                            --versionType net.minecraftforge.fml.common.launcher.FMLTweaker

                            --tweakClass Forge""".indent(8)
            };

    /**
     * Main function.
     *
     * @param args - program argument.
     */
    public static void main(String[] args) {
        System.out.println("\033[1m Hello, sir! \033[0m");
        for (String s : message) {
            System.out.println(s);
        }
    }
}
