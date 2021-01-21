pipeline {

    agent any

    environment {
        projectPom = readMavenPom file: ''
        version = "${projectPom}.version"
    }

    stages {

        stage("compile") {
            steps {
                echo 'compiling code'
                echo "pom version : ${version}"
                withMaven( maven:'maven-3.6.3') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage("test") {
            steps {
                echo 'checking code quality'
                withMaven( maven:'maven-3.6.3') {
                    bat 'mvn test'
                }
            }
        }

        stage("install") {
            steps {
                echo 'staging for deployment'
                withMaven( maven:'maven-3.6.3') {
                    bat 'mvn install'
                }
            }
        }

        stage("deploy") {
            when{
                expression {
                    env.BRANCH_NAME == 'master' && !"${version}.contains('SNAPSHOT')"
                }
            }
            input {
                message "Should we continue?"
            }
            steps{
                echo 'deploying application to production'
            }
        }

    }
}
