import java.io.*;
import java.nio.file.*;
import java.util.List;

public class run {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // 원본 디렉터리와 새로운 디렉터리 이름 입력 받기
          
            String currentDirectory = ".";
          
            String sourceDirectory = currentDirectory + "/problem";

            System.out.print("새로 생성할 디렉터리 이름을 입력하세요: ");
            String newDirectoryName = reader.readLine().trim();
            String targetDirectory = currentDirectory + "/" + newDirectoryName;

            // 디렉터리 복사
            copyDirectory(Paths.get(sourceDirectory), Paths.get(targetDirectory));

            // 새로운 패키지 이름으로 업데이트
            updatePackageNameInDirectory(targetDirectory, newDirectoryName);

            System.out.println("모든 .java 파일이 복사되고 package 이름이 성공적으로 변경되었습니다.");
        } catch (IOException e) {
            System.err.println("오류가 발생했습니다: " + e.getMessage());
        }
    }

    public static void copyDirectory(Path source, Path target) throws IOException {
        if (!Files.exists(source)) {
            throw new IOException("원본 디렉터리가 존재하지 않습니다: " + source.toAbsolutePath());
        }

        Files.walk(source).forEach(sourcePath -> {
            try {
                Path targetPath = target.resolve(source.relativize(sourcePath));
                if (Files.isDirectory(sourcePath)) {
                    Files.createDirectories(targetPath);
                } else {
                    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                System.err.println("디렉터리를 복사하는 중 오류가 발생했습니다: " + e.getMessage());
            }
        });
    }

    public static void updatePackageNameInDirectory(String directoryPath, String newPackageName) {
        try {
            Files.walk(Paths.get(directoryPath))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".java"))
                .forEach(path -> updatePackageNameInFile(path, newPackageName));
        } catch (IOException e) {
            System.err.println("디렉터리를 처리하는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public static void updatePackageNameInFile(Path filePath, String newPackageName) {
        try {
            // 파일 읽기
            List<String> lines = Files.readAllLines(filePath);
            
            // 첫 번째 package 라인을 새로운 패키지 이름으로 교체
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).trim().startsWith("package ")) {
                    lines.set(i, "package " + newPackageName + ";");
                    break;
                }
            }

            // 파일 쓰기
            Files.write(filePath, lines);
            System.out.println("Updated package in " + filePath);
        } catch (IOException e) {
            System.err.println("파일 처리 중 오류가 발생했습니다: " + filePath + ", " + e.getMessage());
        }
    }
}
