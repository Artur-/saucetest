To run the test:

Set the properties for Sauce labs as environment variables:
```
export SAUCE_USERNAME=sauce-user
export SAUCE_ACCESS_KEY=sauce-access-key
export SAUCE_TUNNEL_ID=tunnelid
```

Start the Sauce Connect proxy
```
sc -i $SAUCE_TUNNEL_ID
```

Start the server and run the tests

```
./mvnw verify
```

