FROM openjdk
VOLUME [ "/tmp" ]
WORKDIR /usr/local/
COPY eureka-client01.jar eureka-client01.jar
EXPOSE 8081
#ENTRYPOINT ["nohup","java","-jar","-Xms1G","-Dfile.encoding=utf-8","eureka-client01.jar",">>","/usr/local/log/xxx.log","&"]
ENTRYPOINT ["java","-jar","-Xms1G","-Dfile.encoding=utf-8","eureka-client01.jar"]