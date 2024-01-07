package stack;

import java.util.Stack;

public class Solution_0106 {

    // 71.
    // Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system,
    // convert it to the simplified canonical path.
    // In a Unix-style file system, a period '.' refers to the current directory
    // , a double period '..' refers to the directory up a level,
    // and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem,
    // any other format of periods such as '...' are treated as file/directory names.
    // The canonical path should have the following format:
    // The path starts with a single slash '/'.
    // Any two directories are separated by a single slash '/'.
    // The path does not end with a trailing '/'.
    // The path only contains the directories on the path from the root directory to the target file or directory
    // (i.e., no period '.' or double period '..')
    // Return the simplified canonical path.

    // 1 <= path.length <= 3000
    // path consists of English letters, digits, period '.', slash '/' or '_'.
    // path is a valid absolute Unix path.
    public String solution71(String path) {
        String[] directoryArray = path.split("/");

        Stack<String> savedDirectory = new Stack<>();
        for(String directory : directoryArray) {
            if(!directory.isEmpty() && !directory.equals(".")) {
                if(directory.equals("..")) {
                    if(!savedDirectory.isEmpty()) {
                        savedDirectory.pop();
                    }
                } else {
                    savedDirectory.push(directory);
                }
            }
        }

        StringBuilder finalPath = new StringBuilder();
        while(!savedDirectory.isEmpty()) {
            finalPath.insert(0, savedDirectory.pop());
            finalPath.insert(0, "/");
        }

        return finalPath.toString().isEmpty() ? "/" : finalPath.toString();
    }
}
