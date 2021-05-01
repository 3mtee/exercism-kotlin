import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

version = "1.0-SNAPSHOT"
group = "org.painsomnia"

plugins {
    kotlin("jvm") apply false
}

subprojects {
    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            useIR = true
        }
    }
}

gradle.buildFinished {
    project.buildDir.deleteRecursively()
}
