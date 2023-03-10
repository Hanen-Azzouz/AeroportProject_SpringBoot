pipeline {
    agent any
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
            withSonarQubeEnv(installationName: 'sq2')
                {sh """mvn sonar:sonar"""}

                   }
                              }

    }
   }
