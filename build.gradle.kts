plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.20"
    application
    antlr
}

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.9.3")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

application {
    mainClass.set("MainKt")
}

tasks.compileKotlin {
    dependsOn(tasks.generateGrammarSource)
}
