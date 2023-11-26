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
    }
}
