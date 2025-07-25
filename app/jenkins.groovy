pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'hafeez0/flask-devops-app'
        DOCKERHUB_CREDENTIALS = 'dockerhub'
    }

    stages {
        stage('Clone Repo') {
            steps {
                git branch: 'main', url: 'https://github.com/hafeez0/devops-capstone-project.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}", "app/")
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('', "${DOCKERHUB_CREDENTIALS}") {
                        docker.image("${DOCKER_IMAGE}").push('latest')
                    }
                }
            }
        }
    }
}
