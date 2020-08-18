pipeline{
  agent any

  parameters{
    choice(
        name: 'groups',
        choices: 'regression\nsmoke',
        description: 'Select group to run'
     )
  }

  tools{
    maven 'maven3'
  }

  stages{
    stage('Create Selenium Grid'){
      steps{
        sh "docker-compose -f docker-compose_selenium --build up -d"
      }
    }
    stage('Run tests'){
       steps{
         sh "mvn test -Dgroup=${params.groups}"
        }
    }
  }

  post{
    always{
      sh 'docker-compose -f docker-compose_selenium down'
      junit 'target/**/*.xml'
      junit 'target/surefire-reports/**/*.xml'
    }
  }

}
