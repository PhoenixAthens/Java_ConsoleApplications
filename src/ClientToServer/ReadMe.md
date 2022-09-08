# Creating a CLient to Server Connection
> 
> ##### Taken from GeeksForGeeks

## The package consists of three classes:
> 1. Client
> 2. Server
> 3. Main
## class: Client
> Class Client creates a client that connects and communicates with the Server( Object of class server) identified 
> through its IP address, the message sent via terminal from classs client are visible on the terminal of class server
> ** Typing Over in client's terminal severs the client-server connection! **
## class: Server
> Class Server creates a server that accepts any client request coming its way,
## to make your machine both a client and the server:
> First compile and run class Server, then compile and run class Client such that both classes are running 
> simultaneously. Once both classes are running simultaneously and no exception occurs while executing either client or 
> Server. A Client-Server connection is established the client and server can then communicate.
## Problems I faced
> When using the same machine as both client and server, BindingException can occur, according to StackOverflow, such
> exception occurs when the socket and serverSocket are not closed properly, to prevent such 
> exception both socket and serverSocket should be closed in the finally block.
### however the solution didn't work for me!!
### the solution which did work was establishing a separate device as Server
> To prevent BindingException, I compiled the Server side code on a separate device. This prevented BindingException
> and the Client-Server connection was properly established!!