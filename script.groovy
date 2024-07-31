def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: '0376fed8-3058-4434-9b19-73dab59eefc8	', passwordVariable: 'tfwknlm01289@@@
', usernameVariable: 'nourhan01289')]) {
        sh 'docker build -t nourhan01289/myapp:1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push nourhan01289/myapp:1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this