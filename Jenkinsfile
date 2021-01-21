pipeline {
    agent any

    stages {

        stage("compile") {
            steps {
                echo 'compiling code'
                withMaven( maven:'maven-3.6.3') {\
                    bat 'mvn clean compile'
                }
            }
        }

        stage("test") {
            steps {
                echo 'checking code quality'
                withMaven( maven:'maven-3.6.3') {\
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
                    env.BRANCH_NAME == 'master'
                }
            }
            steps{
                echo 'deploying application to production'
                bat """
                    call robocopy ${WORKSPACE}/target D:/deployable *.jar
                    call if %errorlevel% neq 1 exit /b %errorlevel%
                    """
            }
        }

    }
}
