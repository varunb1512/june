pipeline {
    agent any

    tools {
        maven 'maven'  // Assumes Maven is installed and configured in Jenkins under 'Global Tool Configuration'
    }

    stages {
        stage('Build') {
            steps {
                script {
                        sh 'mvn package'  // Use `sh` for Linux/macOS
                    
                }
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true  // Archives the built JAR file
            }
        }
    }
}
