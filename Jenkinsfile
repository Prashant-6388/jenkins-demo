pipeline {
    agent any

    stages {

        stage("compile") {
            steps {
                echo 'compiling code'
                withMaven( maven:'maven-3.6.3') {\
                    sh 'mvn clean compile'
                }
            }
        }

        stage("test") {
            steps {
                echo 'checking code quality'
                withMaven( maven:'maven-3.6.3') {\
                    sh 'mvn test'
                }
            }
        }


        stage("install") {
            steps {
                echo 'staging for deployment'
                withMaven( maven:'maven-3.6.3') {\
                    sh 'mvn install'
                }
            }
        }

    }
}