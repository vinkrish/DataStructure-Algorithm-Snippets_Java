### Packaging Tool 

Java 16 introduced a new packaging tool that allows you to package Java applications into platform-specific installable formats like .msi on Windows or .pkg on macOS. 

Following command packages a Java application into an installable .pkg file on macOS.

```
$ jpackage --name MyApp --input target/ --main-jar MyApp.jar --type pkg
```

### Strong Encapsulation of JDK Internals

Java 16 makes strong encapsulation of JDK internals the default, meaning internal APIs are no longer accessible unless explicitly allowed.

```
--illegal-access=permit
```