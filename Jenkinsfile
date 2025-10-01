pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = 'rahimbenmohamed/kaddem-app'
        DOCKER_TAG = "${env.BUILD_NUMBER}"
    }
    
    stages {
        stage('Checkout Git') {
            steps {
                git branch: 'master', 
                url: 'https://github.com/rahimbm/kaddem-fork.git'
            }
        }
        
        stage('Build Project') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                }
            }
        }
        
        stage('Push to Docker Hub') {
            steps {
                script {
                    withCredentials([usernamePassword(
                        credentialsId: 'docker-hub-credentials',
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS'
                    )]) {
                        sh "echo ${DOCKER_PASS} | docker login -u ${DOCKER_USER} --password-stdin"
                        sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                    }
                }
            }
        }
        
        stage('Run Container') {
            steps {
                script {
                    sh 'docker stop kaddem-app || true'
                    sh 'docker rm kaddem-app || true'
                    sh "docker run -d --name kaddem-app -p 8080:8080 ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline terminée!'
        }
    }
}
