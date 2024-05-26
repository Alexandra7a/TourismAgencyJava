<h1> My Client-Server Tourism Agency Application</h1>
<h3>🎯 Purpose: </h3>
<p>The project aims to build an employee dedicated application to help manage the tourists eager to choose a trip from the agency's database</p>

<h3>👩🏻‍💻 Technology Used:</h3>
<p>I worked in java for this one. As a build tool I used Gradle</p>
<h3>📋 The structure of the project</h3>
<p>The project is organized in Modules:
<ul>
<li>Client Modul - responsible for client-side</li>
<li>Model Modul - keeps all the domain's entities</li>
<li>Services Modul - define interfaces to help the synchronization of the parties involved</li>
<li>Persistence Modul - realise connection to DB and keeps all repositories</li>
<li>Server Modul - provide the required services for the clients</li>
<li>Networking Modul - all common aspects between the client and server, containing classes such as Remote Proxy on client's behalf and Worker on server's</li>

</ul>

</p>
<p>
  <h3>Proto Buffer addition:</h3>
  <p>The Proto Buffer facilitate the possibility of connecting different language implementation for client and server. I chose the server to be in C# and the client in Java.</p><br>
  The Java project for the server is <a href="https://github.com/Alexandra7a/TourismAgencyCSharp.git">here</a>
</p>
