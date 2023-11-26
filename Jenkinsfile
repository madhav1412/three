pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                sh '.\mvnw clean install' 
            }
        }        
        stage('Login to Docker Hub') {
            steps {
                sh 'docker login -u madhavnemani -p jaQgip-xejka6-ressoz'
            }
        }        
        stage('Build Docker image') {
            steps {
                sh 'docker build -t madhavnemani/645a3 .'
            }
        }
        stage('Push Docker image') {
            steps {
                sh 'docker push madhavnemani/645a3'
            }
        }
        stage('Copy kubeconfig') {
            steps {
                sh 'cp config ~/.kube/config'
            }
        }
        stage('Restart deployment') {
            steps {
                sh 'kubectl rollout restart deployment/sixfourfive'
            }
        }
    }
}
