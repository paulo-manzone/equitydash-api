# equitydash-api
[![Build Status](https://travis-ci.org/paulo-manzone/equitydash-api.svg?branch=master)](https://travis-ci.org/paulo-manzone/equitydash-api)

# Description
Spring Rest Api dedicated to provide stock valuation and management to a dashboard application.

## Routes (Available End-points)
| METHODS        | URL           | Description |
| ------------- | ------------- | ----------- |
| GET POST PUT DELETE          | /acoes  | interacts with stocks in the database  |
| GET | /acoes/{id}  | get the specified stock|
| GET | /valuation/gordon | get gordon evaluation for specified parameter: ?dividendo ?k ?g |
| GET | /valuation/graham | get graham evaluation for specified parameter: ?lpa ?vpa |

For more detailed info, refer to [Swagger UI](localhost:65534/swagger-ui.html) after running the api locally.

## Post body example

```json
{
  "quantidade": 3,
  "ticker": "ITSA4",
  "valor": 10.50
}
```
 ## Running application locally (ubuntu)

 1. If not installed, get docker and docker-compose
 2. Make sure the datasource is set properly in **application.properties**
 3. Run the command:  `< sudo docker-compose up>` in the project folder 

 ## Contribuiting

 You can mail me at pmanzonemaia@gmail.com.







