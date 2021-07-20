# CRM
Customer Relationship Management Application

Mission: Our CRM application has a simple goal. To help companies stay connected with their customers and strealine information.

  - The CRM system consists of a Server and a Client. The Server stores and processes data that connected Clients perform.
  - Tasks include: customer contacts, editing those customer connections by adding records and forming groups of customers based on some criteria.

## Setup

(From Eclipse IDE)

```
File -> Import -> Git -> Projects From Git -> Clone URI -> (Copy https://github.com/CSUEB-CS401-Summer2021-Group3/CRM.git into URI textfield - should auto fill other parts) -> Enter github credentials -> Click next and follow prompts
```

## Build
Change directory to the base of the github repo (Where all the folders are listed such as Documents, src, etc)
Windows

Using command line:

```
javac -d bin -cp .\src\main\java\edu\cs401group3\crm\client\Client.java .\src\main\java\edu\cs401group3\crm\common\Log.java .\src\main\java\edu\cs401group3\crm\common\message\AuthenticationMessage.java .\src\main\java\edu\cs401group3\crm\common\message\CommandMessage.java .\src\main\java\edu\cs401group3\crm\common\message\Message.java .\src\main\java\edu\cs401group3\crm\common\message\MessageInterface.java .\src\main\java\edu\cs401group3\crm\common\message\StorageMessage.java .\src\main\java\edu\cs401group3\crm\server\Server.java .\src\main\java\edu\cs401group3\crm\server\clienthandler\ClientHandler.java .\src\main\java\edu\cs401group3\crm\server\storage\StorageManager.java .\src\main\java\edu\cs401group3\crm\server\storage\StorageQueue.java
```

This builds all the current Java classes

(Need to setup build configuration)



## Running CRM

### Server 
```
java -cp bin edu.cs401group3.crm.server.Server
```
### Client 
```
java -cp bin edu.cs401group3.crm.client.Client
```

## How to Contribute

**Have a test plan for each module you implement**

**Document your code**

1. Review the design document
2. Determine which component you wish to work on
3. Create an issue on github detailing what component you are implement, add rest of team to the issue, assign it to yourself.
4. Create a new branch - the name of the branch should be the issue number like "is_xxx"
5. Work on the implementation (in your seperate branch)
6. Do a pull request
7. Everyone in the team needs to approve the pull request
