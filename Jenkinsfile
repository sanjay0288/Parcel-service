pipeline {
    agent { label 'Slave1' } 
stages {
stage('checkout') {
            steps {
                sh 'rm -rf hello-world-war'
                sh 'git clone -b feature-1 https://github.com/sanjay0288/Parcel-service.git'
            }
        }
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
                def jarFileName = "weather-forecast-app-1.0-SNAPSHOT.jar"

                sh "curl -v --user ${username}:${password} --upload-file target/${jarFileName} ${serverUrl}/manager/text/deploy?path=/${jarFileName}"
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
