# UoB Software Engineering Project

## Planning inspectorate project

Tech Stack:
- MySQL database
- Spring Boot backend 

## User Stories:

When a new building is to be developed the planning inspectorate need to authorise it. This requires permission from all goverment bodies within a 15 mile radius. The list of consultees is prepared by uploading a shape file to GIS software which compares it against datasets and outputs the relavent data in a spreadsheet. This then requires a series of manual applicability tests to be applied from the legal regulations to complete the consultation list.

The time it takes to manually compile consultation lists during pre-application and to conduct/monitor the consultation process. Therefore an automated solution that refreshes and enhances the EST GIS consultation tool and reduce the time taken to identify relevant consultation bodies for Nationally Significant Infrastructure Projects (NSIPs) and compile consultation body lists would be of great convenice. 

## Website design flowchart:
Below is a flow chart detailing all the different pages of the website. Each of the pages has a mockup of how it should look and a feature list, see below. Each of the pages also has a list in the kanban board where all of the identified features are added as issues for the team to work on.

![website design](https://github.com/spe-uob/2021-PlanningInspectorate/blob/3d19de0dd1eb1d74e580a53fb4f8e9aa9a23b9a4/DesignChart.png)

## Page Mockup(AdobeXD)11.18.2021 ver.
https://xd.adobe.com/view/1d504e0c-3aca-471b-a12f-05ab70123066-4803/grid

## Page mockups and feature lists:
### Login Page:
lorem ipsum....

### Home Page:
![homepage mockup](https://github.com/spe-uob/2021-PlanningInspectorate/blob/2980b5d4c706ccf812f8bef5c6d9f353c73c91e8/Mockup_HomePage.png)
- Image of logo
- Create consultation list button that links to **Create Consultation List** page
- Create manage database/master consultation list button that links to **Crud Interface Page** page
- Create See responses of external contact detail updates button that links to **View 1 Time Update Links Progress** page


### Create Consultation List:
![create consultation list mockup](https://github.com/spe-uob/2021-PlanningInspectorate/blob/375ad4ae7de0c7ce3651856469bc988c491268d0/Mockup_CreateConsultationList.png)
- Image of logo that is a hyperlink back to **Home Page**
- Text field explaining what the upload button does and what the output will be
- Upload button that should allow the user to upload an excel file and then transfer that data to the backend for processing. This button should also cause a loading icon/display a loading screen before transfering to **Output Consultation List** once processing is done

### Output Consultation List:
Below is a basic mock up of the final output page consisting of the consulting bodies and their respective emails. We also have two buttons that allow us to generate an update database link and a view database option 

![output consultation list mockup](https://github.com/spe-uob/2021-PlanningInspectorate/blob/33382f32cd0b45bde557d928c33c63f5cb469f50/consultation%20output%20page.png)

### Crud Interface Page:
...

### View 1 Time Update Links Progress:
...
![Mockup_view_updatecontact](https://user-images.githubusercontent.com/30760730/142389155-00303f46-9611-40fa-b8a4-c34ecad3670c.png)
- Image of Logo / Highoerlink to **Homepage**
- Show total rate of responce
- Create manage database/master consultation list button that links to **Crud Interface Page** page
- Create View 1 Time Update Links Progress list
   - default: all(mvp)
     - day the 1-time link sent out
     - connsultees
     - emails
     - confirm botton (condition for deleting from this updated status list)

  - filter: not yet
  - filter: updated
  
