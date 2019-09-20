
import socket, sys, time

host = sys.argv[1]
textport = sys.argv[2]
numberOfSends = int(sys.argv[3])

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
portSend = int(textport)
server_address = (host, portSend)

while 1:
    print ("Enter data to transmit: ENTER to quit")
    data = sys.stdin.readline().strip()
    if not len(data):
        break
    for i in range(numberOfSends):
        prompt=str(i+1)
        data=data+prompt
        s.sendto(data.encode('utf-8'), server_address)
        data=data[:-1]
        buf, address = s.recvfrom(portSend)
        if not len(buf):
            break
        print ("Received %s bytes from %s %s: " % (len(buf), address, buf ))
s.shutdown(1)