pipeline {
  tools {
    maven "M3"
    jdk "JDK8U152"
  }

  post {
    always {
        cleanWs();
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
        withMaven(
        maven: 'M3',
        mavenLocalRepo: '.repository') {
          sh "mvn clean install -f swagger-compare/pom.xml"
        }
      }
    }
  }
}
