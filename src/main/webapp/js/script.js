document.addEventListener('DOMContentLoaded', () => {
    const textInput = document.getElementById('textInput');
    const resultOutput = document.getElementById('resultOutput');
    const clearBtn = document.getElementById('clearBtn');
    const encryptBtn = document.getElementById('encryptBtn');
    const decryptBtn = document.getElementById('decryptBtn');
    const copyBtn = document.getElementById('copyBtn');
    const algorithmOptions = document.getElementsByName('algorithm');

    clearBtn.addEventListener('click', () => {
        textInput.value = '';
        resultOutput.value = '';
    });

    encryptBtn.addEventListener('click', () => processText('encrypt'));
    decryptBtn.addEventListener('click', () => processText('decrypt'));

    copyBtn.addEventListener('click', () => {
        resultOutput.select();
        document.execCommand('copy');
        alert('Result copied to clipboard!');
    });

    async function processText(operation) {
        const text = textInput.value;
        const algorithm = getSelectedAlgorithm();

        if (algorithm === 'caesar') {
            // Client-side processing
            resultOutput.value = clientSideProcess(text, algorithm, operation);
        } else {
            // Server-side processing
            try {
                const response = await fetch('process', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                    },
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

    function getSelectedAlgorithm() {
        for (const option of algorithmOptions) {
            if (option.checked) {
                return option.value;
            }
        }
    }

    function clientSideProcess(text, algorithm, operation) {
        if (algorithm === 'caesar') {
            return caesarCipher(text, operation === 'encrypt' ? 3 : -3);
        }
    }

    function caesarCipher(str, shift) {
        return str.replace(/[a-z]/gi, letter =>
            String.fromCharCode((letter.charCodeAt(0) - 65 + shift + 26) % 26 + 65)
        );
    }
});

