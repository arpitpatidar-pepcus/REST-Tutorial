# REST-Tutorial

spring-boot-crud-operation --> it is first stage , implementing CRUD 

crudoperation  -->  updated put method and established many-to-one relationship


url -->  GET   http://localhost:8081/employees/
          POST   http://localhost:8081/employees/
          provide body in post method inJSON format --> e.g.  
{
"name": "Gajendra",
"email": "gajendra@yopmail.com",
"phoneNo": "+919320012000",
"address":[
{
"street1": "123, Tilak Nagar",
"street2": "A.B. Road",
"city": "Indore",
"state": "M.P.",
"country": "India"
},
{
"street1": "23, Mahavir Nagar",
"street2": "Ring Road",
"city": "Indore",
"state": "M.P.",
"country": "India"
}
]
}



