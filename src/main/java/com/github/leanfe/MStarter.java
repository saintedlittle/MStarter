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
                    "=== \033[1mMStartLibrary\033[0m === \n",
                    "> \033[1mGitHub: https://github.com/Leanfe/MStarter\033[0m \n",
                    "> \033[1mCopyright 2022©\033[0m\n",
                    "===================== \n"
            };

    /**
     * Main function.
     *
     * @param args - program argument.
     */
    public static void main(String[] args) {
        for (String s : message) {
            System.out.print(s);
        }

    }
}
