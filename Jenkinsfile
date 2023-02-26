pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git branch: 'main', url: 'https://github.com/Hanen-Azzouz/AeroportProject_SpringBoot.git'
                credentialsId:'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';
                   }
                        }
        stage('clean') {
            steps {
                sh """mvn -version"""
                  }
                        }
    }