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