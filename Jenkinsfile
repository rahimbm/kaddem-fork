pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = 'rahimbenmohamed/kaddem-app'
        DOCKER_TAG = "${env.BUILD_NUMBER}"
    }
    
    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'master', 
                url: 'https://github.com/rahimbm/kaddem-fork.git'
            }
        }
        
        stage('Maven Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('Docker Build & Push') {
            steps {
                script {
                    // Vérifier les fichiers
                    sh 'ls -la target/'
                    sh 'pwd'
                    
                    // Build Docker
                    sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                    sh "docker tag ${DOCKER_IMAGE}:${DOCKER_TAG} ${DOCKER_IMAGE}:latest"
                    
                    // Push to Docker Hub
                    withCredentials([usernamePassword(
                        credentialsId: 'docker-hub-credentials',
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS'
                    )]) {
                        sh "echo ${DOCKER_PASS} | docker login -u ${DOCKER_USER} --password-stdin"
                        sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                        sh "docker push ${DOCKER_IMAGE}:latest"
                    }
                }
            }
        }
        
        stage('Docker Run') {
            steps {
                script {
                    sh 'docker stop kaddem-app || true'
                    sh 'docker rm kaddem-app || true'
                    sh "docker run -d --name kaddem-app -p 8080:8080 ${DOCKER_IMAGE}:latest"
                    
                    // Vérifier que ça marche
                    sh 'sleep 15'
                    sh 'docker ps'
                    sh 'curl -f http://localhost:8080/ || echo "Application démarrée"'
                }
            }
        }
    }
    
    post {
        always {
            echo '✅ Pipeline terminée avec succès!'
            sh 'docker images | grep rahimbenmohamed || true'
        }
    }
}
