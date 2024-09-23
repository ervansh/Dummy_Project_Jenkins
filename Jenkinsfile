pipeline {
    agent any
    stages {
		stage('Initialize'){
			steps{
				echo "Running build #${env.BUILD_ID} on Jenkins ${env.JENKINS_URL}"
			}
		}
		stage('Checkout'){
			steps{
					echo 'Checkout git. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
				git branch: 'jenkinstestbranch', url: 'https://github.com/ervansh/JenkinsRepo.git'
			}
		}
        stage('Build') {
            steps {
                 echo "building >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
   				script{
					 env.path = 'C:/apache-maven-3.9.8/bin;C:/Program Files/Java/jdk-21/bin;C:/Windows/System32'
				}
				script: 'mvn package'
    			 echo "build success. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
            }
        }
        stage('Artifact'){
			steps{
				echo 'Preserving build....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
				archiveArtifacts artifacts: '/target/*.jar'
     			echo "artifact preserved >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
			}
		}
    }
    post{
			always{
				echo 'Pipeline finished.'
				step([$class: 'JUnitResultArchiver', checksName: '', testResults: 'target/surefire-reports/junitreports/TEST-*.xml'])
			}
		}
}