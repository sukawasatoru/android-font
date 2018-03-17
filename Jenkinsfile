pipeline {
    agent {
        label 'android'
    }

    stages {
        stage('Build') {
            steps {
                sh './gradlew --info --profile build'
            }
        }
    }
}
