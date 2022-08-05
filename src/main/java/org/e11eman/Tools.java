package org.e11eman;

public class Tools {
    public static void log(String args) {
        System.out.println(args);
    }

    public static String runGC() {
        Runtime runtime = Runtime.getRuntime();
        long memoryMax = runtime.maxMemory();
        long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        double memoryUsedPercent = (memoryUsed * 100.0) / memoryMax;
        if (memoryUsedPercent > 98.0) {
            System.gc();
        }
        return "Used memory: " + memoryUsedPercent;
    }
}
