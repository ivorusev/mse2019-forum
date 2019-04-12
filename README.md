## Forum application for MSE 2019
This is the back-end that can be used for a simple forum web application.

## Persistence
A h2 in memory database is used. However it is configured in such a way that the information is stored in a file.

## Security
The security is implemented via OAuth2 and in order to authenticate the client has to first obtain an OAuth access token token.

### Obtaining thr OAuth Token
This can be done by making a POST http request to the following address:

```
http://localhost:8090/oauth/token?grant_type=password&password=ivo&username=ivo
```
Note that in order to obtain the token correctly you must change:
* The port to match the configuration in your application.properties;
* The password and the username have to match an existing user already stored in the database.

The request above must also have basic authorization header that contains the OAuth credentials: username and password. In this project those are "admin" and "admin" and can be seen in ``` src/main/java/com/mse/forum/security/AuthorizationServerConfiguration.java ```.

### Using OAuth Token
Once obtained the token must be added to every request made to the backend as an Authorization header, i.e. ``` Authorization Bearer here-goes-your-token```.

Keep in mind that the token also contains information on which resources the user can access and if the authentication does not work then check the roles of the user.

### Using the Shared Postman Requests
To save some time testing this you could use the shared postman reequests, which can be found here: https://www.getpostman.com/collections/bf4f114ae12e751d2062
