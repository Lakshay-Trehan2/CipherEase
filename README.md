```plaintext
# CipherEase

CipherEase is a web-based encryption and decryption tool designed for effortless processing of text data. It aims to educate users on basic encryption and decryption concepts for personal and professional use.

## Features

- Support for multiple encryption algorithms:
  - Caesar Cipher (client-side)
  - AES (server-side)
- User-friendly interface for easy text input and processing
- Basic encryption/decryption options on the main page
- Advanced processing options for AES encryption
- Responsive design for use on various devices
- Secure client-server communication

## Prerequisites

Before you begin, ensure you have met the following requirements:
- Java Development Kit (JDK) 11 or later
- Apache Maven 3.6.0 or later
- Apache Tomcat 9.0 or later

## Installation

1. Clone the repository:
```

git clone [https://github.com/Lakshay-Trehan2/CipherEase.git](https://github.com/Lakshay-Trehan2/CipherEase.git)
cd CipherEase

```plaintext

2. Build the project using Maven:
```

mvn clean package

```plaintext

3. Deploy to Tomcat:
- Copy the generated WAR file from `target/cipherease.war` to Tomcat's `webapps` directory
- Start Tomcat

4. Access the application:
Open your web browser and navigate to `http://localhost:8080/cipherease`

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## Contact

For any queries or suggestions, please contact:
Lakshay Trehan - lakshay.trehan@iu-academy.org

Project Link: https://github.com/Lakshay-Trehan2/CipherEase
```

