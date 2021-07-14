plugins {
    id("dev.petuska.npm.publish") version "2.0.3"
    kotlin("multiplatform") version "1.5.20"
    kotlin("plugin.serialization") version "1.5.20"
}

val ktor_version = "1.5.4"
group = "tiny.angry.kitten"
version = "1.0.0"

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
            name = "@tinyangrykitten/simplebankclient"
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

npmPublishing {
    repositories {
        repository("githubnpm") {
            registry = uri("https://npm.pkg.github.com")
            authToken = System.getenv("auth")
            organization="tinyangrykitten"
        }
    }

    publications {
        publication("gitNpmPublication") {
            moduleName="simplebankclient"
        }
    }
}