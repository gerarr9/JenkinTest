pipeline {
    agent any
    parameters {
        choice(name: 'TEST_TYPE', choices: ['all', 'api', 'ui'], description: 'Выберите, какие тесты запускать')
    }

    stages {
        stage('Run Tests') {
            steps {
                script {
                    // Убедитесь, что gradlew имеет права на выполнение
                    sh 'chmod +x gradlew'
                    if (params.TEST_TYPE == 'api') {
                        echo "Running API tests"
                        sh './gradlew test -PincludeTags=api'
                    } else if (params.TEST_TYPE == 'ui') {
                        echo "Running UI tests"
                        sh './gradlew test -PincludeTags=ui'
                    } else {
                        echo "Running all tests"
                        sh './gradlew test'  // Запускает все тесты, если выбран 'all'
                    }
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                script {
                    // Генерация Allure отчета
                    echo "Generating Allure Report"
                    sh './gradlew allureReport'
                }
            }
        }

        stage('Allure Report') {
            steps {
                // Публикуем Allure отчет
                allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
            }
        }
    }
}
