# Sử dụng image JDK chính thức để chạy ứng dụng
FROM openjdk:21-jdk-slim

# Đặt biến môi trường cho timezone (tuỳ chọn)
ENV TZ=Asia/Ho_Chi_Minh

# Tạo thư mục chứa app trong container
WORKDIR /app

# Copy file JAR từ thư mục target vào container
COPY target/*.jar app.jar

# Expose port nếu app chạy cổng cụ thể (ví dụ: 8080)
EXPOSE 8080

# Câu lệnh chạy ứng dụng
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
