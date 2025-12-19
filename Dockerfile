# ---------- 1단계: 빌드 ----------
FROM gradle:8.5-jdk17 AS builder
WORKDIR /build

COPY . .
RUN gradle clean build -x test

# ---------- 2단계: 실행 ----------
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

COPY --from=builder /build/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
