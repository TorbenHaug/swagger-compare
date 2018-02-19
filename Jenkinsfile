pipeline {
  tools {
    maven "M3"
    jdk "JDK8U152"
  }

  post {
    always {
      cleanWs();
      step([$class: 'Mailer',
        notifyEveryUnstableBuild: true,
        recipients: "info@haug-dev.de",
        sendToIndividuals: true])
    }
  }

  agent any
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('BuildBranch') {
      steps {
        sh '''return -1'''
        withMaven(
        maven: 'M3',
        mavenLocalRepo: '.repository') {
          sh "mvn clean install -f swagger-compare/pom.xml"
        }
      }
    }
  }
}
