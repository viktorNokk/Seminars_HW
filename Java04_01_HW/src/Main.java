/*
    Given a string path, which is an absolute path (starting with a slash '/')
    to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 */
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String path = "/../";
        String res = simplifyPath(path);
        System.out.println(res);
    }
    public static  String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // разделим "/" и обработаем каждую часть отдельно
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals(".")) {
                // ничего делать ненужно
            } else if (part.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!part.isEmpty()) {
                // поместить в стек
                stack.push(part);
            }
        }
        // строим уже упрощенный путь
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }
        // если стек пуст вернумся в корень
        if (sb.length() == 0) {
            return "/";
        }

        return sb.toString();
    }
}