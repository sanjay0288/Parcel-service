pipeline {
    agent any

    stages {
        stage('Checkout') {
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
                    def warFileName = "target/Parcel-service.war"
                    def tomcatDir = "/opt/apache-tomcat-10.1.24"

                    sh "cp ${warFileName} ${tomcatDir}/webapps/"
                    sh "${tomcatDir}/bin/shutdown.sh"
                    sleep 5 
                    sh "${tomcatDir}/bin/startup.sh"
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
