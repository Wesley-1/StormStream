dependencies {
    implementation("org.springframework.kafka:spring-kafka:3.2.4")
    implementation("org.springframework.cloud:spring-cloud-stream:4.1.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.11.1")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.4")
    implementation("org.springframework.data:spring-data-jpa:3.3.4")
    implementation("org.springframework.boot:spring-boot-starter-web:3.3.4")
    implementation(project(":commons"))
}