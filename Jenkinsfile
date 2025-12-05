pipeline {
    agent any

    tools {
        jdk 'jdk-17'
        maven 'Maven3.9.11'
    }

    environment{
        VERSION_BACK = "2.0.1"
    }

    stages {
        stage('Show messages'){
            steps {
                bat 'echo "Primer stage del pipeline"'
                bat 'echo "A continuacion hacemos checkout del proyecto"'
            }
        }

        stage('Checkout proyecto'){
            steps {
                git branch: 'master',
                    url: 'https://github.com/yaninajso57/biblioteca.git'
            }
        }

        stage('Comandos Maven'){
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Crear directorio'){
            steps{
                bat 'mkdir v%VERSION_BACK%'
            }
        }

        stage('Copiar ficheros'){
            steps{
                bat 'xcopy /Y ".\\target\\*.jar" ".\\v%VERSION_BACK%"'
            }
            post{
                success {
                    bat 'echo "Despues de copiar los ficheros correctamente"'
                }

                failure {
                    bat 'echo "ERROR copiando los ficheros"'
                }

                always {
                    bat 'echo "Se ejecuta siempre tras el stage Copiar ficheros"'
                }
            }
        }
        stage('Deploy'){
            steps {
                bat """
                    echo "Starting deploy..."
                    java -jar target/biblioteca-${VERSION_BACK}.jar
                """
            }
        }
    }
}