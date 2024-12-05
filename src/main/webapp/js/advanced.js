document.addEventListener('DOMContentLoaded', () => {
  // Get references to all the necessary DOM elements
  const textInput = document.getElementById('textInput');
  const resultOutput = document.getElementById('resultOutput');
  const clearBtn = document.getElementById('clearBtn');
  const encryptBtn = document.getElementById('encryptBtn');
  const decryptBtn = document.getElementById('decryptBtn');
  const copyBtn = document.getElementById('copyBtn');
  const algorithmOptions = document.getElementsByName('algorithm');

  // Event listener for the "Clear" button to clear input and output fields
  clearBtn.addEventListener('click', () => {
      textInput.value = '';
      resultOutput.value = '';
  });

  // Event listeners for the "Encrypt" and "Decrypt" buttons to process the text
  encryptBtn.addEventListener('click', () => processText('encrypt'));
  decryptBtn.addEventListener('click', () => processText('decrypt'));

  // Event listener for the "Copy" button to copy the result to the clipboard
  copyBtn.addEventListener('click', () => {
      resultOutput.select();
      document.execCommand('copy');
      alert('Result copied to clipboard!');
  });

  // Asynchronous function to handle text processing (encryption/decryption)
  async function processText(operation) {
      const text = textInput.value;
      const algorithm = getSelectedAlgorithm();

      // Check if the selected algorithm should be processed client-side
      if (algorithm === 'caesar' || algorithm === 'base64') {
          resultOutput.value = clientSideProcess(text, algorithm, operation);
      } else {
          // If not client-side, send a request to the server for processing
          try {
              const response = await fetch('process', {
                  method: 'POST',
                  headers: {
                      'Content-Type': 'application/x-www-form-urlencoded',
                  },
                  // Send the text, algorithm, and operation as request parameters
                  body: `text=${encodeURIComponent(text)}&algorithm=${algorithm}&operation=${operation}`,
              });
              const result = await response.text();
              resultOutput.value = result;
          } catch (error) {
              console.error('Error:', error);
              resultOutput.value = 'An error occurred during processing.';
          }
      }
  }

  // Function to get the currently selected algorithm from the radio buttons
  function getSelectedAlgorithm() {
      for (const option of algorithmOptions) {
          if (option.checked) {
              return option.value;
          }
      }
  }

  // Function to handle client-side processing for Caesar and Base64 algorithms
  function clientSideProcess(text, algorithm, operation) {
      if (algorithm === 'caesar') {
          // Use the Caesar cipher for encryption/decryption
          return caesarCipher(text, operation === 'encrypt' ? 3 : -3);
      } else if (algorithm === 'base64') {
          // Use Base64 encoding/decoding
          return operation === 'encrypt' ? btoa(text) : atob(text);
      }
  }

  // Function to implement the Caesar cipher
  function caesarCipher(str, shift) {
      return str.replace(/[a-z]/gi, letter =>
          String.fromCharCode((letter.charCodeAt(0) - 65 + shift + 26) % 26 + 65)
      );
  }
});