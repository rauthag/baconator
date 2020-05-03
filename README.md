# Baconator
- Retrieves data from [Bacon Ipsum](https://baconipsum.com/) on endpoint /give-me-bacon/{howmuch}
- Spring boot app

## Setup
Clone repository and with pom.xml add as Maven Project (Java 14 used).
Then in Baconator Maven 
```
Lifecycle -> clean
```
```
Lifecycle -> install
```
Open "target" folder in terminal or 
```
cd tarrget
```
Run warfile
```
java -jar baconator-0.0.1-SNAPSHOT.war
```
In browser type
```
http://localhost:8080/give-me-bacon/{howMuch}
```
- {howMuch} how many times to retrieve

## Example
- using [JSONView](https://jsonview.com/) Firefox extension:
```
http://localhost:8080/give-me-bacon/5
```
Result
![Image of results](https://ctrlv.cz/shots/2020/05/03/jzBO.png)








