pipeline {
    agent any
    parameters {
        choice(name: 'TEST_TYPE', choices: ['all', 'api', 'ui'], description: 'Выберите, какие тесты запускать')
    }

    stages {
        stage('Run Tests') {
            steps {
                script {
                    sh 'chmod +x gradlew'

                    if (params.TEST_TYPE == 'api') {
                        sh './gradlew test -PincludeTags=api'
                    } else if (params.TEST_TYPE == 'ui') {
                        sh './gradlew test -PincludeTags=ui'
                    } else {
                        // Для выбора 'all' создаем параллельные стадии
                        parallel(
                                "API Tests": {
                                    sh './gradlew test -PincludeTags=api'
                                },
                                "UI Tests": {
                                    sh './gradlew test -PincludeTags=ui'
                                }
                        )
                    }
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                script {
                    // Генерация Allure отчета с флагом --clean
                    echo "Generating Allure Report"
                    sh './gradlew allureReport --clean'
                }
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
            }
        }
    }
}
