pipeline{
    agent any
    tools {
        maven 'maven-3.6' //from the tools configartion
    }

    stages{

        stage("build jar") {
            steps {
                echo "building jar file"
                sh "mvn package"
                
            }
        }
        stage("build image") {
            steps {
              echo "building the docker image..."
              withCredentials([usernamePassword(credentialsId: '0376fed8-3058-4434-9b19-73dab59eefc8	', passwordVariable: 'tfwknlm01289@@@', usernameVariable: 'nourhan01289')]) {
                 sh 'docker build -t nourhan01289/myapp:1.0 .'
                 sh "echo $PASS | docker login -u $USER --password-stdin"
                 sh 'docker push nourhan01289/myapp:1.0'
              }
            }
        }
        stage("deploy app") {
            steps {
                echo "deploying  app"
                
            }
        }


    }
}