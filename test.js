//Import Socket.io module
var io = require('socket.io');
//Creates a HTTP Server
var socket = io.listen(8124);
//Bind the Connection Event
//This will be fired every time when a new connection is made
/* Include required libraries */
var mqtt = require('mqtt');
var dgram = require("dgram");
var port = 1883
    host = '130.102.128.123'
sendStr = "Receiving Data"
var data = {};

client = mqtt.createClient(port, host, function(err, client) {
	if (err) process.exit(1);
    client.connect({keepalive: 3000});

    client.on('connack', function(packet) {
        if (packet.returnCode === 0) {
            console.log('connected')
        } else {
            console.log('connack error %d', packet.returnCode);
            process.exit(-1);
        }
    });
	
    client.on('close', function() {
        process.exit(0);
    });
	
	client.subscribe({topic: '/clicker/data', qos: 0});

    client.on('error', function(e) {
        console.log('error %s', e);
        process.exit(-1);
    });
});

socket.sockets.on('connection',function(socket){
 
        //This will be fired when data is received from client over a single socket
        socket.on('message', function(msg){
            console.log('Received message from client ',msg);
        });
		client.on('publish', function(packet) {
			sendStr = packet.payload;
			socket.emit('greet',{hello: sendStr});
			//server.broadcast(sendStr);
			/* Log the message to the console */
			console.log(sendStr);
		});
        //Emit a message to client
        
        //This will fire when the client has disconnected
        socket.on('disconnect', function(){
            console.log('Server has disconnected');
        });
});