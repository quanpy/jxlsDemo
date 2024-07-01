plugins {
    java
    id("org.springframework.boot") version "3.1.11"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-logging")

    // https://mvnrepository.com/artifact/org.jxls/jxls-poi
    implementation("org.jxls:jxls-poi:3.0.0")
    // jxls-poi 包含 jxls 和 poi
//    implementation("org.jxls:jxls:3.0.0")
    implementation("org.jxls:jxls-reader:2.1.0")

// lombok 必须在 mapstruct 之前
    compileOnly("org.projectlombok:lombok")

    testCompileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootBuildImage {
    builder.set("paketobuildpacks/builder-jammy-base:latest")
}
