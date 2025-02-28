pipeline {
    agent any
    parameters {
        choice(name: 'TEST_TYPE', choices: ['all', 'api', 'ui'], description: 'Выберите, какие тесты запускать')
    }

    stages {
        stage('Run Tests') {
            steps {
                script {
                    if (params.TEST_TYPE == 'api') {
                        sh './gradlew test -PincludeTags=api'
                    } else if (params.TEST_TYPE == 'ui') {
                        sh './gradlew test -PincludeTags=ui'
                    } else {
                        sh './gradlew test'
                    }
                }
            }
        }
    }
}
