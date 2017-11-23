# SmartCityCommon
Warning: Currently only imported from RobotBackend, RobotCore and the Backbone. Files may be incorrect/missing.
Please contact me in case of problems.

## How To Install
1. Open this repository in IntelliJ
2. View->Tool Windows->Maven projects
3. In the window that pops up: SmartCity Common->Lifecycle->Install
4. After installation, open your own repo
5. Add following dependency to the pom file
```
<dependency>
  <groupId>be.uantwerpen.sc</groupId>
  <artifactId>SmartCityCommon</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```
6. Import maven changes
7. Remove shared files from models & tools folder, and make sure the missing imports are changed to those of the new maven library.
