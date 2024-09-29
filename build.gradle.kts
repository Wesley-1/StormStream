plugins {
	java
}

allprojects {
	group = "com.wtench"
	version = "1.0"

	apply(plugin = "java")
	apply(plugin = "java-library")
	apply(plugin = "application")

	repositories {
		mavenLocal()
		mavenCentral()
		maven("https://repo.spring.io/plugins-snapshot")
	}

	dependencies {
		compileOnly("org.projectlombok:lombok:1.18.32")
		annotationProcessor("org.projectlombok:lombok:1.18.32")
	}
}


