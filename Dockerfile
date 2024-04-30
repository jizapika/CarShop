FROM ubuntu:20.04

ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven git wget && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*;

RUN git clone https://github.com/jizapika/CarShop /usr/src/app/CarShop

WORKDIR /usr/src/app/CarShop

RUN mvn clean package

USER 1002

ENTRYPOINT ["java", "-jar", "target/carShop-0.0.1-SNAPSHOT.jar"]
