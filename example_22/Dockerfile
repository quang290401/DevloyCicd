# Sử dụng image nhẹ chứa JDK 17
FROM openjdk:17-jdk-slim

# Tạo thư mục chứa ứng dụng trong container
WORKDIR /app

# Copy file jar vào container (từ thư mục local target/)
COPY target/example_22-0.0.1-SNAPSHOT.jar app.jar

# Cấu hình lệnh chạy
ENTRYPOINT ["java", "-jar", "app.jar"]
