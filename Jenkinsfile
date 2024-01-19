pipeline {
    agent { label 'slave1' } 
    stages {
        stage('checkout') {
            steps {
		sh 'rm -rf bus_booking'
                sh 'git clone https://github.com/sanjay0288/Parcel-service.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    sh 'mvn --version'
                    sh 'mvn clean install'
                }
            }
        }
	stage('Run JAR Locally') {
            steps {
                script {
                    // Run the JAR file using java -jar
                    sh "nohup timeout 10s java -jar target/simple-parcel-service-app-1.0-SNAPSHOT.jar> output.log 2>&1 &"
                    // Sleep for a while to allow the application to start (adjust as needed)
                    sleep 10
                }
            }
        }
        stage('Deploy to Tomcat') {
            steps {
                script {
                    def serverUrl = "35.154.163.101:8081"
                    def username = "sanj"
                    def password = "sanj"
                    def warFileName = "simple-parcel-service-app-1.0-SNAPSHOT.jar"
                    def warFilePath = "/home/slave1/workspace/parcel_service_feature-1/target/simple-parcel-service-app-1.0-SNAPSHOT.jar"
		    sh 'ssh root@172.31.15.207'
		    sh "scp warFilePath root@172.31.15.207:/opt/apache-tomcat-8.5.98/webapps/"
                }
            }
        }
    }
}
