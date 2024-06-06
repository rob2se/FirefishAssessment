# FirefishAssessment

This project is a Java-based testing framework using Maven. It includes automated tests written in Java and uses Cucumber for BDD (Behavior Driven Development). This guide will help you set up your environment, configure necessary tools, and run the tests.

## Prerequisites

Before you begin, ensure you have the following installed on your system:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (version 11 or higher)
- [Apache Maven](https://maven.apache.org/download.cgi)

## Setting Up Java

1. **Download and Install JDK:**
   - Download the JDK from the official Oracle website or use OpenJDK.
   - Follow the installation instructions for your operating system.

2. **Set Up Environment Variables:**

   - **Windows:**
     1. Open the Control Panel.
     2. Navigate to System and Security > System > Advanced system settings.
     3. Click on `Environment Variables`.
     4. In the `System variables` section, click `New` and add `JAVA_HOME` as the variable name and the path to your JDK installation as the variable value.
     5. Edit the `Path` variable and add `%JAVA_HOME%\bin`.

   - **macOS/Linux:**
     1. Open a terminal.
     2. Open the profile file with a text editor (e.g., `nano ~/.bash_profile` or `nano ~/.zshrc` for zsh).
     3. Add the following lines:
        ```sh
        export JAVA_HOME=/path/to/your/jdk
        export PATH=$JAVA_HOME/bin:$PATH
        ```
     4. Save the file and run `source ~/.bash_profile` or `source ~/.zshrc` to apply the changes.

3. **Verify Installation:**
   ```sh
   java -version
   javac -version

 ## Setting Up Maven
 
 1. **Download and Install Maven:**
    - Download Maven from the official website.
    - Follow the installation instructions for your operating system.

2. **Set Up Environment Variables:**
   - **Windows:**
     1. Open the Control Panel.
     2. Navigate to System and Security > System > Advanced system settings.
     3. Click on Environment Variables.
     4. In the System variables section, click New and add M2_HOME as the variable name and the path to your Maven installation as the variable value.
     5. Edit the Path variable and add %M2_HOME%\bin.
    
  - **macOS/Linux:**
    1. Open a terminal.
    2. Open the profile file with a text editor (e.g., nano ~/.bash_profile or nano ~/.zshrc for zsh).
    3. Add the following lines:
       ```sh
        export M2_HOME=/path/to/your/maven
        export PATH=$M2_HOME/bin:$PATH
        ```
    4. Save the file and run source ~/.bash_profile or source ~/.zshrc to apply the changes.
   
3. **Verify Installation:**
   ```sh
   mvn -version

 ## Cloning the Repository

 1. Clone this repository to your local machine using the following command:
    ```sh
        git clone https://github.com/rob2se/FirefishAssessment.git
        cd FirefishAssessment
        ```
## Running The Tests

1.  mvn clean test -Dbrowser=Chrome
   
    





