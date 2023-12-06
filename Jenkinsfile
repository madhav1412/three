pipeline {
    agent any
    tools {
        // Define the JDK tool
        jdk 'Java17'
        
        // Define another tool, for example, Maven
        maven 'Maven3'
    }    
    stages {
        stage ('Build') {
            steps {
                sh 'mvn clean package'
            }
        }        
        stage('Login to Docker Hub') {
            steps {
                sh 'docker login -u madhavnemani -p {{pass}}'
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
                sh 'kubectl rollout restart deployment/three-helm-three'
            }
        }
    }
}
