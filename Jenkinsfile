pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git branch: 'main', url: 'https://github.com/Hanen-Azzouz/AeroportProject_SpringBoot.git',
                credentialsId: 'Jenkins-Example-token-Github'
                   }
                        }
        stage('Mvn-Version') {
            steps {
                sh """mvn -version"""
                  }
                        }
    }
   }