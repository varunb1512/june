pipeline{
    agent any

    tools {
         maven 'maven'
         
    }

    stages{
        stage('checkout'){
            steps{
                git branch:'*/master', url: 'https://github.com/SyedAsadAhbar/java-hello-world-with-maven.git'
            }
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
