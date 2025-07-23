from flask import Flask

app = Flask(__name__)

@app.route('/')
def home():
    return "Hello from DevOps Project!"

@app.route('/health')
def health():
    return "OK"

if __name__ == '__main__':
    app.run(host='127.0.0.1', port=5000, debug=True)
