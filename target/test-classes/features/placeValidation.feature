Feature: Validating Place API's'

Scenario Outline: Validating Add Place API

Given Add place payload with "<isbn>" "<aisle>" and "<authorname>"
When user calls the "AddPlaceAPI" payload using "POST" http request
Then place should be successfully verified with success code as 200 
And "Msg" in the response body should be "successfully added"
And Fetch the details by using BookId generated by calling "getPlaceAPI" using "GET" http request
 

Examples:
|	isbn	|	aisle	|	authorname	|
|	ub2	|	731	|	Rajeev	|
|	cb2	|	211	|	sundeer	|
|	wb2	|	301	|	ganji	|
|	hb2	|	401	|	yummi	|


Scenario: Validating Delete Place API

Given BookId to validate delete place API
When user calls the "deletePlaceAPI" payload using "DELETE" http request
Then place should be successfully verified with success code as 200 
And "msg" in the response body should be "book is successfully deleted"

