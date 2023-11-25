package org.sopkaton.Project.external;

import org.sopkaton.Project.config.AWSConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;
import java.util.*;

@Component
public class S3Service {

    private static final List<String> IMAGE_EXTENSIONS = Arrays.asList("image/jpeg", "image/png", "image/jpg", "image/webp");
    private static final Long MAX_FILE_SIZE = 3 * 1024 * 1024L;
    private final String bucketName;

    // 생성자로 의존성 주입
    public S3Service(@Value("${aws-property.s3-bucket}") final String bucketName, AWSConfig awsConfig) {
        this.bucketName = bucketName;
        this.awsConfig = awsConfig;
    }

    private final AWSConfig awsConfig;

    public String uploadImage(String directoryPath, MultipartFile image) throws IOException { // 네트워크 통신을 하기 때문에 IOException 꼭 붙이기
        validateExtension(image);
        validateFileSize(image);

        final String key = directoryPath + generateImageFileName(image);
        final S3Client s3Client = awsConfig.getS3Client();


        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType(image.getContentType())
                .contentDisposition("inline")
                .build();

        RequestBody requestBody = RequestBody.fromBytes(image.getBytes()); // 이미지를 바이트코드로 바꿔서 RequestBody에 넣어줌
        PutObjectResponse response = s3Client.putObject(request, requestBody);

        return "https://" + bucketName + ".s3." + awsConfig.getRegion().toString() + ".amazonaws.com/" + key;
    }

    // 파일 이름을 UUID로 만드는 메서드
    // 파일 이름의 보안 강화 효과
    private String generateImageFileName(MultipartFile image) {
        return UUID.randomUUID().toString() + generateExtensionByContentType(image.getContentType());
    }

    private String generateExtensionByContentType(String contentType) {
        return switch (contentType) {
            case "image/jpeg" -> ".jpg";
            case "image/png" -> ".png";
            case "image/jpg" -> ".jpg";
            case "image/webp" -> ".webp";
            default -> throw new RuntimeException("이미지 확장자는 jpg, png, webp만 가능합니다.");
        };
    }

    private void validateExtension(MultipartFile image) {
        String contentType = image.getContentType();
        if (!IMAGE_EXTENSIONS.contains(contentType)) {
            throw new RuntimeException("이미지 확장자는 jpg, png, webp만 가능합니다.");
        }
    }

    private void validateFileSize(MultipartFile image) {
        if (image.getSize() > MAX_FILE_SIZE) {
            throw new RuntimeException("이미지 사이즈는 5MB를 넘을 수 없습니다.");
        }
    }

}
