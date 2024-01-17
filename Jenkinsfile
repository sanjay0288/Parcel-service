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
                    def username = "sanj"
                    def password = "sanj"
                    def warFileName = "sample.war"

                    sh "curl -v --user ${username}:${password} --upload-file ${warFileName} ${serverUrl}/manager/text/deploy?path=/${warFileName}"
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
