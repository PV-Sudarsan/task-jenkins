pipeline{
    agent any
    stages {
        stage('source code') {
            steps {
                echo 'Cloning...'
                   git branch: 'main', url: 'https://github.com/PV-Sudarsan/task-jenkins.git'

            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                sh 'docker-compose up -d '
            }
        }
    }
}
