pipeline {
    agent any

    tools {
        maven 'maven'  // Assumes Maven is installed and configured in Jenkins under 'Global Tool Configuration'
    }

    stages {
        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn package'  // Use `sh` for Linux/macOS
                    } else {
                        bat 'mvn package' // Use `bat` for Windows
                    }
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
