# acmeweb
sample web server for class exercises on IoC, DIP, DI

This sample shows how to leverage the Spring framework, for simulating a production control server that reports on 
and manages other manufacturing servers, machinery and processes at the Acme Disk Drive company.

 The user can request a more detailed status, with information about the memory usage, extensions in use, and whether the server is operating normally.
 
 The user can also request the status of the disk
 
Syntax for URLS:
 *    All requests start with /server
 *    /status will give back status of server
 *    /status/detailed will give back the detailed server status
 *    a detailed server status request requires one or more of "memory", "extensions", or "operations" to be passed in
 *    /disk/status will give back status of disk
 *    a param of 'name' specifies a requester name to appear in response
 *
 * Examples:
 *    http://localhost:8080/server/status
 *
 *    http://localhost:8080/server/status?name=Noach
 *
 *    http://localhost:8080/server/status/detailed?operations,extensions,memory&name=Jeremy
 *
 *    http://localhost:8080/server/disk/status?name=Josh
 
 


