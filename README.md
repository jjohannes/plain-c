# Plain C - Gradle plugin

For customized **C** development with Gradle. This is to demonstrate current shortcomings of Gradle in this area.

```
plugins {
    id("software.onepiece.plain-c")
}

// The plugin provides the 'plainc' extension that allows you to register Gradle core tasks for 
// compiling/linking/assembling C code directly, providing them with the a local executable or 
// an executable available in a repository.

tasks.register<CCompile>("compileC") {
    group = "mytasks"
    toolChain.set(plainc.localTool("14.0.0", "/usr/bin/clang", ".o"))
    targetPlatform.set(plainc.platform())

    source(layout.projectDirectory.files("src/c").asFileTree)
    includes(layout.projectDirectory.files("src/headers"))
    compilerArgs.add("-S")

    objectFileDir.set(layout.buildDirectory.dir("out/o"))
}

val compileC2 = tasks.register<CCompile>("compileC2") {
    group = "mytasks"
    toolChain.set(plainc.repositoryTool("com.example", "vendor-x", "1.2", "bin/xcc", ".src"))
    targetPlatform.set(plainc.platform())

    source(layout.projectDirectory.files("src/c-special").asFileTree)
    includes(layout.projectDirectory.files("src/headers"))

    objectFileDir.set(layout.buildDirectory.dir("out/src"))
}

tasks.register<Assemble>("assemble") {
    group = "mytasks"
    toolChain.set(plainc.repositoryTool("com.example", "vendor-x", "1.2", "bin/xas", ".o"))
    targetPlatform.set(plainc.platform())

    source(compileC2.map { it.objectFileDir.asFileTree })
    includes(layout.projectDirectory.files("src/headers"))
    assemblerArgs = listOf("-D")

    objectFileDir = layout.buildDirectory.dir("out/o2").get().asFile
}
```

⚠️ _This is work in progress_ ⚠️
