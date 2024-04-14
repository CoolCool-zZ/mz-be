import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
	kotlin("plugin.jpa") version "1.9.23"

	id("com.diffplug.spotless") version("6.25.0")
}

group = "coolcool"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-mysql")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
	kotlin {
		target("**/*.kt")
		targetExclude("${layout.buildDirectory}/**/*.kt")
		targetExclude("bin/**/*.kt")
		ktlint().editorConfigOverride(
				mapOf(
						"charset" to "utf-8",
						"end_of_line" to "lf",
						"insert_final_newline" to true,
						"indent_style" to "space",
						"indent_size" to 4,
						"trim_trailing_whitespace" to true,
						"ij_kotlin_allow_trailing_comma" to true,
						"ij_kotlin_allow_trailing_comma_on_call_site" to true,
				)
		)
	}
	format("misc") {
		target("*.gradle", "*.md", ".gitignore")
		trimTrailingWhitespace()
		indentWithTabs()
		endWithNewline()
	}

	java {
		target("**/*.java")
		targetExclude("${layout.buildDirectory}/**/*.java")
		targetExclude("bin/**/*.java")
		removeUnusedImports()
	}
	json {
		target("src/**/*.json")
		simple()
	}
}