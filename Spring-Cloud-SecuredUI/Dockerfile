FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  target/Spring-Cloud-SecuredUI-0.0.1-SNAPSHOT.jar securedui.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/securedui.jar"]