import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {
    public static List<String> searchFiles(String directory, String fileName) {
        List<String> resultList = new ArrayList<>();
        File dir = new File(directory);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    resultList.addAll(searchFiles(file.getAbsolutePath(), fileName));
                } else if (file.getName().contains(fileName)) {
                    resultList.add(file.getAbsolutePath());
                }
            }
        }
        return resultList;
    }

    public static int countFilesInFolder(String directory) {
        File folder = new File(directory);// 创建一个File对象来表示目录
        if (folder.isDirectory()) {// 检查路径是否为目录
            File[] files = folder.listFiles();// 获取目录下的所有文件
            if (files != null) {// 检查文件数组是否非空
                return files.length;// 返回文件数量
            }
        }
        return 0;
    }
}