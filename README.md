# Java-Client-Server-Socket-program
Simple client and server socket code where the socket acts as a data pump, creating a string of random data. The socket is currently set to port 8000.
There is a timer that runs the duration of the Server Socket send, set in the code. The data is comma delimited, and the server socket string ends with an EOF.
There are a few different configurations of Client Socket. The matched pair that I used was ServerSocket and ClientSocketOne.java.
I put these together for Android test purposes so they are not very robust applications. Take care to close the sockets so nothing hangs. 
