Custom Terminal Project
Overview
The Custom Terminal Project is a feature-rich terminal emulator designed to simplify file and directory management while providing additional utilities for developers. 
This terminal replicates many common command-line functionalities and introduces unique features to enhance user productivity.
Features
Below is a comprehensive list of the commands supported by the custom terminal:
Directory and File Operations
•	<cd> <DirectoryName>
o	Change the current working directory to the specified directory.
•	<mkdir> <DirectoryName>
o	Create a new directory with the given name in the current working directory.
•	<pwd>
o	Print the present working directory.
•	<back ..>
o	Move one level up in the directory hierarchy.
•	<create> <FileName>
o	Create a new file with the specified name.
•	<write> <FileName>
o	Write content to the specified file.
•	<print> <FileName>
o	Display the content of the specified file.
•	<delete> <FileName>
o	Delete the specified file from the current working directory.
File Manipulation
•	<rename> <OldNameOfFile> <NewNameFile>
o	Rename a file from the old name to the new name.
•	<copy> <SourceFile> <DestinationFile>
o	Copy the content of the source file to the destination file.
•	<append> <SourceFile> <DestinationFile>
o	Append the content of the source file to the destination file.
Display and Listing Utilities
•	<display> <.extension>
o	Display all files with the specified extension in the current directory.
•	<displaynf>
o	Print a list of all files in the current directory.
•	<displaynd>
o	Print a list of all directories in the current working directory.
System Utilities
•	<uinfo>
o	Print system user information, such as the username and operating system details.
•	<df>
o	Display disk space usage.
•	<free>
o	Display memory usage statistics.
Development Utilities
•	<compile> <.java>
o	Compile Java source code files.
•	<runjp> <javaSourceFile>
o	Execute Java programs directly from the terminal.
How to Use
1.	Clone the repository to your local system:
git clone <repository_url>
2.	Navigate to the project directory:
cd custom-terminal
3.	Compile and run the project (if applicable):
4.	javac Main.java
java Main
5.	Use the commands listed above to perform desired operations.
System Requirements
•	Java Version: Java 8 or higher
•	Operating System: Windows/Linux/MacOS
Example Usage
Here are some examples of using the terminal commands:
•	Create a directory:
mkdir Projects
•	Change directory:
cd Projects
•	Create a file and write to it:
•	create notes.txt
write notes.txt
•	Display all .txt files:
display .txt
•	Compile and run Java code:
•	compile HelloWorld.java
runjp HelloWorld.java
Contributing
Contributions to this project are welcome! If you'd like to contribute:
1.	Fork the repository.
2.	Create a new branch for your feature or bug fix.
3.	Commit your changes and submit a pull request.
