# WordSweeper
This is the project to implement the client part for a small word game named wordsweeper.<br>
The author is team Libra.Our team is responsible for the client design of this project. The responsibilities for us are to deal with the players’ requests, to get the responses from server and to show the updates to the players.<br>
## Rules
●	One player can only play one game at a time.
●	The game creator, the player who creates the game, must enter his/her name to start a new game.
●	The game creator must be able to create a practice mode game to play alone.
●	The game creator must be able to create a share mode game, with an optional password, so that only authorized players can join the game.
●	In a share mode game, a game manager must be assigned to manage the game, originally as the game creator when game starts; and must be re-designated randomly once the current game manager leaves the game.
●	The game manager must be able to share the game number to other people who want to join.
●	The game manager must be able to share the password if it exists.
●	The game manager must be able to lock the game, so that no additional player can join.
●	The game manager must be able to reset the game, so that all scores are reset and board state is shuffled.
●	All players must be able to see who the game manager is.
●	Players who want to join an existing game must enter their names, the number of the game and password if it exists, which must be obtained from the game manager.
●	Game must be restarted whenever a new player joins the game.
●	Players must be able to see the total number of other players within the same game.
●	Players must be able to see a 4X4 letter board when the game starts.
●	Players must be able to see when the boards of other players overlap his/her own board.
●	Players must be able to reposition board.
●	Players must be able to choose a letter on board.
●	Players must be able to un-choose a letter to on board.
●	Players must be able to see partially constructed word during construction and the score accordingly.
●	Players must be able to submit the word when construction is done.
●	Players must be able to see the overall score he/she has obtained.
●	Players must be able to choose if he/she wants to see other players’ score.
●	Players must be able to exit the game.
●	Score is computed based on formula identified in initial RAD specification.
●	Global board state is set randomly with a size of 7X7 when game starts, and will expand when necessary.
●	Global board state size must be always larger than 16*Number of players. 
## Testing partner
The server is set on 72.249.186.243; cccwork3.wpi.edu; rambo.wpi.edu; 	
## Notes
Launch method: directly run ClientLauncher.java
