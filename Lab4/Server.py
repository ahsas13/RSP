import socket
import threading
import os
import time

UDP_GROUP = ('233.0.0.1', 1503)  # Группа для рассылки сообщений по UDP

messages = []  # Список для хранения входящих сообщений
clients = set()  # Множество для отслеживания подключенных клиентов

def broadcast_udp():
    udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    udp_socket.bind(('0.0.0.0', UDP_GROUP[1]))
    udp_socket.setsockopt(socket.IPPROTO_IP, socket.IP_ADD_MEMBERSHIP, socket.inet_aton(UDP_GROUP[0]) + socket.inet_aton('0.0.0.0'))

    while True:
        time.sleep(10)
        if messages:
            msg_to_send = "\n".join([f"{msg[0]} ({time.time() - msg[2]:.2f} seconds ago)" for msg in messages])
            udp_socket.sendto(msg_to_send.encode('ascii'), UDP_GROUP)

def connect():
    threading.Thread(target=broadcast_udp, daemon=True).start()

    while True:
        pass

if __name__ == '__main__':
    os.system('clear')
    print('Server is running...')
    connect()
