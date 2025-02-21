plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "ru.labirint.muratov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


val junitVersion = "5.11.2"
val assertjVersion = "3.26.3"
val allureVersion = "2.28.1"
val aspectjweaverVersion = "1.9.22"
val selenideVersion = "7.4.0"
val lombokVersion = "1.18.32"

dependencies {
    // JUnit - core test framework
    implementation(platform("org.junit:junit-bom:5.11.2"))
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