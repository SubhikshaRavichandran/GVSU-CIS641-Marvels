# Overview
In a summary, an online reservation system adds a booking facility to the website and allows you to provide hassle-free booking to your customers. Moreover, if they want to book a badminton court, they do not need to call and make an appointment; rather, they can simply choose the desired date and time and confirm the booking after making a successful advance payment. That is exactly what the play spots Badminton ground booking. If you want to book a pitch at any of our partner facilities, we make it quicker than ever. 
This documents depicts about the Software Requirements, Change Management Plans, Traceability and Software Artifacts.

# Software Requirements
Here we detail the expected system behavior and list the features that will be made available to Badminton court booking customers. The needs of the end-user are specified in the section labeled "functional requirements." The user assumption is laid out in the non-functional requirements section, and it applies to the entire system.

## Functional Requirements
### 1. Login / Register 
| ID  | Requirement              |
| :-------------: | :----------: |
| FR1 | To book the court, the user shall need to log in.|
| FR2 | If the user shall has not previously used this account or application. When the user attempts to log in, a choice that is labeled " sign up page" must be presented to them. When he goes to the sign-up page and clicks on it. The registration page needs to be made available.|
| FR3 | In registration page, there will be multiple fields to enter the details of the user. For few fields there shall be validation for email and password.|
| FR4 | Following a successful log in, the program will navigate back to the homepage. The user data shall must be validated from the database before the application may proceed.|
| FR5 | Users shall view all of the available customizable features for the application from the website.|


### 2. Home Page 
| ID | Requirement |
| :-------------: | :----------: |
| FR6 | The user shall be brought to the homepage once they have successfully logged in.|
| FR7 | The user shall edit his/her profile if they want to change their personal information.|
| FR8 | If the user changes any information in their profile, the changes shall be made, and they will be redirected to the home page. |
| FR9 | Once the user has cancelled their court booking, the user shall be redirected to the home page. |
| FR10| After the user has successfully registered, the email confirmation shall be sent to the user's inbox. |



### 3. Booking Activity 
| ID | Requirement |
| :-------------: | :----------: |
| FR11 |  When the user presses the search key, the courts shall be displayed on the screen.|
| FR12 |  When the user presses the information of the court, the display shall update to include the date, the time, and the location. |
| FR13 |  The user shall have access to select the size of the court according to their preferences.|
| FR14 |  The user shall have access to delete their court booking.|
| FR15 |  Once the user shall done with their payment for their court, the booking in the cart will be moved to the orders section.|



### 4. Court Booking Page 
| ID | Requirement |
| :-------------: | :----------: |
| FR16 |  The date, the time, and the place shall be displayed on the screen after the user presses the information of the court button.|
| FR17 |  During the booking process, the clients shall be required to confirm the number of people that will be using the court. |
| FR18 |  The user shall be able to see the court pitch price according to the No. of individuals. |
| FR19 |  After booking the court user shall be able to change the location. |
| FR20 |  After logging out, the booking cart shall retain a user's court booking activity. |



### 5. Payment 
| ID | Requirement |
| :-------------: | :----------: |
| FR21 |  The user shall be responsible for making the payment using the online payment method. |
| FR22 |  The user shall be brought to the Payment page after they have booked the court. |
| FR23 |  The user shall be able to view the booking confirmation after the money has been made. |
| FR24 |  The price shall fall to a lower level as the number of people who purchase it rises. |
| FR25 |  The user shall be taken directly to the orders page once the court fee has been completed. |



## Non-Functional Requirements
### 1. Reliability
| ID | Requirement |
| :-------------: | :----------: |
| NFR1 |  The data usage for booking shall be relatively minimal for customers. |
| NFR2 |  When numerous users are accessing the program, there shall be no interruptions. |
| NFR3 |  The program shall be web and mobile compatible. |
| NFR4 |  TThe user interface shall facilitate simple navigation. |
| NFR5 |  The data usage for booking shall be relatively minimal for customers. |


### 2. Scalability 
| ID | Requirement |
| :-------------: | :----------: |
| NFR6 |  Any server issue or technical issue with the application shall be resolved by contacting customer service and support. |
| NFR7 |  If the user wants to change the password of the Application, the user shall get a email verification to change the password. |
| NFR8 |  The price shall decrease as the number of individuals increases. |
| NFR9 |  This application shall refers to the ease with which a system may communicate data and information with other computers and devices that are not part of the system.|
| NFR10 | The price shall fall to a lower level as the number of people who purchase it rises. |


### 3. Performance
| ID | Requirement |
| :-------------: | :----------: |
| NFR11 |  The page shall load in fractions of a second as opposed to any delay.|
| NFR12 |  A graphical user interface shall make searching for courts simple on both the mobile app and internet. |
| NFR13 |  The system shall needs to display the specifics of the information that has been modified. |
| NFR14 |  After pressing the button to reset the password, a temporary password shall be emailed to the user with a duration of few mins. |
| NFR15 |  When selecting the court date and time user shall use Google Maps to enter the precise location. |


### 4. Security
| ID | Requirement |
| :-------------: | :----------: |
| NFR16 |  In terms of security, the user shall be provided with the code for resetting the password.|
| NFR17 |  If a person fails to log in after multiple attempts, the account shall be disabled. |
| NFR18 |  When a user creates an account, they shall receive an email indicating that they have successfully logged in. |
| NFR19 |  The user's passwords and account information as well as their banking information shall be protected. |
| NFR20 |  To ensure the user's privacy and safety, the code needed to reset the password shall be delivered to the user. |


### 5. Usability
| ID | Requirement |
| :-------------: | :----------: |
| NFR21 |  When numerous users are accessing the program, there shall be no interruptions. |
| NFR22 |  The program shall be designed to be user-friendly, making it simple for customers to interact. |
| NFR23 |  The system shall ought to display all of the relevant information regarding the court. |
| NFR24 |  The program shall require to provide a consistent viewing effect across all of its users. |
| NFR25 |  Using the "First Come, First Served" method is a part of court booking helps sort things out. So, it shall be simple to check data from beginning to end. |


## Change management plan :

This section will talk about a plan for handling changes to the Badminton court booking application. It will focus on training users, making sure the court is available, making sure it works well, and fixing problems.

## Training Strategy :

- Firstly, the user must sign up or login by entering the required details.
-	If the user is new to the application, they will sign up by entering the required fields
-	If the user has already signed up before they can simply login to the application 
-	Then the user will be directed to the home page, where the available courts will be displayed for the users to select.
-	The user can select the Required court by choosing the basic requirements displayed in the homepage
-	Here the user can select the court size and the number of players they want to play.
-	After choosing the court with their requirements, the amount to be paid for their court will be displayed.
-	The user will be redirected to the payment page where they can choose the method of payment i.e. debit card or credit card and proceed with the payment.
-	Followed by this the customer will receive a confirmation regarding their court.
-	They will even receive a confirmation mail for the same.
-	There after the user can also access to the orders, that is the courts they have booked in their order history.
-	This application is responsive UI.

## Integration within ecosystem / software :

-	Our application is user friendly
-	Our Application ensures that the customer can login into our website easily
-	If customer is able to book the court then we can ensure that one of the functional requirements is working properly.
-	The output is being called with API and controllers that would execute and return methods for output results. 
-	The responses are being called from Html and CSS scripts. Multiple checks with user inputs and password validations. 
-	The web pages responses are being retrieved and to be checked the user feasibility.
-	Thus, this can be easily installed in any customer’s environment.

## Discovered Issues and Solution :
-	The technical team in the backend ensures that the application works properly.
-  The rental sales and services will be given to the customers if they need the equipment.

## Traceability links :

-  In this part, we show how the requirements relate to other project artifacts including class diagrams, Use case diagrams, and activity diagrams.

## Use Case Diagram Traceability :

| Artifact ID | Artifact Name | Requirement ID |
| :-------------: | :----------: | :----------: |
| UseCase1 | login/Register | FR1-5 |
| UseCase2 | Home Page | FR6-10 |
| UseCase3 | Booking Activity | FR11-15 |
| UseCase4 | Court Booking Page | FR16-20 |
| UseCase5 | Payment | FR21-25 |

## Class Diagram Traceability
| Artifact Name | Requirement ID |
| :-------------: |:----------: |
| user        | NFR2,7,12,14,15,16,18,19,20,24 FR1-5 |
| court       | NFR12,15,23,25 FR16-20 |
| Booking     | NFR1,5,25 FR11-15 |
| Fee         | NFR8,10 FR21-25 |


## Activity Diagram Traceability
| Artifact ID | Artifact Name | Requirement ID |
| :-------------: | :----------: | :----------: |
| 1. | New user/Signup | FR1,5, NFR7,14,20 |
| 2. | Old user/Homepage | FR2,3,4, NFR2,16,19 |
| 3. | Book an Appointment | FR16-20, NFR1,5,25 |
| 4. | logout | FR20, NFR3,5,21 |


# Software Artifacts
All of the application's artifacts, such as software and design documents, were supposed to be outlined in this section. We will also identify the functional and non-functional needs that should be coordinated with the artifacts. For your convenience, we've provided direct URLs to each required application artifact below.
* [Class Diagrams and Signatures](https://github.com/SubhikshaRavichandran/GVSU-CIS641-Marvels.github.io/blob/main/Docs/Class%20Diagrams%20and%20Signatures.pdf)
* [Class Diagrams](https://github.com/SubhikshaRavichandran/GVSU-CIS641-Marvels.github.io/blob/main/Docs/Class%20Diagrams.pdf)
* [CRC + Class Diagrams + Object Models](https://github.com/SubhikshaRavichandran/GVSU-CIS641-Marvels.github.io/blob/main/Docs/CRC%20%2B%20Class%20Diagrams%20%2B%20Object%20Models.pdf)
* [Database Table](https://github.com/SubhikshaRavichandran/GVSU-CIS641-Marvels.github.io/blob/main/Docs/Database%20Table.jpeg)
* [Sequence diagram & State Machine Diagram](https://github.com/SubhikshaRavichandran/GVSU-CIS641-Marvels.github.io/blob/main/Docs/Sequence%20diagram%20%26%20State%20Machine%20Diagram.pdf)
* [Term Project Interim Progress Marvels](https://github.com/SubhikshaRavichandran/GVSU-CIS641-Marvels.github.io/blob/main/Docs/Term%20Project%20Interim%20Progress%20Marvels.docx)
* [Use case Diagram and Activity Diagram](https://github.com/SubhikshaRavichandran/GVSU-CIS641-Marvels.github.io/blob/main/Docs/Use%20case%20Diagram%20and%20Activity%20Diagram.docx)


## Prerequisite

* The backend data base for this application on web based is with RDBMS–relational databases respective with the java model view control method to be loaded into web.

## Run Instructions

* In order to set up Java, you will need to use the Java Development Kit (JDK).
* Finally set the PATH and JAVA_HOME environment variables to refer to the directory that contains java and java_install_dir respectively.
* Need to Setup the Eclipse IDE.
* Need to install Apache Common Logging API.
* After you have successfully downloaded the installation, you will need to unpack the binary distribution into a location that is easily accessible.These jar files and supporting documents will be in this directory.
* After we have finished installing the Spring Framework Libraries, we will be able to move on to installing the Spring Framework itself.

