pipeline {
    agent any
     tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M2_HOME"
    }
    stages {
        stage('Build') {
            steps {
                git branch: 'main', url: 'https://github.com/Hanen-Azzouz/AeroportProject_SpringBoot.git',
                credentialsId: 'Jenkins-Example-token-Github'
                   }
                        }
        stage('Mvn-VERSION') {
            steps {
                sh """mvn -version"""
                  }
                        }

        stage('Mvn-ClEAN') {
            steps {
                 sh """mvn clean"""
                    }
                            }
        stage('Mvn-COMPILE') {
            steps {
                  sh """mvn compile"""
                   }
                              }
        stage('Mvn-SONARQUBE') {
            steps {
            withSonarQubeEnv(installationName: 'sq1')
                {sh """mvn sonar:sonar"""}
                   }
                              }

    }
   }
