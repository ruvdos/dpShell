package Main.Logics;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ReadFilesFromFolder {

    public static void getFilesForFolder(String fullPath) {
        DTO.shot_full_HashMapNames.clear();
        DTO.dpNames_ObserveList.clear();

        File folder = new File(fullPath);
        if (!folder.exists()) {return;}

        File logDir = new File(fullPath);
        List<File> files = Arrays.asList(logDir.listFiles());
        fillShortLongNamesHashMap(files);

    }

    public static void processSelectedFiles(List<File> files) {
        DTO.shot_full_HashMapNames.clear();
        DTO.dpNames_ObserveList.clear();

        fillShortLongNamesHashMap(files);
    }
    private static void fillShortLongNamesHashMap(List<File> files) {
        for (File f : files) {
            if (f.isFile()) {         
                String exp = ReadFilesFromFolder.getFileExtension(f.getAbsolutePath());
                if (exp != null && exp.equals(".xlsx")) {
                    DTO.shot_full_HashMapNames.put(f.getName().substring(0, f.getName().length() - 5), f.getAbsolutePath());
                }
                if (exp != null && exp.equals(".xls")) {
                    DTO.shot_full_HashMapNames.put(f.getName().substring(0, f.getName().length() - 4), f.getAbsolutePath());
                }
            }
        }
    }


    public static String getFileExtension(String mystr) {
        int index = mystr.indexOf('.');
        return index == -1 ? null : mystr.substring(index);
    }


}
