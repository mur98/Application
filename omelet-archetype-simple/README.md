omelet-example-dataset
======================
Sample example to showcase data driver testing using Omelet.
With this you can have multiple configuration for Browsers and Data ,
Build
---
1. Simple do **git clone https://github.com/springer-opensource/omelet-example-dataset.git**
2. Do **mvn clean install** and see multiple firefox and chrome windows opening 
3. One test case will fail , dont worry :)
4. Check report on path ***target/surefire-reports/html/index.html***

Pre-Requisite
--
Firefox and Chrome browser should be installed.

Project File Explained
--------

###Mapping.xml

You make mapping of method with browserconf file and your data file
Its simple and straightForward

###Framework.properties

Fall back configuration if you do not want to repeat browser configuration everywhere in your browserconf xml 

###FireFoxLocal.xml /ChromeLocal.xml

You can configure your browser as configured in this project different browser configuration can be added in same file or you can have different files and them to Mapping.xml seprated by ";"

###TestData_1.xml

* This file encourages you to write data and at the same time compliments Page object Design pattern .Values can be accessed use **PageName\_Key** like **Google_url**

* You can have multiple data sets and have different environments are well 

* If you want to filter data based on environment then simple do from command line **mvn clean insatll -Denv-type=staging**


Todo
----
More documentation
