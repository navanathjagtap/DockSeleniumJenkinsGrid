# DockerSelenium
# ------------------
# Orphaned comments:

#http://localhost:4444/ui
#with yml start-> docker-compose up -d
#end->docker-compose down

#docker version-> docker -v
#docker imeges installed--> docker images 
#docker pull selenium/standalone-chrome:latest
#running docker container->docker ps
# 4444 port is good for both browser
# ------------------
#without yml file
# docker run -d -p 4444:4444 selenium/standalone-chrome
#docker run -d -p 4444:4444 selenium/standalone-firefox
#  no need  docker run -d -p 4444:4444 -p 7900:7900 selenium/standalone-chrome
#for firefox--> mvn test -Dbrowser=firefox