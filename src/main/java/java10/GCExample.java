package java10;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

public class GCExample {
    public static void main(String[] args) {
        for (GarbageCollectorMXBean gcBean : ManagementFactory.getGarbageCollectorMXBeans()) {
            System.out.println("Name: " + gcBean.getName());
            System.out.println("Number of Collections: " + gcBean.getCollectionCount());
            System.out.println("Collection Time (ms): " + gcBean.getCollectionTime());
        }
    }
}

/*
Name: G1 Young Generation
Number of Collections: 12
Collection Time (ms): 103


Java 10 introduced the GarbageCollectorMXBean interface, allowing you to easily manage and retrieve information about garbage collectors in the JVM.
*/