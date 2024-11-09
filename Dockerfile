# Build stage
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Final stage
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/*.jar demo.jar

# Cài đặt các biến môi trường trong Docker container
ENV DB_USERNAME=root
ENV DB_PASSWORD=SYjNeRzNVZAViwFcqfotcstPxGeicpRH
ENV GOOGLE_CLIENT_ID=854899780211-p148qqqvv8svo8mmviv8tuf6sbmip7iq.apps.googleusercontent.com
ENV GOOGLE_CLIENT_SECRET=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
ENV FIREBASE_BUCKET=quanlytuyendung-4fb2c.appspot.com
ENV ALLOWED_ORIGIN=http://localhost:3000
ENV EMAIL_USERNAME=cobedt123@gmail.com
ENV EMAIL_PASSWORD=czkxbisyxmgfjknz
ENV DELIVERABLE_MAIL_API_KEY=2359fee504724cb3b2f46ff7d3390c1a

EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "demo.jar" ]
