/*
Given a list paths of directory info, including the directory path, and all the files with contents in this
directory, return all the duplicate files in the file system in terms of their paths.
 You may return the answer in any order.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        Solution solution = new Solution();
        List<List<String>> duplicates = solution.findDuplicate(paths);
        for (List<String> filePaths : duplicates) {
            for (String filePath : filePaths) {
                System.out.print(filePath + " ");
            }
            System.out.println();
        }
    }
    public static class Solution {
        public static List<List<String>> findDuplicate(String[] paths) {
            // Map для хранения содержимого файлов в качестве ключа и списка путей к файлам в качестве значения
                Map<String, List<String>> files = new HashMap<>();

                //Итеррируем по списку путей
                for (String path : paths) {
                    String[] parts = path.split(" ");
                    String directory = parts[0];

                    // Итеррация по файлам в папке
                    for (int i = 1; i < parts.length; i++) {
                        //Разделим имя файла и сожержимое
                        String[] fileInfo = parts[i].split("\\(");
                        String fileName = fileInfo[0];
                        String fileContent = fileInfo[1].replace(")", "");

                        // Добавляем файл в map
                        List<String> filePaths = files.getOrDefault(fileContent, new ArrayList<>());
                        filePaths.add(directory + "/" + fileName);
                        files.put(fileContent, filePaths);
                    }
                }
                // Найдем дубликаты файлов
                List<List<String >> duplicates = new ArrayList<>();
                for (List<String> filePaths : files.values()) {
                    if (filePaths.size() > 1) {
                        duplicates.add(filePaths);
                    }
                }
                return duplicates;
            }
        }
    }
