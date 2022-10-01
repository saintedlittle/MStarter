package com.github.leanfe.api;

import java.util.ArrayList;

/**
 * ENUM with versions to run.
 *
 * @author Leanfe This is an enum with versions. The shell for use is located here. About the work of the class - see <a href="https://github.com/Leanfe/MStarter">GitHub</a>
 */
public enum Version {

    /**
        Below are the versions that are available to run.
        Please note that FORGE is not supposed to be here. It will be added as a separate type in future versions.
     */

    /**
     * VERSION 1_8
     */
    VERSION_1_8 {
        
        private ArrayList<String> args = new ArrayList<>();
        
        @Override
        public int load() {
            return 0;
        }

        @Override
        public void addArgument(String value) {
        }

        @Override
        public void start() {

        }
    },

    /**
     * VERSION 1_9
     */
    VERSION_1_9 {
        
        private ArrayList<String> args = new ArrayList<>();

        @Override
        public int load() {
            return 0;
        }

        @Override
        public void addArgument(String value) {

        }

        @Override
        public void start() {

        }
    },

    /**
     * VERSION 1_10
     */
    VERSION_1_10 {

        private ArrayList<String> args = new ArrayList<>();

        @Override
        public int load() {
            return 0;
        }

        @Override
        public void addArgument(String value) {

        }

        @Override
        public void start() {

        }
    },

    /**
     * VERSION 1_11
     */
    VERSION_1_11 {

        private ArrayList<String> args = new ArrayList<>();

        @Override
        public int load() {
            return 0;
        }

        @Override
        public void addArgument(String value) {

        }

        @Override
        public void start() {

        }
    },

    /**
     * VERSION 1_12
     */
    VERSION_1_12 {

        private ArrayList<String> args = new ArrayList<>();

        @Override
        public int load() {
            return 0;
        }

        @Override
        public void addArgument(String value) {

        }

        @Override
        public void start() {

        }
    },

    /**
     * VERSION 1_13
     */
    VERSION_1_13 {

        private ArrayList<String> args = new ArrayList<>();

        @Override
        public int load() {
            return 0;
        }

        @Override
        public void addArgument(String value) {

        }

        @Override
        public void start() {

        }
    },

    /**
     * VERSION 1_14
     */
    VERSION_1_14 {

        private ArrayList<String> args = new ArrayList<>();

        @Override
        public int load() {
            return 0;
        }

        @Override
        public void addArgument(String value) {

        }

        @Override
        public void start() {

        }
    },

    /**
     * VERSION 1_15
     */
    VERSION_1_15 {

        private ArrayList<String> args = new ArrayList<>();

        @Override
        public int load() {
            return 0;
        }

        @Override
        public void addArgument(String value) {

        }

        @Override
        public void start() {

        }
    },

    /**
     * VERSION 1_16
     */
    VERSION_1_16 {

        private ArrayList<String> args = new ArrayList<>();

        @Override
        public int load() {
            return 0;
        }

        @Override
        public void addArgument(String value) {

        }

        @Override
        public void start() {

        }
    },

    /**
     * VERSION 1_17
     */
    VERSION_1_17 {

        private ArrayList<String> args = new ArrayList<>();

        @Override
        public int load() {
            return 0;
        }

        @Override
        public void addArgument(String value) {

        }

        @Override
        public void start() {

        }
    },

    /**
     * VERSION 1_18
     */
    VERSION_1_18 {

        private ArrayList<String> args = new ArrayList<>();

        @Override
        public int load() {
            return 0;
        }

        @Override
        public void addArgument(String value) {
        }

        @Override
        public void start() {

        }
    },

    /**
     * VERSION 1_19
     */
    VERSION_1_19 {

        private ArrayList<String> args = new ArrayList<>();

        @Override
        public int load() {
            return 0;
        }

        @Override
        public void addArgument(String value) {
        }

        @Override
        public void start() {

        }

    };

    /**
     * The method is needed to move .dll files in the folder with the JRE,
     * and also connects the JAR file of the version to the application.
     *
     * @return status code.
     */
    public abstract int load();

    /**
     * Add argument.
     *
     * @param value The argument for Minecraft that will be passed to it. See GitHub
     */
    public abstract void addArgument(String value);

    /**
     * The method performs the simplest function.
     * Just launches the main class from a tightened jar.
     */
    public abstract void start();
}
