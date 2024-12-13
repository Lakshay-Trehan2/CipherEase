CipherEase
CipherEase is a web-based encryption and decryption tool designed for effortless processing of text data. It aims to educate users on basic encryption and decryption concepts for personal and professional use.
Features:
* Supports multiple encryption algorithms:
   * Caesar Cipher (client-side)
   * AES (server-side)
* User-friendly interface for easy text input and processing
* Basic encryption/decryption on the main page
* Advanced processing options for AES encryption
* Responsive design for various devices
* Secure client-server communication
Prerequisites
* Java Development Kit (JDK) 11 or later
* Apache Maven 3.6.0 or later
* Apache Tomcat 9.0 or later
Installation
* Clone the repository:
git clone https://github.com/Lakshay-Trehan2/CipherEase.git
cd cipherease
 
* Build the project using Maven:
mvn clean package
 
This command compiles the code, runs tests, and packages the application into a WAR file located in the target directory.
* Deployment
* Copy the generated WAR file to Tomcat's webapps directory:
cp target/cipherease.war /path/to/tomcat/webapps/
 
* Start Tomcat if it's not already running:
/path/to/tomcat/bin/startup.sh
 
(Use startup.bat on Windows)
* Tomcat will automatically deploy the application. Check the logs for successful deployment:
tail -f /path/to/tomcat/logs/catalina.out
 
Usage
Once deployed, access CipherEase via a web browser:
http://localhost:8080/cipherease
 
Basic Encryption/Decryption:
* Enter text for encryption or decryption.
* Select the desired algorithm (Caesar Cipher, Base64, or AES).
* Click "Encrypt" or "Decrypt" to process the text.
* The result will appear in the output field.
* Use the "Copy to Clipboard" button to copy the result.
Advanced Processing (AES):
* Click "Advanced Processing" on the main page.
* Enter text for encryption or decryption.
* Provide a key/passphrase for AES encryption.
* Click "Encrypt" or "Decrypt" as needed.
* The server will process the request and display the result.
Project Structure
src/main/java/com/cipherease/: Contains Java source files
    ProcessServlet.java: Handles server-side encryption/decryption requests
src/main/webapp/: Contains web resources
    index.html: Main page of the application
    advanced.html: Advanced processing page
    js/: JavaScript files
        script.js: Handles client-side logic and AJAX requests
    css/: (Styles are currently embedded in HTML files)
pom.xml: Maven project configuration file
 
Troubleshooting
* Ensure all prerequisites are correctly installed and configured.
* Check Tomcat logs for error messages:
tail -f /path/to/tomcat/logs/catalina.out
 
* Verify WAR file deployment in the webapps directory.
* Restart Tomcat if changes aren't reflected:
/path/to/tomcat/bin/shutdown.sh
/path/to/tomcat/bin/startup.sh
 
* For client-side issues, check the browser console for JavaScript errors.
Security Considerations
* The AES key used for server-side processing is currently hardcoded for demonstration purposes. Implement a secure key management system in production.
* Consider HTTPS for secure client-server data transmission.
* Implement proper input validation and sanitization to prevent security vulnerabilities.
Future Enhancements
* Add support for more encryption algorithms
* Implement file encryption/decryption capabilities
* Create user accounts for saving encrypted messages
* Develop a mobile application
Contributing
Contributions are welcome! Please submit a Pull Request for code changes. For major changes, open an issue first to discuss the proposed modifications.
License
