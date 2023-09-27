FROM gradle:8.3.0-jdk17-alpine AS builder
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME
LABEL FIO="Тен А.А. Давыскиба А.С. ИКБО-16-20"
COPY gradle $APP_HOME/gradle
COPY --chown=gradle:gradle . /home/gradle/src
USER root
RUN chown -R gradle /home/gradle/src
RUN gradle build || return 0
COPY . .
RUN wget -O src/main/resources/static/photo.png https://www.mirea.ru/upload/medialibrary/80f/MIREA_Gerb_Colour.png
RUN gradle clean build -x test

FROM eclipse-temurin:17-jre-alpine
ENV APP_HOME=/usr/app/
ENV ARTIFACT_NAME=application-0.0.1-SNAPSHOT.jar
ENV POSTGRES_PORT=5432
ONBUILD RUN echo "Сборка и запуск произведены. Автор: {Тен А.А Давыскиба А.С.}"
WORKDIR $APP_HOME
COPY --from=builder $APP_HOME/build/libs/$ARTIFACT_NAME .
EXPOSE 8181:8080
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}
