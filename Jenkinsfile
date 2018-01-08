pipeline {
  tools {
    maven "M3"
    jdk "JDK8U152"
  }

  post {
    // No matter what the build status is, run these steps. There are other conditions
    // available as well, such as "success", "failed", "unstable", and "changed".
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
    stage('BuildMaster') {
      when{
         branch 'master'
      }
      steps {
        withMaven(
        // Maven installation declared in the Jenkins "Global Tool Configuration"
        maven: 'M3',
        // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
        // Maven settings and global settings can also be defined in Jenkins Global Tools Configuration
        mavenLocalRepo: '.repository') {
          sh "mvn clean install -f swagger-compare/pom.xml -P dockerBuild"
        } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs reports...
        
      }
    }
    stage('BuildBranch') {
      when{
        not{
          branch 'Jenkins'
        }
      }
      steps {
        withMaven(
        // Maven installation declared in the Jenkins "Global Tool Configuration"
        maven: 'M3',
        // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
        // Maven settings and global settings can also be defined in Jenkins Global Tools Configuration
        mavenLocalRepo: '.repository') {
          sh "mvn clean install -f swagger-compare/pom.xml"
        } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs reports...
      }
    }
      
    stage('DockerMaster') {
      when{
          branch 'master'
      }
      steps {
        sh "docker tag torbenhaug/swagger-compare:${version()} torbenhaug/swagger-compare:latest"
        sh "docker stop swagger-compare-instance || true && docker rm swagger-compare-instance || true"
        sh "docker run --name swagger-compare-instance -d -p 7070:8080 torbenhaug/swagger-compare:latest"
      }
    }
    stage('DockerBranch') {
      when{
        not{
          branch 'Jenkins'
        }
      }
      steps{
        println "Current branch ${env.BRANCH_NAME}: Docker is only build on the master"
      }
    }
  }
}
def version() {
  def matcher = readFile('swagger-compare/pom.xml') =~ '<version>(.+)</version>'
  matcher ? matcher[0][1].trim() : null
}
//def project = new XmlSlurper().parseText(readFile('swagger-compare/pom.xml'))
//def pomv = project.version.text()
