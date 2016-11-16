<!-- .slide: data-background="http://www.wdwinfo.com/Photos/Desktops/Castle_FW_1920x1200.jpg" data-state="img-right" --> 
Improving the Developer Experience through Docker
==

---
<!-- .slide: data-background="http://www.wdwinfo.com/Photos/Desktops/Castle_FW_1920x1200.jpg"  --> 
## Rajeev Chitamoor <!-- .element: class="em2" -->
### Staff Engineer
![](./md/mickey_mouse-2.png)
### Walt Disney Studios
#### https://github.com/chitamoor 
<!-- .element: class="em2" -->
#### email: rajeev@chitamoor.com, rajeev.r.chitamoor@disney.com
<!-- .element: class="em2" -->


---
<!-- .slide: data-background="md/DMA.jpg" data-state="img-right" --> 
Asset Management  <!-- .element: class="orange_text" -->
==


---
<!-- .slide: data-background="https://media.giphy.com/media/catPp7OuPVeBG/giphy.gif" --> 
### "Developer Experience(DX) is the practice of understanding how developers get their work done and by extension, the practice of optimising that experience"

---
<!-- .slide: data-background-image="http://dcbanners.weebly.com/uploads/9/7/8/2/9782867/dc-movie-background.png" --> 
## On-boarding/Setting up the environment 
<!-- .element: class="fragment orange_text zoom-in" --> 
## Understanding of the Application Architecture
<!-- .element: class="fragment cyan_text zoom-in" --> 
## Minimizing the parity between local development and production environments	
<!-- .element: class="fragment orange_text zoom-in" -->

---
<!-- .slide: data-background="md/disgust.jpg" -->
# Setting up the Local Dev Environment!  
<!-- .element: class="fragment red_text place_bottom" -->

---
<!-- .slide: data-background="https://wallpaperscraft.com/image/background_tools_drawings_patterns_18527_2560x1080.jpg" -->
## Source Control Stuff!
<!-- .element: class="fragment orange_text place_left zoom-in" --> 
## Configure your application
<!-- .element: class="fragment place_left zoom-in" --> 
## Provision datastore and dependent services 
<!-- .element: class="fragment orange_text place_left zoom-in" --> 
## Control the lifecycle of the Application Stack
<!-- .element: class="fragment cyan_text  place_left zoom-in" --> 
## Run tests
<!-- .element: class="fragment orange_text place_left zoom-in" --> 
## Troubleshoot!
<!-- .element: class="fragment place_left zoom-in" --> 
---

<!-- .slide: data-background="md/architecture.jpg" -->
# Application Architecture

---
<!-- .slide: data-background-image="http://wondersofdisney.webs.com/pals/goofy/goofyshrug2.png" data-background-size="500px" data-background-position="0% 70%" -->
Works for me! <!-- .element: class="cyan_text place_right" --> 
==
     
---
<!-- .slide: data-background="md/containers.jpg" -->
Containers
==


---
<!-- .slide: data-background="https://s-media-cache-ak0.pinimg.com/736x/db/e9/a9/dbe9a9058c1929c7ab137cd136ddcf62.jpg" -->
### Docker containers wrap a piece of software in a complete filesystem that contains everything needed to run: code, runtime, system tools, system libraries – anything that can be installed on a server. 

### This guarantees that the software will always run the same, regardless of its environment.
<!-- .element: class="fragment cyan_text zoom-in" --> 

---
#### Dockerfile
![](./md/docker_dx_.jpg)

---
### docker-compose

#### Define the services and dependencies
<!-- .element: class="fragment cyan_text" -->
#### Control the lifecyle of the Stack
<!-- .element: class="fragment orange_text" -->
![](./md/docker-compose_yml.jpg)
   

---
<!-- .slide: data-background-image="https://images5.alphacoders.com/403/thumb-1920-403880.jpg" -->
### Docker tools 
<!-- .element: class="cyan_text place_left" --> 
### Dockerfile and Docker-compose
<!-- .element: class="cyan_text place_left" --> 

### Faster Application Setup
<!-- .element: class="fragment orange_text place_left zoom-in" --> 
### Increased Parity between Local and Prod 
<!-- .element: class="fragment orange_text place_left zoom-in" --> 

---
<!-- .slide: data-background-image="http://www.audienceseverywhere.net/wp-content/uploads/2014/10/Avengers_logo.jpg" -->
### There is no problem in computer science which cannot be solved by one more level of indirection

---
<!-- .slide: data-background="http://www.wdwinfo.com/Photos/Desktops/Castle_FW_1920x1200.jpg" data-state="img-right" --> 
Goals
==
### Opinionated framework to think about the application
<!-- .element: class="fragment cyan_text" -->

### A simple scaffolding to control the local development workflow 
<!-- .element: class="fragment orange_text" -->

---
<!-- .slide: data-background="http://www.wdwinfo.com/Photos/Desktops/Castle_FW_1920x1200.jpg" data-state="img-right" --> 
## Key Abstractions
### Service
<!-- .element: class="fragment cyan_text" -->  
### Application Stack
<!-- .element: class="fragment orange_text" --> 
### Lifecycle of the Stack/Service 
<!-- .element: class="fragment" -->  

---
<!-- .slide: data-background="http://www.wdwinfo.com/Photos/Desktops/Castle_FW_1920x1200.jpg" data-state="img-right" --> 
## Application Stack

### Primary Service and the corresponding data store(s)
<!-- .element: class="fragment orange_text" -->
### Secondary Services (and their data stores)
<!-- .element: class="fragment cyan_text" -->

---
<!-- .slide: data-background="http://www.wdwinfo.com/Photos/Desktops/Castle_FW_1920x1200.jpg" data-state="img-right" --> 

## Lifecyle of a Service

### Build the Service
<!-- .element: class="fragment orange_text" -->

### Start/Stop/Restart
<!-- .element: class="fragment orange_text" -->

### Cleanup
<!-- .element: class="fragment orange_text" -->

---
<!-- .slide: data-background="http://www.wdwinfo.com/Photos/Desktops/Castle_FW_1920x1200.jpg" data-state="img-right" --> 
## Lifecyle of an Application Stack     
### Initialize the environment
<!-- .element: class="fragment orange_text" -->

### Start/Stop/Restart all services
<!-- .element: class="fragment cyan_text" -->

---
<!-- .slide: data-background="http://www.wdwinfo.com/Photos/Desktops/Castle_FW_1920x1200.jpg" data-state="img-right" --> 
## What about Data?
### Datastore (RDB, NoSql etc) is just another service
<!-- .element: class="orange_text" -->
### Requires few additional steps
<!-- .element: class="cyan_text" -->
  *  Seed the DB
<!-- .element: class="orange_text place_left" -->
  *  Upgrade the DB (run migrations)
<!-- .element: class="orange_text place_left" -->

---
<!-- .slide: data-background-image="http://static.srcdn.com/wp-content/uploads/Chris-Evans-Captain-America-Trilogy.jpg" -->
devctl
==

### The scaffolding that enables the development workflow
<!-- .element: class="fragment highlight-red" -->

- #### Launch/shutdown the application stack
<!-- .element: class="fragment highlight-yellow" -->

- #### Start/Stop/Restart individual services
<!-- .element: class="fragment highlight-yellow" -->

- #### Provision the DB
<!-- .element: class="fragment highlight-yellow" -->

- #### Other utility methods
<!-- .element: class="fragment highlight-yellow" -->


---
<!-- .slide: data-background="http://www.wdwinfo.com/Photos/Desktops/Castle_FW_1920x1200.jpg" data-state="img-right" --> 
devctl examples
===

##### Start/Stop Stack
<!-- .element: class="orange_text" -->
```
  devctl start-stack
  devctl stop-stack
``` 

##### Start/Stop Service
<!-- .slide: data-background="http://www.wdwinfo.com/Photos/Desktops/Castle_FW_1920x1200.jpg" data-state="img-right" --> 

<!-- .element: class="cyan_text" -->

```javascript
devctl start-service <service_name>
devctl stop-service <service_name>
```
By default starts/stops the **primary service**

---
<!-- .slide: data-background="http://www.wdwinfo.com/Photos/Desktops/Castle_FW_1920x1200.jpg" data-state="img-right" --> 

## devctl DB commands
<!-- .element: -->

#### Build the DB image
<!-- .element: class="cyan_text place_left" -->
``` 
  devctl build-db  
```

#### Start/Stop primary DB service 
<!-- .element: class="cyan_text place_left" -->
```
  devctl start-db 
```

---
<!-- .slide: data-background="http://wallpapercraze.com/images/wallpapers/Tron%20Castle%20Wallpaper-868904.jpeg" data-state="img-right" --> 
### Reference Implementation
### https://github.com/chitamoor/docker_dx
<!-- .element: class="cyan_text place_left" -->

---
<!-- .slide: data-background="http://wallpapercraze.com/images/wallpapers/Tron%20Castle%20Wallpaper-868904.jpeg" data-state="img-right" --> 
#Demo Time!
![](./md/DXStack.jpg)

---
<!-- .slide: data-background="http://www.wdwinfo.com/Photos/Desktops/Castle_FW_1920x1200.jpg" data-state="img-right" --> 

### Primary Service 
<!-- .element: class="orange_text place_left" -->
#### /api/primary 
<!-- .element: class="cyan_text place_left" -->
#### /api/primary/resource/{id} 
<!-- .element: class="cyan_text place_left" -->
#### /api/primary/micro_one
<!-- .element: class="cyan_text place_left" -->
#### /api/primary/micro_one/resource/{id}
<!-- .element: class="cyan_text place_left" -->

### Micro One Service 
<!-- .element: class="orange_text place_left" -->
#### /api/micro_one 
<!-- .element: class="cyan_text place_left" -->
#### /api/micro_one/resource/{id} 
<!-- .element: class="cyan_text place_left" -->

### Micro Two Service
<!-- .element: class="orange_text place_left" -->
#### /api/micro_two 
<!-- .element: class="cyan_text place_left" -->
#### /api/micro_two/resource/{id} 
<!-- .element: class="cyan_text place_left" -->

---
<!-- .slide: data-background-size="600px" data-background-image="http://cdn.playbuzz.com/cdn/c6170ec5-1f85-4581-8dbc-14639a3eaa4d/4b79caa3-b4eb-405e-8476-c9e41c28210d.jpg" -->
---
![](https://s-media-cache-ak0.pinimg.com/564x/0b/70/af/0b70af5271733e76cf730ea066861c7a.jpg)
#### https://github.com/chitamoor/docker_dx
<!-- .element: class="orange_text" -->
#### rajeev@chitamoor.com, rajeev.r.chitamoor@disney.com
<!-- .element: class="cyan_text" -->

