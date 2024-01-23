pipeline {
    agent {
        label 'slave1'
    }

    stages {
        stage('checkout') {
            steps {
                sh 'rm -rf Parcel-service'
                sh 'git clone -b feature-2 https://github.com/sanjay0288/Parcel-service.git'
            }
        }

        stage('build') {
            steps {
                script {
                    sh 'mvn --version'
                    sh 'mvn clean package'
                }
            }
        }
        
      //  stage("SonarQube analysis") {
    //     steps {
      //          withSonarQubeEnv('sonar') {
        //            sh 'mvn clean package sonar:sonar'
          //    }
          //  }
       // }

        stage('Show Contents of target') {
            steps {
                script {
                    // Print the contents of the target directory
                    sh 'ls -l target'
                }
            }
        }
        
        stage('deploy') {
            steps {
                //sh 'ssh root@172.31.15.207'
                //sh "scp /home/slave1/workspace/parcel_service_feature-2/target/simple-parcel-service-app-1.0-SNAPSHOT.jar root@172.31.15.207:/opt/apache-tomcat-8.5.98/webapps"
                sh 'curl -v --user sanj:sanj --upload-file /home/slave1/workspace/deployingtomcat/Parcel-service/target/simple-parcel-service-app-1.0-SNAPSHOT.war "http://13.233.9.29:8081/manager/text/deploy?path=/simple-parcel-service-app-1.0-SNAPSHOT"'
            }
        }
        
    }
        
    post {
        success {
            echo "Build, Run, and Deployment to Tomcat successful!"
        }
        failure {
            echo "Build, Run, and Deployment to Tomcat failed!"
        }
    }
}
