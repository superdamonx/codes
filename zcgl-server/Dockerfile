FROM gradle:5.6.2-jdk8 as gbuild
WORKDIR /home/gradle/
COPY . /home/gradle/
RUN gradle clean build

FROM openjdk:8-jdk-alpine AS build
WORKDIR /workspace/app
LABEL maintainer="tfswx"
COPY . /workspace/app
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
COPY --from=gbuild /home/gradle/build/libs/*.jar ./app.jar
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../../*.jar)

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","club.yiwuyu.zcgl.Application"]