pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        mvnExecute("mvn clean test")
      }
    }

    stage('Install') {
      steps {
        mvnExecute("mvn clean install")
      }
    }
  }
}

def mvnExecute(mvnCommand) {
  withMaven(maven: 'MAVEN 3', jdk: 'JDK 8', mavenLocalRepo: '.repository') {
    bat "${mvnCommand}"
  }
}
}