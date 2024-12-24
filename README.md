# CipherEase

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Version](https://img.shields.io/badge/version-2.0.0-green.svg) 

# About CipherEase: 

Cipherease is a simple tool that protects sensitive information by turning it into unreadable codes using encryption. It ensures privacy and security, making it useful for safe communication, file storage, and data sharing.  

This tool is easy to use and works with encryption keys to lock and unlock data. Losing the key can make the data inaccessible, so proper key management is very important.

## Features


- Simple and intuitive user interface

- Support for multiple encryption algorithms:

- Caesar Cipher (client-side)

- AES (server-side)

- Basic and advanced encryption modes

- Responsive design for desktop and mobile devices

- Copy to clipboard functionality

- Server-side processing for enhanced security


## Technologies Used


 Frontend:

- HTML5

- CSS3

- JavaScript (ES6+)

 Backend:

- Java Servlets

 Build Tool:

- Maven

  Server:
  
- Apache Tomcat

  Libraries:

- CryptoJS (for client-side AES in advanced mode)


## Prerequisites


Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 11 or higher

- Apache Maven 3.6 or higher

- Apache Tomcat 9 or higher


## Installation


1. Clone the repository:

git clone https://github.com/yourusername/cipherease.git

cd cipherease


2. Build the project using Maven:

mvn clean package


3. Deploy the generated WAR file to your Tomcat server:

- Copy the `target/cipherease.war` file to your Tomcat's `webapps` directory


## Usage


1. Start your Tomcat server

2. Open a web browser and navigate to `http://localhost:8080/cipherease` (adjust the port if necessary)

3. Use the interface to encrypt or decrypt your text:

- Choose between Caesar Cipher and AES

- Enter your text in the input field

- Click "Encrypt" or "Decrypt" as needed

- The result will appear in the output field

4. For advanced options, click the "Advanced Processing" button


## Deployment


To deploy CipherEase to a production environment:


1. Ensure your production server has Java and Tomcat installed

2. Configure your `server.xml` and `context.xml` files in Tomcat for proper security settings

3. Deploy the WAR file to your production Tomcat server

4. Set up HTTPS to encrypt data in transit

5. Implement proper access controls and authentication if needed


## Security Considerations


- CipherEase uses client-side encryption for the Caesar Cipher, which is not suitable for highly sensitive data

- AES encryption is performed server-side for better security

- In a production environment, always use HTTPS to protect data in transit

- The AES key used in the servlet is hardcoded for demonstration purposes. In a real-world scenario, implement proper key management

- Regularly update dependencies to patch any security vulnerabilities


## Contributing


We welcome contributions to CipherEase! Please follow these steps:


1. Fork the repository

2. Create a new branch for your feature or bug fix

3. Make your changes and commit them with descriptive commit messages

4. Push your changes to your fork

5. Submit a pull request to the main repository


Please ensure your code adheres to the existing style and includes appropriate tests.


## License


CipherEase is released under the MIT License. See the [LICENSE](LICENSE) file for details.


## Contact


For any queries or support, please contact:

The Lakshay Trehan - lakshay.trehan@iu-academy.org


---


Thank you for using CipherEase! We hope it serves your encryption needs effectively and securely.
