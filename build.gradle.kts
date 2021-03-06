plugins {
    kotlin("multiplatform") version "1.5.20"
    kotlin("plugin.serialization") version "1.5.20"
    id("maven-publish")
}

val ktor_version = "1.5.4"
group = "tiny.angry.kitten"
version = "1.0.${System.getenv("RUN_NUMBER") ?: 10}"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }
    js(IR) {
        binaries.library()
        useCommonJs()
        moduleName = "SimpleBankClient"
        compilations["main"].packageJson {
            customField("repository", "git://github.com/tinyangrykitten/SimpleBankClient.git")
            private = false
            name = "tinyangrykitten-simplebankclient"
        }
        nodejs {}
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:$ktor_version")
                implementation("io.ktor:ktor-client-serialization:$ktor_version")

                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-cio:$ktor_version")
            }
        }
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:$ktor_version")
            }
        }
        val jsTest by getting
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/TinyAngryKitten/SimpleBankClient")
            credentials {
                username = "TinyAngryKitten"
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }

    publications {
        create<MavenPublication>("maven") {
            groupId = "tiny.angry.kitten"
            artifactId = "simplebankclient"
            version = "1.0.${System.getenv("RUN_NUMBER") ?: 4}"
        }
    }
}