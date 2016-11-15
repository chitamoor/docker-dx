<!-- .slide: data-transition="slide-in fade-out" -->
Docker Based Development Workflow
==

### Improving the development experience

---

<!-- .slide: data-transition="concave" -->
## Developer Environment

* Checkout code 
<!-- .element: class="fragment" --> 
* Configure your env 
<!-- .element: class="fragment" --> 
* Provision datastore and dependent services 
<!-- .element: class="fragment" --> 
* Start the application or service, or set of services 
<!-- .element: class="fragment" --> 
* Run tests
<!-- .element: class="fragment" --> 
* Troubleshoot, debug your application, service etc
<!-- .element: class="fragment" --> 

---
<!-- .slide: data-transition="convex" -->
Goals
==
1. To create a few abstractions to help a developer think about his/her local development workflow 
<!-- .element: class="fragment" -->

2. To provide a simple scaffolding to control the local development workflow 
<!-- .element: class="fragment" -->

   
---

<!-- .slide: data-background="#000055" -->
Key Concepts
==
- Application Stack <!-- .element: class="fragment" data-fragment-index="1" --> 
- Service  <!-- .element: class="fragment" data-fragment-index="2" -->  
- Lifecycle of the Stack/Service <!-- .element: class="fragment" data-fragment-index="3" -->  


---

## Application Stack     

- Primary Service (and the corresponding DataStore)
<!-- .element: class="fragment" -->
- Dependent Services (and their data stores)
<!-- .element: class="fragment" -->

---
<!-- *template: invert -->

## Lifecyle of an Application Stack     
- **Init : ** 
  Initialize the environment
<!-- .element: class="fragment" -->

- **Start/Stop/Restart : **
  Start/Stop/Restart the primary service and all the dependent services
<!-- .element: class="fragment" -->

- **Cleanup : **
  Clean up after yourself
<!-- .element: class="fragment" -->

---

## Lifecyle of a Service

- **Build the Service**
  **Build the (Docker) image** of the Service. This includes generating all the artifacts 
  (war, jar, zip, tar  etc)
<!-- .element: class="fragment" -->

- **Start/Stop/Restart Service**
  **Launch  a (Docker) container** from the image
<!-- .element: class="fragment" -->


---
<!-- *template: invert -->

## Application Stack and Service Dependecies

(Docker to start/stop services. But what about the application stack?)


### docker-compose
<!-- .element: class="fragment" -->

The benefits of docker-compose are two fold - 
- Define the services and dependencies
<!-- .element: class="fragment" -->
- Control the lifecyle of the Stack/Services
<!-- .element: class="fragment" -->

---
<!-- *template: invert -->

## What about Data?

- **Datastore (RDB, NoSql etc) is just another service**
- **Requires few additional steps**
  -  Seed the DB
  -  Upgrade the DB (run migrations)
   
---
<!-- *template: invert -->

devctl
===

The scaffolding that enables the development workflow
- Launch/shutdown the **application stack**
- Start/Stop individual services
- Provision/Update the DB
- Other utility methods


---
<!-- *template: invert -->

devctl examples
===

##### Start/Stop Stack
```javascript
devctl start-stack
devctl stop-stack
```


##### Start/Stop Service

```javascript
devctl start-service <service_name>
devctl stop-service <service_name>
```
By default starts/stop the **primary service**

---
<!-- *template: invert -->

## devctl DB commands

**Build the DB image:** 
``` devctl build-db  ```

**Start/Stop primary DB service:**   
```devctl build-db ```

**Populate existing DB instance:**   ```devctl populate-db ```

---
<!-- *template: invert -->

### Reference Implementation

```
https://github.disney.com/ST/o2i-docker-scripts
```

![](./md/o2i-docker-scripts.png)







