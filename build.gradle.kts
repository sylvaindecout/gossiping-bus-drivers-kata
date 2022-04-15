val jvm_version: String by project
val junit_version: String by project
val pitest_junit5_plugin_version: String by project
val strikt_version: String by project
val documentation_annotations_version: String by project

plugins {
    kotlin("jvm") version "1.6.20"
    id("info.solidsoft.pitest") version "1.7.0"
}

group = "fr.sdecout.gossip"
version = "1.0.0"

repositories {
    jcenter()
    maven {
        url = uri("https://maven.pkg.github.com/sylvaindecout/documentation-annotations")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
        }
    }
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("fr.sdecout.annotations", "documentation-annotations", documentation_annotations_version)

    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter", "junit-jupiter-api", junit_version)
    testImplementation("org.junit.jupiter", "junit-jupiter-params", junit_version)
    testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine", junit_version)

    testImplementation(platform("io.strikt:strikt-bom:$strikt_version"))
    testImplementation("io.strikt", "strikt-core")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = jvm_version
        }
    }
    compileTestKotlin {
        kotlinOptions{
            jvmTarget = jvm_version
        }
    }
    test {
        useJUnitPlatform()
    }
    pitest {
        junit5PluginVersion.set(pitest_junit5_plugin_version)
        outputFormats.add("HTML")
        excludedGroups.add("Integration")
        targetClasses.set(listOf("fr.sdecout.gossip.*"))
    }
}
