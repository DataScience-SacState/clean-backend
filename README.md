# Clean-Backend
###### _REST Backend for Clean-Sac_

In order to use this REST service, you must host a MySQL database and pass in the following environment variables:
 - DB_URL
  - _ex: 'jdbc:mysql://localhost:3306/cleandb'_
 - DB_USERNAME
  - _ex: 'root'_
 - DB_PASSWORD
  - _ex: 'password'_

## Routes:

### /create | /report
###### Create new Incident
#### Parameters:
 - reporter
  - required: no
  - default: 311
 - description
  - required: true
 - latitude
  - required: true
 - longitude
  - required: true

### /list
###### Get data for all Incidents
#### Parameters:
 - None

/list
```JavaScript
[
 { 
  id='_1',
  reporter='02938420934',
  description='plastic bag',
  latitude='0.001',
  longitude='3.53',
  timeReported='2016.01.09.00.00',
  timeCompleted='2017.02.23.23.23.23'
 },
 // ... and so forth
]
```

### /since | /listsince
###### Get data for all Incidents after given time
#### Parameters:
 - time
  - required: true

/since?time=2015.01.09.24.34
```JavaScript
[
 { 
  id='_1',
  reporter='02938420934',
  description='plastic bag',
  latitude='0.001',
  longitude='3.53',
  timeReported='2016.01.09.00.00',
  timeCompleted='2017.02.23.23.23.23'
 },
 // ... and so forth
]
```
/since?time=2022
```JavaScript
[
 // Empty Array
]
```
