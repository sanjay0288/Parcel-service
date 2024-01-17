pipeline {
    agent { label 'Slave1' } 
    stages {
        stage('checkout') {
            steps {
                sh 'git clone -b feature-1 https://github.com/sanjay0288/Parcel-service.git'
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
        stage('Deploy to Tomcat') {
            steps {
                script {
                    def serverUrl = "http://13.233.140.100:8081/"
                    def username = "sanjay"
                    def password = "sanjay"
                    def warFileName = "hello-world-war-1.0.0.war"

                    sh "curl -v --user ${username}:${password} --upload-file target/${warFileName} ${serverUrl}/manager/text/deploy?path=/${warFileName}"
                }
            }
        }
    }

    post {
        success {
            echo "Deployment to Tomcat successful!"
        }
        failure {
            echo "Deployment to Tomcat failed!"
        }
    }
}
