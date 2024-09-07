- Hangman Api
- create room (with specified word)
- join room
- guess letter (pass roomid, letter return guessed: true/false & guesses left)

Swagger can be found [here](http://localhost:8080/swagger-ui/index.html).

## How the API works

1. You fill first need to create a room. For this you should use the POST /api/v1/room/create endpoint. This received a json object with the word you want to use for the game as well as the number of
   guesses you want to allow. The response will contain the room id.

```json
{
  "id": "string",
  // this will be automatically added by the backend so you can leave it like this
  "word": "test",
  "allowedGuesses": 2
}
```

2. To fetch the status of the room you can use the GET /api/v1/game/{roomId} endpoint. This will return the current status of the room, like this:

```json
{
  "allowedGuesses": 2,
  "madeGuesses": 0,
  "word": "test",
  "guessedWord": "____"
}
```

3. When the player enters a guess you can use the POST /api/v1/game/{roomId} endpoint, with the letter the user guessed in the request body, like this:

```json
{
  "letter": "t"
}
```

This will return the status of the guess, like this, in the case of a correct guess:

```json
{
  "correctGuessed": true,
  "gameEnded": false,
  "guessesLeft": 2
}
```

In the case of an incorrect guess:

```json
{
  "correctGuessed": false,
  "gameEnded": false,
  "guessesLeft": 1
}
```

If the user won the game, the gameEnded field will be true.
If the number in guessesLeft is <= 0 then the game should be ended. (i.e. no longer allow the player to make guesses). Be aware that the gameEnded field will stay false in this case.
