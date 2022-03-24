
# UoB SPE Planning inspectorate

<img width="1125" alt="demo image" src="https://user-images.githubusercontent.com/43220609/154694239-1e6750a4-d5aa-45b3-8541-1d598cde2268.png">

## Background
### Context
This project was created to optimise the workflow of the Planning Inspectorate group when consulting the relevant organisations on planning permission. The project involves a web app that connects to a backend that can perform various relevant processes more efficiently than was previously possible. Examples of this are automatically parsing and processing Excel files and maintaining a master database of consultees.

### User Stories
* When a new building is to be developed the planning inspectorate need to authorise it. This requires permission from all goverment bodies within a 15 mile radius. The list of consultees is prepared by uploading a shape file to GIS software which compares it against datasets and outputs the relavent data in a spreadsheet. This then requires a series of manual applicability tests to be applied from the legal regulations to complete the consultation list.

* The time it takes to manually compile consultation lists during pre-application and to conduct/monitor the consultation process. Therefore an automated solution that refreshes and enhances the EST GIS consultation tool and reduce the time taken to identify relevant consultation bodies for Nationally Significant Infrastructure Projects (NSIPs) and compile consultation body lists would be of great convenice. 

## Tech Stack
* Rest API backend created in Springboot
* HMTL, CSS and JS frontend making heavy usage of the Google MDL (medium design language) library for accessabillity and consistency
* Postgres DB for the persistent storage component of the project

## Dependencies
* JDK 17

## Running Locally for Development (InteliJ recommended but not required)
1. Clone this repository into a local destination
```
git clone https://github.com/spe-uob/2021-PlanningInspectorate.git
```
3. Install [Postgres DB V14](https://www.postgresql.org/download/)
> Follow the default instructions and either user the default username and passwords or create your own. If using a custom password then update the following in application.properties in the springboot project (this is only for development, in deployment environment variables will be used)  
4. Ensure [JDK 17](https://openjdk.java.net/install/) is installed on the machine, this can be done via the link or in InteliJ autmatically when the project is loaded (recommended)
5. The project is now configured correctly and can be run using InteliJ (green play button) or on the command line as follow
``` 
mvn spring-boot:run 
```

## Deployment Instructions (IBM Cloud)
### Springboot Deploy
* 1
* 2
* 3
* 4

### Postgres Db Deploy
* 1
* 2
* 3
* 4

