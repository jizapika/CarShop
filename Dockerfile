FROM ubuntu:20.04 as builder

ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven git wget;

RUN git clone https://github.com/jizapika/CarShop /usr/src/app/CarShop

WORKDIR /usr/src/app/CarShop

RUN mvn clean package

USER 1002

FROM ubuntu:20.04

ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*;

COPY --from=builder /usr/src/app/CarShop/target/carShop-0.0.1-SNAPSHOT.jar ./carShop.jar

ENTRYPOINT ["java", "-jar", "carShop.jar"]