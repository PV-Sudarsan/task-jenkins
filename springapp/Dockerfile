FROM ubuntu:20.04
WORKDIR /app
ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*
RUN java -version && \
    echo "JAVA_HOME is set to: $JAVA_HOME" || echo "JAVA_HOME not set, setting manually" && \
    export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64 && \
    echo "JAVA_HOME set to: $JAVA_HOME"
COPY . .
RUN  mvn clean package -DskipTests
EXPOSE 8082
RUN addgroup --system appgroup && adduser --system --ingroup appgroup --no-create-home appuser
USER appuser
CMD ["java", "-jar", "target/springapp-0.0.1-SNAPSHOT.jar"]