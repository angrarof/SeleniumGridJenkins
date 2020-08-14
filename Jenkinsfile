pipeline{
  agent any

  parameters{
    choice(
        name: 'xmlFile',
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
        bat "docker-compose up"
      }
    }
    stage('Run tests'){
       steps{
         bat "mvn test -DsuiteXmlFiles=src/test/resources/${params.xmlFile}"
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
