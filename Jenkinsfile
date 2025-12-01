pipeline {
    agent any

    tools {
        jdk 'jdk-17'
        maven 'Maven3.9.11'
    }

    stages {
        stage('Show messages'){
            steps {
                bet 'echo "Primer stage del pipeline"'
            }
        }
    }
}