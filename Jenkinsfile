pipeline {
    agent any

    tools {
        maven 'sonarmaven'  // Ensure Maven is installed and configured in Jenkins
        jdk 'jdk'  // Ensure JDK is installed and configured in Jenkins
    }

    environment {
        MVN_HOME = tool 'sonarmaven'
        JAVA_HOME = tool 'jdk'
        PATH = "${MVN_HOME}/bin:${JAVA_HOME}/bin:${PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Calculus04/maven-pipeline.git'
            }
        }

        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Compile') {
            steps {
                bat 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'  // Archive test reports
        }
        success {
            echo '✅ Build and Tests Passed Successfully!'
        }
        failure {
            echo '❌ Build Failed! Check the logs for errors.'
        }
    }
}
