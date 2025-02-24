plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "ru.labirint.muratov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.11.3"
val assertjVersion = "3.26.3"
val allureVersion = "2.28.1"
val aspectjweaverVersion = "1.9.22"
val selenideVersion = "7.4.0"
val lombokVersion = "1.18.32"
val restAssuredVersion = "5.5.0"
val jacksonVersion = "2.15.2"

dependencies {
    // JUnit - core test framework
    implementation(platform("org.junit:junit-bom:$junitVersion"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("org.junit.jupiter:junit-jupiter-engine")
    implementation("org.junit.jupiter:junit-jupiter-api")
    implementation("org.junit.jupiter:junit-jupiter-params")
    // Assertions library
    implementation("org.assertj:assertj-core:$assertjVersion")
    // Allure support for JUnit5
    implementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
    implementation("io.qameta.allure:allure-junit5")
    implementation("io.qameta.allure:allure-rest-assured")
    implementation("io.qameta.allure:allure-selenide")
    implementation("org.aspectj:aspectjweaver:$aspectjweaverVersion")
    // UI testing core library
    implementation("com.codeborne:selenide:$selenideVersion")
    // Lombok - no boilerplate code
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    testCompileOnly("org.projectlombok:lombok:$lombokVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")

    // Additional dependencies
    implementation("io.rest-assured:rest-assured:$restAssuredVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    implementation("com.github.javafaker:javafaker:1.0.2")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    jvmArgs = listOf("-Dfile.encoding=UTF-8", "-Xmx2g", "-Xms1g")

        useJUnitPlatform { }
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
