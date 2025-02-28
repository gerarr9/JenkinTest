pipeline {
    agent any
    parameters {
        choice(name: 'TEST_TYPE', choices: ['all', 'api', 'ui'], description: 'Выберите, какие тесты запускать')
    }

    stages {
        stage('Prepare Environment') {
            steps {
                script {
                    sh 'chmod +x gradlew'
                    sh 'rm -rf build/allure-results'
                    sh 'rm -rf build/reports/allure-report'
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    if (params.TEST_TYPE == 'api') {
                        sh './gradlew test -PincludeTags=api'
                    } else if (params.TEST_TYPE == 'ui') {
                        sh './gradlew test -PincludeTags=ui'
                    } else {
                        parallel(
                                "API Tests": {
                                    sh './gradlew test -PincludeTags=api'
                                },
                                "UI Tests": {
                                    sh './gradlew test -PincludeTags=ui'
                                },
                                failFast: false // Тесты не прерываются при падении одной из стадий
                        )
                    }
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                script {
                    echo "Generating Allure Report"
                    sh './gradlew allureReport'
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
