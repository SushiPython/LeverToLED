import pyfirmata
import time
from flask import Flask

board = pyfirmata.Arduino('COM3')
app = Flask(__name__)


@app.route('/on')
def on():
    board.digital[13].write(1)

@app.route('/off')
def off():
    board.digital[13].write(0)

app.run(host='0.0.0.0', port=8080)
