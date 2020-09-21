# job_recommendation
http://3.15.217.103/jupiter/index.html#

Used technologies:
 - Apache Tomcat: an environment to run web services
 - Java Servlet: handle RPC on the server-side
 - Github Job API: get posted job data
 - MonkeyLearn API: extract keywords from text by using TF-IDF algorithm
 - Jackson library: parse JSON
 - Amzon RDS: store data in MySQL database
 - AWS EC2: manage web service
 - HTML/JS/CSS/Ajax: Frontend
 
 ![myfavorite.png](img/myfavorite.png?raw=true "Title")
 
 ![recommendation.png](img/recommendation.png?raw=true "Title")

Dev Guide
1. Monkey Learn API
 - Open https://app.monkeylearn.com/accounts/register/, use your own email to register
 - You will use your own API key and Model ID in MonkeyLearnClient class

2. Create MySQL DB Instance on RDS
 - go to http://aws.amazon.com, sign into your account and then open the RDS dashboard. 
 - Choose MySQL as your engine type and make sure MySQL version is at least 8.0.

3. View Database in IntelliJ IDEA
 - Go the the menu File, then New, then select New Data Source, then MySQL
 - Fill the information for your database connection. The required is Host, User, Password, and Database.
 - click Test Connection


