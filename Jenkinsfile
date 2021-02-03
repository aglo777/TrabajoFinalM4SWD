pipeline {
    agent any

    stages {

        stage('intro') {
            steps {
                figlet "laboratorio M4"
                figlet "grupo 3"
            }
        }

        stage('compile') {
            steps {
                sh "./mvnw clean compile -e"
            }
        }

        stage('unit test') {
            steps {
                sh "./mvnw test -e -Dgroups=unit"
            }
        }

        stage('integration test') {
            steps {
                sh "./mvnw test -e -Dgroups=integration"
            }
        }

        stage('functional test') {
            steps {
                sh "./mvnw test -e -Dgroups=functional"
            }
        }

        stage('package') {
            steps {
                sh "./mvnw package -e -DskipTests"
            }
        }

        stage('run') {
            steps {
                sh "nohup java -jar target/devops-0.0.1-SNAPSHOT.jar &"
                sleep 10
            }
        }

        stage('API test') {
            steps {
                sh "newman run src/test/resources/postman/M4_Lab.postman_collection.json"
            }
        }
    }
}