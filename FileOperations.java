import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class FileOperations {
    public static void copyFile(String sourceFile, String destinationFile) throws IOException {
        Files.copy(Paths.get(sourceFile), Paths.get(destinationFile), StandardCopyOption.REPLACE_EXISTING);
    }

    public static String previewTextFile(String filePath, int numLines) throws IOException {
        StringBuilder preview = new StringBuilder();
        Charset charset = Charset.forName("UTF-8"); // 使用UTF-8编码
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charset))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null && count < numLines) {
                preview.append(line).append("\n");
                count++;
            }
        }
        return preview.toString();
    }

    public static void renameFile(String filePath, String newName) {
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (parentDir != null) {
            File newFile = new File(parentDir, newName);
            if (file.renameTo(newFile)) {
                System.out.println("文件重命名成功。");
            } else {
                System.out.println("文件重命名失败。");
            }
        }
    }

    public static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex);
        }
        return "";
    }
}