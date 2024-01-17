# mvn clean install 
# mvn spring-boot:run

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    def mvnHome = tool 'Maven'
                    def mvnCMD = "${mvnHome}/bin/mvn"

                    sh "${mvnCMD} clean install"
                }
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                script {
                    def serverUrl = "http://13.233.140.100:8081/"
                    def username = "sanjay"
                    def password = "sanjay"
                    def warFileName = "Parcel.war"

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
