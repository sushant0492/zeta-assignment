# Zeta-Assignment

Zeta-Assignment is a RESTful service created using Spring Boot. It provides two endpoints:
- `GET /public/v2/users` to get all users.
- `POST /public/v2/users` to create a new user.

## Installation

To run the application locally, you need to have Open JDK installed on your machine. You can follow these steps to run it locally:

1. Clone the repository:
   git clone <repository-url>
   
2. Navigate to the project directory:
   cd Zeta-Assignment

3. Build the project using Maven:
   mvn clean install

4. Run the application:
   java -jar target/Zeta-Assignment-<version>.jar

## Docker Image

You can also run this application using a Docker image. The Docker image can be pulled from Docker Hub:

`docker pull sushant0492/zeta-app`


To run the application in a container, use the following command:

`docker run -p 8080:8080 sushant0492/zeta-app`


## Code Coverage

Enhancements to the project require maintaining a code coverage of at least 90%. The code coverage is validated using Jacoco. Please ensure that any new code additions are accompanied by relevant unit tests to maintain the required code coverage.

## Logging

The application generates log files named `myApplication.log`, which can be found in the `target` folder. You can use any log monitoring tool to monitor the logs and gain insights into the application's behavior.

## Contribution

If you wish to contribute to the project, feel free to submit issues or pull requests. Please follow the guidelines for contributing to ensure a smooth collaboration process.
