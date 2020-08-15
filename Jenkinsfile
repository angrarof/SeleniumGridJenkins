pipeline{
  agent any

  parameters{
    choice(
        name: 'suiteXmlFile',
        choices: 'Regression.xml\nSingle.xml',
        description: 'Select xml file to run'
    )
  }

  tools{
    maven 'maven3'
  }

  stages{
    stage('Create Selenium Grid'){
      steps{
        sh "docker-compose up -d"
      }
    }
    stage('Run tests'){
       steps{
         sh "mvn test -DsuiteXmlFile=src/test/resources/${params.suiteXmlFile}"
        }
    }
  }

  post{
    always{
      sh 'docker-compose down'
      junit 'target/**/*.xml'
      junit 'target/surefire-reports/**/*.xml'
    }
  }

}
