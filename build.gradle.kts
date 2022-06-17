import com.github.gradle.node.npm.task.NpmTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.github.node-gradle.node") version "3.3.0"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    kotlin("plugin.jpa") version "1.6.10"
}

group = "college.app"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-mustache")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}

//tasks.register<NpmTask>("appNpmInstall") {
//    description = "Installs all dependencies from package.json"
//    workingDir.set(file("${project.projectDir}/src/main/frontend/colley-frontend"))
//    npmCommand.set(listOf("install"))
//}

tasks.npmInstall {
    nodeModulesOutputFilter {
        exclude("notExistingFile")
    }
}

tasks.register<NpmTask>("appNpmBuild") {
//    dependsOn("appNpmInstall")
    description = "Builds project"
    workingDir.set(file("${project.projectDir}/src/main/frontend/colley-frontend"))
    npmCommand.set(listOf("run", "build"))
}

tasks.register<Copy>("copyWebApp") {
    dependsOn("appNpmBuild")
    description = "Copies built project to where it will be served"
    from("src/main/frontend/colley-frontend/build")
    into("build/resources/main/static/.")
}

node {
    download.set(false)
    // Set the work directory for unpacking node
    workDir.set(file("${project.buildDir}/nodejs"))
    // Set the work directory for NPM
    npmWorkDir.set(file("${project.buildDir}/npm"))
}

tasks.withType<KotlinCompile> {
    dependsOn("copyWebApp")
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}