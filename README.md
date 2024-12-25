# CipherEase

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Version](https://img.shields.io/badge/version-2.0.0-green.svg) 

# About CipherEase: 

Cipherease is a user-friendly tool designed to protect sensitive information by converting it into unreadable codes through encryption. It uses advanced algorithms to ensure that private data remains secure and inaccessible to unauthorized users. This makes it highly effective for safeguarding communication, protecting files, and securely sharing data online.  

The tool operates using encryption keys, which are required to lock and unlock the information. This ensures that only the intended recipient with the correct key can access the data. Cipherease supports various encryption methods, making it versatile and reliable for different use cases.  

While Cipherease is easy to use, proper management of encryption keys is critical. Losing or mismanaging the key can result in permanent data loss, as encrypted information cannot be accessed without it. By combining simplicity with strong encryption, Cipherease ensures both privacy and ease of use for everyday security needs.  

![WhatsApp Image 2024-12-25 at 14 16 54_a45b9172](https://github.com/user-attachments/assets/42eed4f8-9531-4900-97df-12da1802f5e6)


## Features


- **Simple and Intuitive User Interface**: Designed for ease of use, allowing users to encrypt and decrypt data effortlessly.  
- **Support for Multiple Encryption Algorithms**: Offers flexibility with a variety of encryption methods for different needs.  
  - **Caesar Cipher (Client-Side)**: Lightweight, quick encryption for simple use cases.  
  - **AES (Server-Side)**: Robust, industry-standard encryption for high-security applications.  
- **Basic and Advanced Encryption Modes**: Provides options for users, from straightforward encryption to more sophisticated setups.  
- **Responsive Design**: Optimized for seamless use across both desktop and mobile devices.  
- **Copy-to-Clipboard Functionality**: Allows quick copying of encrypted or decrypted text for ease of sharing.  
- **Server-Side Processing**: Enhances security by handling sensitive operations on a secure backend server.  


## Technologies Used


 ### **Frontend**  
- **HTML5**: Provides the structure and content of the web application.  
- **CSS3**: Styles the web application with modern design features.  
- **JavaScript (ES6+)**: Adds interactivity and advanced functionality with the latest ECMAScript features.  

### **Backend**  
- **Java Servlets**: Handles server-side logic and processes client requests.  

### **Build Tool**  
- **Maven**: Manages dependencies and automates the build process for the application.  

### **Server**  
- **Apache Tomcat**: Serves the application and processes backend operations efficiently.  

### **Libraries**  
- **CryptoJS**: Implements client-side AES encryption for secure data handling.  

# Setup CipherEase

## Prerequisites


Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 11 or higher

- Apache Maven 3.6 or higher

- Apache Tomcat 9 or higher


## Installation Instructions 


1. Clone the repository:

```
git clone https://github.com/yourusername/cipherease.git
```

```
cd cipherease
```

2. Build the project using Maven:

```
mvn clean package
```


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

**Lakshay Trehan - lakshay.trehan@iu-academy.org**


---


**Thank you for using CipherEase! We hope it serves your encryption needs effectively and securely.**
