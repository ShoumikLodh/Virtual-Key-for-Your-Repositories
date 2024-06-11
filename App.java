import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String DIRECTORY_PATH = "C:\\Users\\Shoumik\\Desktop\\java\\Project1\\project_1\\src\\files";
    public static void main(String[] args) throws Exception {
        System.out.println("LockedMe.com"); 
        System.out.println("Developed by: Shoumik Lodh- Full Stack Developer at Lockers Pvt. Ltd."); 

        System.out.println("User Interface for the application is as follows:");
        System.out.println("1. Display all files in the directory");
        System.out.println("2. File operations:");
        System.out.println("3. Exit the application");

        boolean flag = true;
        while(flag){
            System.out.println("Enter your choice: ");
            int choice = 0;
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch(choice){ 
                case 1:
                    System.out.println("Displaying all files in the directory");
                    List<String>names= retrieveFileNames();
                    for (String str : names) {
                        System.out.println(str);
                    }
                    break;
                case 2:
                    boolean flag2 = true;
                    while(flag2){
                        System.out.println("File operations:");
                        System.out.println("1. Add a file to the directory");
                        System.out.println("2. Delete a file from the directory");
                        System.out.println("3. Search for a file in the directory");
                        System.out.println("4. Exit");

                        int fileChoice = 0;
                        fileChoice = sc.nextInt();
                        switch(fileChoice){
                            case 1:
                                System.out.println("Enter the name of the file to be added: ");
                                String fileName = sc.next();
                                addFile(fileName);
                                break;
                            case 2:
                                System.out.println("Enter the name of the file to be deleted: ");
                                String fileToDelete = sc.next();
                                deleteFile(fileToDelete);
                                break;
                            case 3:
                                System.out.println("Enter the name of the file to be searched: ");
                                String fileToSearch = sc.next();
                                searchFile(fileToSearch);
                                break;

                            case 4:
                                System.out.println("Exiting file operations");
                                flag2 = false;
                                break;
                            default:
                                System.out.println("Invalid choice. Please enter a valid choice.");
                                flag2 = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting the application");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
                    break;
            }
        }


    }

    public static void deleteFile(String fileName) {
        File file = new File(DIRECTORY_PATH + "/" + fileName);
        if (file.delete()) {
            System.out.println("File deleted: " + fileName);
        } else {
            System.out.println("File not found.");
        }
    }

    public static void searchFile(String fileName) {
        File file = new File(DIRECTORY_PATH + "/" + fileName);
        if (file.exists()) {
            System.out.println("File found: " + fileName);
        } else {
            System.out.println("File not found.");
        }
    }

    public static void addFile(String fileName) {
        File file = new File(DIRECTORY_PATH + "/" + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + fileName);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> retrieveFileNames() {
        File directory = new File(DIRECTORY_PATH);
        List<String> fileNames = new ArrayList<>();

        if (directory.exists() && directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }
        Collections.sort(fileNames);
        return fileNames;
    }
}
