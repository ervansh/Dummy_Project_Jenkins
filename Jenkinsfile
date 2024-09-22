pipeline {
    agent any

    stages {
		
		stage('Information'){
			steps{
				echo "Running build #${env.BUILD_ID} on Jenkins ${env.JENKINS_URL}"
			}
		}
		
		stage('Checkout'){
			steps{
				step{
					echo 'Checkout git. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
				git branch: 'jenkinstestbranch', url: 'https://github.com/ervansh/JenkinsRepo.git'
				}
			}
		}
		
		stage('Compile'){
			steps{
				step{
					echo "compile. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
    			script: 'mvn compile'
    			echo "compilation completed. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"

				}			}
		}
        stage('Build') {
            steps {
                 echo "building >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
   				 script: 'mvn clean package'
    			 echo "build success. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
                
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
                script: 'mvn clean test'
    			 echo "Test success. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
            }
        }
        
        stage('Artifact'){
			steps{
				echo 'Preserving build....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
				archiveArtifacts artifacts: '/target/*.jar'
     			echo "artifact preserved >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
			}
		}
		        stage('Publish Report') {
            steps {
                echo 'Publishing report....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
                step([$class: 'JUnitResultArchiver', checksName: '', testResults: 'target/surefire-reports/junitreports/TEST-*.xml'])
                
            }
        }
                stage('Trigger Email') {
            steps {
                echo 'Email....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
                emailext body: 'Build body.', recipientProviders: [buildUser()], subject: 'Build status', to: 'abc@gmail.com'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Its a dummy.'
            }
        }
    }
}