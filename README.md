# My Client-Server Tourism Agency Application

## 🎯 Purpose:
The project aims to build an employee dedicated application to help manage the tourists eager to choose a trip from the agency's database.

## 👩🏻‍💻 Technology Used:
I worked in java for this one. As a build tool I used Gradle. I worked with Rest services and I built a React client to connect to a siml=ple CRUD version of the project.

## 📋 The structure of the project
The project has two phases. One more complexe which aims to emphasise the client-server communication and one for Web purposes, introducing Rest and React.
# *FIRST*
The project is organized in Modules:
- **Client Modul** - responsible for client-side
- **Model Modul** - keeps all the domain's entities
- **Services Modul** - define interfaces to help the synchronization of the parties involved
- **Persistence Modul** - realise connection to DB and keeps all repositories
- **Server Modul** - provide the required services for the clients
- **Networking Modul** - all common aspects between the client and server, containing classes such as Remote Proxy on client's behalf and Worker on server's

#### Proto Buffer addition:
The Proto Buffer facilitate the possibility of connecting different language implementation for client and server. I chose the server to be in C# and the client in Java.
The Java project for the server is [here](https://github.com/Alexandra7a/TourismAgencyCSharp.git)
#### The idea behind Proto Buffer
The `.proto` file is where the classes I want to work with are defined in a special structure as messages. 
```protobuf
message Employee {
  string username=1;
  string password=2;
}
```
Once done a command must be executed with proto compiler. It specifies the location and name where the two NO EDITABLE files must go. They are there to help the conversion between the programming language and proto syntax and vice versa.

# *SECOND*
The purpose of the second part of the project is the web functionalitie. So I chose to make a CRUD application which uses the data from the main project.
## Rest Services
The rest services facilitate the requests for data using HTTP protocol and methods(DELETE,PUT,GET,POST and so on)


