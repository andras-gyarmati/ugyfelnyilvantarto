curl --verbose --write-out "\n" --request PUT --data @03-updateUser.json --header "Content-Type: application/json" --cookie-jar cart-cookies.txt --cookie cart-cookies.txt 'http://localhost:8080/client_registry-web/rest/users'