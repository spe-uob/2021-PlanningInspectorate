
# UoB SPE Planning inspectorate

<img width="1125" alt="demo image" src="https://user-images.githubusercontent.com/43220609/154694239-1e6750a4-d5aa-45b3-8541-1d598cde2268.png">

## Background
### Context
This project was created to optimise the workflow of the Planning Inspectorate group when consulting the relevant organisations on planning permission. The project involves a web app that connects to a backend that can perform various relevant processes more efficiently than was previously possible. Examples of this are automatically parsing and processing Excel files and maintaining a master database of consultees.

 When a new building is to be developed the planning inspectorate need to authorise it. This requires permission from all goverment bodies within a 10 kilometer radius. The list of consultees is prepared by uploading a shape file to GIS software which compares it against datasets and outputs the relavent data in a spreadsheet. This then requires a series of manual applicability tests to be applied from the legal regulations to complete the consultation list.

The time it takes to manually compile consultation lists during pre-application and to conduct/monitor the consultation process. Therefore an automated solution that refreshes and enhances the EST GIS consultation tool and reduce the time taken to identify relevant consultation bodies for Nationally Significant Infrastructure Projects (NSIPs) and compile consultation body lists would be of great convenice. 

### User Stories

A member of the planning inspectorate team should be able to:

* Add, remove or update people, departments and organisations in the database. They can also edit the relationships between them.
* Search for relations between people, departments and organisations based on any relevant field in the database.
* Create a one time pin to allow a person to edit their data without accessing anyone elses.

## Documentation, class, architecure and sequence diagrams
[Documentation](https://github.com/spe-uob/2021-PlanningInspectorate/blob/11a1a06bcd191bbe62796b09e543b33dbf3c6311/docs/Planning%20Inspectorate%20Documentation.docx)

## Tech Stack
* Rest API backend created in Springboot
* HMTL, CSS and JS frontend making heavy usage of the Google MDL (medium design language) library for accessabillity and consistency
* Postgres DB for the persistent storage component of the project

## Dependencies
* JDK 17
* Postgres 14

## Running Locally for Development (InteliJ recommended but not required)
1. Clone this repository into a local destination
2. Install [Postgres DB V14](https://www.postgresql.org/download/)
> Follow the default instructions and either user the default username and passwords or create your own. If using a custom password then update the following in application.properties in the springboot project (this is only for development, in deployment environment variables will be used)  
4. Ensure [JDK 17](https://openjdk.java.net/install/) is installed on the machine, this can be done via the link or in InteliJ autmatically when the project is loaded (recommended)
5. The project is now configured correctly and can be run using InteliJ (green play button) or on the command line as follow
``` 
mvn spring-boot:run 
```

## Deployment Instructions 
### AWS app + db coupled:
#### Assumed Knowledge:
1. Able to create an AWS EC2 instance and access it via ssh
2. Familiarity with altering spring boot application.properties

#### Instructions:
1. Access your AWS dashboard and spin up an EC2 compute instance
2. Clone this repo using
```
git clone https://github.com/spe-uob/2021-PlanningInspectorate.git
```
3. Open in your editor of choice and navigate to ```src/main/resources/application.properties``` and edit the spring datasource parameters to connect to localhost
4. Locally compile the application by using
``` 
mvn clean package -DskipTests=True
```
5. You now need to get this Jar file onto the EC2 instance. There are several ways to do this including ftp but we reccommend connecting via [WinSCP](https://winscp.net/eng/index.php) and using the .pem access key provided by amazon (if not using windows, there are various other ways and tutorials on how to copy the jar to AWS )
6. Next we need to setup the EC2 instance by pasting the following commands
```
sudo tee /etc/yum.repos.d/pgdg.repo<<EOF
[pgdg13]
name=PostgreSQL 13 for RHEL/CentOS 7 - x86_64
baseurl=https://download.postgresql.org/pub/repos/yum/13/redhat/rhel-7-x86_64
enabled=1
gpgcheck=0
EOF
```
Then update the system
```
sudo yum update
```
And install and configure postgres service (run these commands line by line)
```
sudo yum install postgresql13 postgresql13-server
sudo /usr/pgsql-13/bin/postgresql-13-setup initdb
sudo systemctl start postgresql-13
sudo systemctl enable postgresql-13
sudo passwd postgres
su - postgres
psql -c "ALTER USER postgres WITH PASSWORD 'WHAT-YOU-SET-SPRING-DATASOURCE-PASSWORD-TO';"
```
7. Now postgres is running we can launch the spring app, to do this java needs installing via 
```sudo yum install java```
8. Finally to launch the application run (ensuring the path to the compiled .jar file is correct)
```java -jar planningInspectorate-0.0.1-SNAPSHOT.jar```
9. To access the application setup the EC2 security group to allow access on port 8080 and enter the public ipv4 address with :8080 into you search bar.
