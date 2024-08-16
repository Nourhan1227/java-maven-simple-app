def gv
pipeline{
    agent any
    tools {
        maven 'maven-3.6' //from the tools configartion
    }

    stages{
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
                    gv.buildJar()
              }
                
            }
        }
        stage("build image") {
            steps {
               script {
                    gv.buildImage()
               }

            }
        }
        stage("deploy app") {
            steps {
                script {
                    echo "building image"
                    gv.deployApp()
                }

            }
        }


    }
}