# SmartCityCommon

## How To Use Common Files
1. Add following dependency to the pom file
```
<dependency>
  <groupId>be.uantwerpen.sc</groupId>
  <artifactId>SmartCityCommon</artifactId>
  <version>0.0.2-SNAPSHOT</version>
</dependency>
```
2. Add the artifact repository to the pom (just before the closing tag)
```
    <repositories>
        <repository>
            <id>SmartCityCommon-mvn-repo</id>
            <url>https://raw.github.com/SmartCity-UAntwerpen/SmartCityCommon/mvn-repo/</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
    </repositories>
```
6. Import maven changes
7. (Remove shared files from models & tools folder, and make sure the missing imports are changed to those of the new maven library.)

##How to edit the common files
0. Make your changes
1. Edit the maven file to change version number (if necessary)
2. Create settings file with GitHub credentials (Windows: C:\Users\_name_\.m2\settings.xml)
```
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
	<servers>
	<server>
		<id>github</id>
		<username>YOUR USERNAME</username>
		<password>YOUR PASSWORD</password>
	</server>
	</servers>
	
</settings>
```
3. Run mvn deploy target to upload to the repository

(Tip: Make sure you added your full name to your github profile)
