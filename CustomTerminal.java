import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.nio.file.*;

public class CustomTerminal
 {
    private static File currentDirectory = new File(System.getProperty("user.dir"));
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
     public static final String ANSI_RED = "\u001B[31m";
     public static final String lightblue= "\u001B[36m";
     public static final String color ="\u001B[38;2;255;165;0m";
      private final OutputStream outputStream;

    public CustomTerminal(OutputStream outputStream)
     {
        this.outputStream = outputStream;
    }

    public static void main(String[] args) throws IOException ,InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
          System.out.println(ANSI_GREEN + "Welcome to Custom Terminal!" + ANSI_RESET);

        while (true) 
        {
            // Display current path
           System.out.print(ANSI_GREEN + "\n" + currentDirectory.getAbsolutePath() + "> " + ANSI_RESET);

            // Get user input
           System.out.print( color);
            String input = scanner.nextLine();
            System.out.print(ANSI_RESET);

            // Process user input
            processCommand(input);
            
        }
    }
// Add a getter method for currentOutput


  public static void processCommand(String input) 
     {
        //split given command in tokens with white spaces 
        String[] parts = input.split(" ");
        // first check which command user want to  execute 
        String command = parts[0];

        try {
            switch (command) 
              {
                case "cd":
                    // change directory command 
                    if (parts.length == 2)
                    {
                    changeDirectory(parts);
                    }
                    break;
                case "info":
                    // print all files in current directory
                    if(parts.length == 1)
                    listFiles();
                    else
                    {
                         System.out.println("Usage:  <info>");
                    }
                    break;
                case "print":
                    // print all file with print command
                    if (parts.length >= 2) 
                    {
                        printFile(parts[1]);
                    } else
                     {
                        System.out.println("Usage: print <filename>");
                    }
                    break;
                case "copy":
                    // copy command
                    if (parts.length >= 3)
                     {
                        copyFile(parts[1], parts[2]);
                    } else 
                    {
                        System.out.println("Usage: copy <sourceFile> <destinationFile>");
                    }
                    break;
                case "delete":
                    // delete file|files in current directory 
                    if (parts.length >= 3 && parts[1].equals("*"))
                     {
                        deleteWithExtension(parts[2]);
                    }
                     else if (parts.length >= 2)
                      {
                        delete(parts[1]);
                    } else
                     {
                         System.out.println("Usage: delete <*|filename> [extension]");
                    }

                    break;
                case "back":
                    // backward directory access command 
                    if (parts.length >= 1 || parts[1].equals("back.."))
                     {
                        navigateToParentDirectory();
                    } else
                     {
                        System.out.println("Usage: cd <directory>");
                    }
                    break;
                case "pwd":
                    //get present working directory
                    printCurrentPath();
                    break;
                 case "compile":
                   // compile java program
                    compileJavaFile(parts[1]);
                 break;
                case "runjp":
                        //run java program
                     if (parts.length >= 2)
                      {
                       runJavaProgram(parts[1]);
                      } 
                     else
                     {
                        System.out.println("Usage: run <ClassName>");
                     }
                 break;

                case "rename":
                    //renme file or directory
                    rename(parts[1],parts[2]);
                    break;
               
                case "uinfo":
                    // print System user information
                     printUserInfo();
                    break;    
                case "move":
                    move(parts[1] ,parts[2]);break;
                case "mkdir":
                    // create directory
                    if(parts.length==2)
                    mkdir(parts[1]);
                    else
                    {
                        System.err.println(" make sure command is correct");
                    }
                    break;
                case "create":
                    // create file
                    create(parts[1]); 
                    break;
                case "write":
                    // writes into file
                    write(parts[1]);
                    break;
                case "displaynf":
                    // display all files in directory 
                    printAllFile();
                    break;
                case "displaynd":
                    // display all Directories in current working directory
                    printAllDirectory();
                    break;

                case "df":
                    // display Disk space
                    displayDiskSpaceUsage();
                    break;
                case "free":
                    // free memory space
                    displayMemoryUsage();
                    break;
                case "display":
                    //display list of files with .....extension
                  printFileWithExtension(parts[1] ,parts[2]);
                  break;
                case "append":
                    //append one file to other
                    appendOneFileToOther(parts[1],parts[2]);  
                    break;
                case "exit":
                   // close customterminal
                    System.exit(0);
                    break;
               
                case "ping":
                   if (parts.length >= 2) {
                     pingHost(parts[1]);
                        } else {
                           System.out.println("Usage: ping <host>");
                            }
                         break;
    
                case "help?":
                     System.out.println(lightblue);
                    System.out.println("<cd> <DirectoryName> : to change Directory");
                    System.out.println("<mkdir> <DirectoryName> : to make Directory");
                    System.out.println("<pwd> : print present working Directory");
                    System.out.println("<back ..> : to move backward in Directory");
                    System.out.println("<create> <FileName> : create File");
                    System.out.println("<write> <FileName> :  write in File");
                    System.out.println("<print> <FileName> : print file");
                    System.out.println("<uinfo> : print System user Informantion");
                    System.out.println("<rename> <OldNameOfFile> <NewNameFile> : to rename files");
                    System.out.println("<copy> <SourceFile> <DestinationFile> : copy one file to other ");
                    System.out.println("<append> <sourcefile> <destinationFile> : append source file to destination file");
                    System.out.println("<df> :    DisplayDiskSpaceUsage");
                    System.out.println("<free> : displayMemoryUsage");
                    System.out.println("<display> <.extension> : print list All files with given extension ");
                    System.out.println("<displaynf> : print list of All files in Directory");
                    System.out.println("<displaynd> : print list ofDIrectories files in Present Working Directory ");
                    System.out.println("<delete> <FileName> : Deletes file");
                    System.out.println("<compile> <.java> compile java code");
                    System.out.println("<runjp> <javaSourceFile> run java code");
                    
                    System.out.println("<delete> <*> <.extension> :deletes All files with given Extension in  Present Working Directory");
                    break;

                default:
                    System.out.print(ANSI_RED);
                    System.out.println( command +" is not recognized as an internal or external command, operable program or batch file.");
                  System.out.println("help?:~~~~~\nis command for All commands information");

            }
        } catch (IOException e)
         {
            System.out.println("Exception: " + e.getMessage());
         }
        catch(InterruptedException e1)
        {
              System.out.println("Exception: " + e1.getMessage());
        }
    }

    private static void pingHost(String host) throws IOException, InterruptedException
 {
    ProcessBuilder processBuilder = new ProcessBuilder("ping", host);
    Process process = processBuilder.start();

    // Print the output of the command
    printStream(process.getInputStream(), System.out);

    int exitCode = process.waitFor();
    if (exitCode != 0)
     {
        System.err.println("Ping failed. Exit code: " + exitCode);
    }
}

    public static void appendOneFileToOther(String srcfile,String desfile ) throws IOException ,FileNotFoundException

    {
      FileOutputStream fos=new FileOutputStream(desfile ,true);
      FileInputStream fis =new FileInputStream(srcfile);

        int n;
        while((n=fis.read())!=-1)  
        {
            fos.write(n);
        }
        fis.close();
        fos.close();
    } 

    private static void runJavaProgram(String className) throws IOException, InterruptedException
     {
    // Build the command to run the Java program
    String javaCommand = "java";
    String classPath = currentDirectory.getAbsolutePath();
   // String classFile = className.replace(".", File.separator) + ".class";

    // Use ProcessBuilder to run the Java program
    ProcessBuilder processBuilder = new ProcessBuilder(javaCommand, "-cp", classPath, className);
    processBuilder.redirectErrorStream(true); // Redirect error stream to input stream

    Process process = processBuilder.start();

    // Get input and output streams
    OutputStream outputStream = process.getOutputStream();
    InputStream inputStream = process.getInputStream();

    // Create a thread to read from the Java program and print to the custom terminal
    Thread outputThread = new Thread(() -> {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)))
         {
            String line;
            while ((line = reader.readLine()) != null)
             {
                System.out.println(line);
            }
        } catch (IOException e)
         {
            e.printStackTrace();
        }
    });
    outputThread.start();

    // Read input from the custom terminal and write to the Java program
    Scanner scanner = new Scanner(System.in);
    String input;
    while (!(input = scanner.nextLine()).equals("exit"))
     {
        outputStream.write((input + System.lineSeparator()).getBytes());
        outputStream.flush();
    }

    // Wait for the Java program to finish
    int exitCode = process.waitFor();
    if (exitCode != 0) {
        System.err.println("Java program execution failed. Exit code: " + exitCode);
    }

    // Wait for the output thread to finish
    outputThread.join();
}


  public static void  printFileWithExtension(String ch ,String extension)
    { 
        if(ch.equals("*"))
    {
        File[] files = currentDirectory.listFiles();
        int c = 0;

        if (files != null)
         {
            for (File file : files) 
            {
                if ( file.getName().endsWith(extension)) 
                {
                   System.out.println(file.getName());

                }
            }

          }
          else
          {
            System.out.println("NO files found in Current Working Directory..");
          }
      }
      else
      {
        System.out.println("Invalid command <display> <*> <.extension>");
      }
} 

   public static void printAllFile()
   {
     
        File[] files = currentDirectory.listFiles();

        if (files != null) 
        {
            for (File file : files)
             { 
                if(file.isFile())
                System.out.println(file.getName());
            }
        }
    

   }

public static void  printAllDirectory()
{
     File[] files = currentDirectory.listFiles();

        if (files != null) 
        {
            for (File file : files)
             { if(file.isDirectory())
                System.out.println(file.getName());
            }
        }
}


   public static void printUserInfo()
    {
        // Get user name
        String userName = System.getProperty("user.name");

        // Get user home directory
        String userHome = System.getProperty("user.home");

        // Get user current working directory
        String userDir = System.getProperty("user.dir");

        // Get Java version
        String javaVersion = System.getProperty("java.version");

        // Get operating system name
        String osName = System.getProperty("os.name");

        // Get operating system version
        String osVersion = System.getProperty("os.version");

        // Get operating system architecture
        String osArch = System.getProperty("os.arch");

        // Print user information
        System.out.println("User Information:");
        System.out.println("User Name: "+ANSI_GREEN + userName +ANSI_RESET);
        System.out.println("User Home Directory: " + userHome);
        System.out.println("Current Working Directory: " + userDir);
        System.out.println("Java Version: " + javaVersion);
        System.out.println("Operating System: " + osName + " " + osVersion + " " + osArch);
    }
      
      public static void displayDiskSpaceUsage() throws IOException
       {
        File file = new File(".");
        long totalSpace = file.getTotalSpace();
        long freeSpace = file.getFreeSpace();
        long usedSpace = totalSpace - freeSpace;

        System.out.println("Disk Space Usage:");
        System.out.println("Total Space: " + formatBytes(totalSpace));
        System.out.println("Used Space: " + formatBytes(usedSpace));
        System.out.println("Free Space: " + formatBytes(freeSpace));
    }

public static void compileJavaFile(String fileName) throws IOException, InterruptedException
 {
    // Example: javac HelloWorld.java
  String command = "javac " + fileName;

    executeCommand(command);
}



private static void executeCommand(String command) throws IOException, InterruptedException
 {
    Process process = Runtime.getRuntime().exec(command);
    int exitCode = process.waitFor();

    // Print the output of the command
    printStream(process.getInputStream(), System.out);

    // Print the error output of the command
    printStream(process.getErrorStream(), System.err);

    if (exitCode == 0) 
    {
        System.out.println("Command executed successfully.");
    } else
     {
        System.err.println("Command execution failed. Exit code: " + exitCode);
    }
}

private static void printStream(InputStream stream, PrintStream out) throws IOException 
{
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) 
    {
        String line;
        while ((line = reader.readLine()) != null)
         {
            out.println(line);
        }
    }
}
    public static void displayMemoryUsage() throws IOException
    {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.println("Memory Usage:");
        System.out.println("Total Memory: " + formatBytes(totalMemory));
        System.out.println("Used Memory: " + formatBytes(usedMemory));
        System.out.println("Free Memory: " + formatBytes(freeMemory));
    }

    

    public static String formatBytes(long bytes)
     {
        long kilobytes = bytes / 1024;
        long megabytes = kilobytes / 1024;
        long gigabytes = megabytes / 1024;

        if (gigabytes > 0) {
            return gigabytes + " GB";
        } else if (megabytes > 0) {
            return megabytes + " MB";
        } else if (kilobytes > 0) {
            return kilobytes + " KB";
        } else {
            return bytes + " Bytes";
        }
    }
  
    public static void write(String filename) throws IOException, FileNotFoundException
    {   File f1= new  File(currentDirectory, filename);

        if (!f1.exists())
        {

            create(filename);
        }
    
        FileOutputStream fos=new FileOutputStream(f1 ,true);
        int n;
        System.out.println(" Enter content you want to write in file....Ctrl Z to end:");
         System.out.print(lightblue);
        while((n=System.in.read())!= -1)
        {
            fos.write(n);
        }
        fos.close();
         System.out.print(ANSI_GREEN);
        System.out.println(" Your content Witten in file Successfully..");
        
        
    }
    public static void create(String filename) throws IOException
    {
            File fname=new File(currentDirectory,filename);
            if(fname.createNewFile())
            {
                System.out.println(filename+"  created Successfully! ...");


            }
            else{
                System.out.println(" errror  file creation...");
            }

    }
    public static void rename(String s1,String s2)
        {
            File oldname=new File(s1);
            File newnmae=new File(s2);
            if(oldname.renameTo(newnmae))
            {
                System.out.println(s1 +"is rename to  " +s2 +"...");
            }
            else{
                System.out.println(" renme Failed...");
            }
        }

    public static void mkdir(String directoryname)
     {
    File dname = new File(currentDirectory, directoryname);

    if (!dname.exists())
     {
        if (dname.mkdirs())
         {
    System.out.println(directoryname + " Directory created Successfully!...\n");
        } else 
        {
            System.out.println("Error: Directory not Created...\n");
        }
    } 
    else
     {
         System.out.println("Error: Directory already exists...\n");
    }
}

   
    public static void navigateToParentDirectory() 
    {
        File parentDir = currentDirectory.getParentFile();
        if (parentDir != null)
         {
            currentDirectory = parentDir;
        } 
        else
         {
            System.out.println("Already at the root directory.");
        }
    }

    public static void delete(String fname)
     {
        File fileToDelete = new File(currentDirectory, fname);
        if (fileToDelete.exists() || fileToDelete.isFile() || fileToDelete.isDirectory())
         {
            if (fileToDelete.delete()) 
            {
                System.out.println(fname + " deleted successfully.");
            } else 
            {
                System.out.println("Failed to delete " + fname);
            }
        } else
         {
            System.out.println("File not found: " + fname);
        }
    }

    public static void deleteWithExtension(String extension)
     {
        File[] files = currentDirectory.listFiles();
        int c = 0;

        if (files != null) {
            for (File file : files) 
            {
                if (file.isFile() && file.getName().endsWith(extension))
                 {
                    if (file.delete())
                     {
                        c++;
                    }
                }
            }
        }

        System.out.println(c + " files with extension " + extension + " deleted successfully.");
    }

    public static void printFile(String filename) throws FileNotFoundException, IOException 
    {
        File file = new File(currentDirectory, filename);
        if (file.exists() && file.isFile())
         {    System.out.println(ANSI_GREEN);
            try (FileInputStream fileInputStream = new FileInputStream(file)) 
            {
                int i;
                while ((i = fileInputStream.read()) != -1)
                 {
                    System.out.print((char) i);
                }
            }
        } else
         {
            System.out.println("File not found: " + filename);
        }
    }

    public static void copyFile(String source, String destination) throws IOException ,FileNotFoundException
     {
       FileInputStream fis =new FileInputStream(source);
       FileOutputStream fos=new FileOutputStream(destination);
       int n;
       while((n=fis.read())!=-1)
       {
        fos.write(n);
       }
        System.out.println("File copied successfully!");
        fos.close();
        fis.close();
    }
  public static void move(String source, String destination) 
  {
        File sourceFile = new File(source);
        File destinationFile = new File(destination);

        if (sourceFile.exists()) {
            if (!destinationFile.exists() || (destinationFile.exists() && destinationFile.isDirectory()))
             {
                try {
                    Files.move(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("File moved successfully!");
                } catch (IOException e) {
                    System.err.println("Failed to move file: " + e.getMessage());
                }
            } else {
                System.out.println("Destination is an existing file, cannot overwrite: " + destination);
            }
        } else
         {
            System.out.println("Source file not found: " + source);
        }
    }
    public static void changeDirectory(String[] parts) 
    {
        if (parts.length < 2) {
            System.out.println("Usage: cd  <directory>");
        } else 
        {
            String newDirectory = parts[1];
            File newDir = new File(currentDirectory, newDirectory);

            if (newDir.isDirectory())
             {
                currentDirectory = newDir;
            } else
             {
                System.out.println("Directory not found: " + newDirectory);
            }
        }
    }

public static void listFiles()
 {
    File[] files = currentDirectory.listFiles();

    if (files != null) {
        // Print table headers
        System.out.printf("%-20s %-19s %-8s %s\n", "Mode", "LastWriteTime", "Length", "Name");
        System.out.println("----                 -------------         ------ ----");

        for (File file : files) {
            String mode = file.isDirectory() ? "d" : "-";
            mode += file.canRead() ? "r" : "-";
            mode += file.canWrite() ? "w" : "-";
            mode += file.canExecute() ? "x" : "-";
            
            // Formatting file details
            String lastWriteTime = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm").format(new java.util.Date(file.lastModified()));
            String length = file.isDirectory() ? "" : String.valueOf(file.length());

            System.out.printf("%-4s        %-19s %-8s %s\n", mode, lastWriteTime, length, file.getName());
        }
    }
}


    public static void printCurrentPath() 
    {
        System.out.println(currentDirectory.getAbsolutePath());
    }
}
