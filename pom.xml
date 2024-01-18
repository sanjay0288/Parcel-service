<!-- /path/to/your/project/pom.xml -->
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
         
    <modelVersion>4.0.0</modelVersion>
    
    <groupId>com.example</groupId>
    <artifactId>simple-parcel-service-app</artifactId>
    <version>1.0-SNAPSHOT</version>
    
    <properties>
        <java.version>11</java.version>
        <spring.boot.version>2.5.4</spring.boot.version>
    </properties>

    <dependencies>
        <!-- Exclude the embedded Tomcat provided by Spring Boot -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <version>${spring.boot.version}</version>
            <scope>provided</scope>
        </dependency>
        
        <!-- Other dependencies... -->
    </dependencies>

    <build>
        <finalName>${project.artifactId}</finalName>
        <plugins>
            <!-- Disable the Spring Boot Maven Plugin -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>${spring.boot.version}</version>
                <configuration>
                    <skip>true</skip>
                </configuration>
            </plugin>
            
            <!-- Compile as a standard Java project -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                </configuration>
            </plugin>
        </plugins>
    </build>

    <!-- Packaging type is changed to 'war' -->
    <packaging>jar</packaging>

</project>
