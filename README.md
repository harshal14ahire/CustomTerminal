Custom Terminal Project

Overview

The Custom Terminal Project is a feature-rich terminal emulator designed to simplify file and directory management while providing additional utilities for developers. This terminal replicates many common command-line functionalities and introduces unique features to enhance user productivity.

Features

Below is a comprehensive list of the commands supported by the custom terminal:

Directory and File Operations

<cd> <DirectoryName>

Change the current working directory to the specified directory.

<mkdir> <DirectoryName>

Create a new directory with the given name in the current working directory.

<pwd>

Print the present working directory.

<back ..>

Move one level up in the directory hierarchy.

<create> <FileName>

Create a new file with the specified name.

<write> <FileName>

Write content to the specified file.

<print> <FileName>

Display the content of the specified file.

<delete> <FileName>

Delete the specified file from the current working directory.

File Manipulation

<rename> <OldNameOfFile> <NewNameFile>

Rename a file from the old name to the new name.

<copy> <SourceFile> <DestinationFile>

Copy the content of the source file to the destination file.

<append> <SourceFile> <DestinationFile>

Append the content of the source file to the destination file.

Display and Listing Utilities

<display> <.extension>

Display all files with the specified extension in the current directory.

<displaynf>

Print a list of all files in the current directory.

<displaynd>

Print a list of all directories in the current working directory.

System Utilities

<uinfo>

Print system user information, such as the username and operating system details.

<df>

Display disk space usage.

<free>

Display memory usage statistics.

Development Utilities

<compile> <.java>

Compile Java source code files.

<runjp> <javaSourceFile>

Execute Java programs directly from the terminal.

How to Use

Clone the repository to your local system:

git clone <repository_url>

Navigate to the project directory:

cd custom-terminal

Compile and run the project (if applicable):

javac Main.java
java Main

Use the commands listed above to perform desired operations.

System Requirements

Java Version: Java 8 or higher

Operating System: Windows/Linux/MacOS

Example Usage

Here are some examples of using the terminal commands:

Create a directory:

mkdir Projects

Change directory:

cd Projects

Create a file and write to it:

create notes.txt
write notes.txt

Display all .txt files:

display .txt

Compile and run Java code:

compile HelloWorld.java
runjp HelloWorld.java

Contributing

Contributions to this project are welcome! If you'd like to contribute:

Fork the repository.

Create a new branch for your feature or bug fix.

Commit your changes and submit a pull request.
