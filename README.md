# DockerSelenium
# ------------------
# Orphaned comments:1
# To run the docker-compose-standAlone.yml file, use the following command:
# docker-compose -f docker-compose-standAlone.yml up -d

# To stop the docker-compose-standAlone.yml file use the following command:
# docker-compose -f docker-compose-standAlone.yml down

# if the file name is same then run 
# docker-compose up -d

# Access the Selenium StandAlone browser UI at http://localhost:4444/ui
# Start services with the YAML file: docker-compose up -d
# Stop services: docker-compose down

# Check Docker version: docker -v
# List installed Docker images: docker images
# Pull the latest Selenium/standalone-chrome image: docker pull selenium/standalone-chrome:latest
# Check running Docker containers: docker ps
# Port 4444 is used for both browsers

# ------------------
# Without using a YAML file:
# Run Selenium standalone Chrome container:
# docker run -d -p 4444:4444 selenium/standalone-chrome

# Run Selenium standalone Firefox container:
# docker run -d -p 4444:4444 selenium/standalone-firefox

# Note: No need to expose VNC port explicitly for Chrome:
# docker run -d -p 4444:4444 -p 7900:7900 selenium/standalone-chrome

# To run tests with Firefox using Maven:
# mvn test -Dbrowser=firefox

# To run tests with Chrome using Maven:
# mvn test

# To run tests with edge using Maven:
# mvn test -Dbrowser=edge



# Integarte docker with local system

# Run the command java -jar jenkins. war
# Run docker 
# jenkin configration with windows for free style
# cd C:\DockerSelenium\DockerSelenium
# mvn clean install

# Integarte docker with github
# mvn clean install

