# Group Chat Application

This project is a simple group chat application implemented in Java. It allows multiple clients to connect to a server and communicate with each other in real time. The server broadcasts messages from one client to all others connected to the chat.

## Features

- Multi-client group chat.
- Clients can send messages that are broadcast to all connected users.
- Handles client disconnections gracefully.
- Easy to run and use.

## Requirements

- Java Development Kit (JDK) 8 or above.
- Basic knowledge of how to run Java programs.

## Files

1. **Server.java**:
   - Implements the server-side logic to accept client connections and delegate message handling.

2. **Client.java**:
   - Represents the client-side logic to connect to the server and send/receive messages.

3. **ClientHandle.java**:
   - A thread handler for managing individual client connections on the server side.

## How It Works

1. The `Server` listens for incoming connections on port 4000.
2. When a client connects, a new `ClientHandle` thread is created to manage communication with that client.
3. The `ClientHandle` thread listens for messages from its client and broadcasts them to all other connected clients.
4. Clients use the `Client` class to connect to the server and participate in the chat.

## Usage

### Step 1: Start the Server
1. Compile the `Server.java` and `ClientHandle.java` files.
2. Run the `Server` class:
   ```bash
   java CHAT.Server
   ```

### Step 2: Start the Clients
1. Compile the `Client.java` file.
2. Run the `Client` class for each client:
   ```bash
   java CHAT.Client
   ```
3. The client will display:
   ```
   Connected to Group chat...
   ```
4. Clients can type messages, and these will be broadcast to all connected clients.

### Example Interaction
- Client 1 sends: `Hello, everyone!`
- All other clients receive: `Hello, everyone!`

### Step 3: Disconnecting
- If a client disconnects, a message is printed on the server console indicating the disconnection.

## Implementation Details

- **ServerSocket**: Used to listen for client connections.
- **Socket**: Represents the connection between a client and the server.
- **DataOutputStream**: Sends data from server to clients.
- **Scanner**: Reads input from clients.
- **Thread**: Handles each client connection concurrently.
- **List**: Maintains the list of connected clients for broadcasting.

## Error Handling

- Handles client disconnection with appropriate cleanup.
- Prevents sending messages to disconnected clients.

## Improvements

- Add authentication for clients.
- Include private messaging features.
- Improve user interface for clients.
- Add logging for server and client activities.

## Contributing

Contributions are welcome! Feel free to submit issues or pull requests.

## License

This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT).

---

Happy coding!

