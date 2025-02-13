pipeline{
    agent any

    tools {
         maven 'maven'
         
    }

    
        stage('build'){
            steps{
               bat 'mvn package'
            }
        }
        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true  // Archives JAR file
            }
        }
    }
}
