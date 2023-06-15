FROM --platform=linux/amd64 bellsoft/liberica-openjdk-alpine:17
#FROM --platform=linux/arm64/v8 bellsoft/liberica-openjdk-alpine:17
RUN apk --no-cache add curl && apk add --no-cache bash
ADD ./build/libs/*.jar app.jar
ENTRYPOINT java $JAVA_OPTS -jar app.jar