import socket
import threading
import os

TCP_PORT = 3000  # Порт для TCP-соединения с сервером
UDP_GROUP = ('233.0.0.1', 1503)  # Группа для приема сообщений по UDP

def listen_udp(udp_socket: socket.socket):
    while True:
        msg, _ = udp_socket.recvfrom(1024)
        print('\r\r' + msg.decode('ascii') + '\n' + f'you: ', end='')


def connect():
    tcp_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    tcp_socket.connect(('127.0.0.1', TCP_PORT))

    threading.Thread(target=listen_tcp, args=(tcp_socket,), daemon=True).start()

    while True:
        msg = input(f'you: ')
        tcp_socket.send(msg.encode('ascii'))


if __name__ == '__main__':
    os.system('clear')
    print('Welcome to chat!')
    connect()
