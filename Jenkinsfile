pipeline {
    agent any

    stages {

        stage('intro') {
            steps {
                figlet "laboratorio M4"
                figlet "grupo 3"
            }
        }

        stage('package') {
            steps {
                sh "./mvnw clean package -e -DskipTests"
            }
        }

        stage('unit test') {
            steps {
                sh "./mvnw clean test -e -Dgroups=unit"
            }
        }

        stage('integration test') {
            steps {
                sh "./mvnw clean test -e -Dgroups=integration"
            }
        }
/*
        stage('functional test') {
            steps {
                sh "./mvnw clean test -e -Dgroups=functional"
            }
        }
*/
        stage('run') {
            steps {
                sh "BUILD_ID=dontKillMe nohup java -jar target/devops-0.0.1-SNAPSHOT.jar --server.port=8082 &"
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