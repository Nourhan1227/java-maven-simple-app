def gv
    
pipeline {
    agent any
    parameters{
        choice(name: 'VERSION',choices: ['1.0.0', '1.0.1', '1.0.2'],description: 'Select A specific version')
        booleanparam(name: 'executetests',defaultvalue: true ,description: 'execute / skip test stage')
    }
 
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            input{
                message "select env to deploy app"
                ok "OK"
                parameters{
                    choice(name: 'ENV',choices: ['dev', 'stagging', 'production'],description: 'Select the env you want to deploy to')
                }
            }
            steps {
                script {
                    echo "deploying the version ${params.VERSION} and env ${ENV}"
                    gv.deployApp()
                }
            }
        }
    }   
}