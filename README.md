# WordSweeper
This is the project to implement the client part for a small word game named wordsweeper.<br>
The author is team Libra. Our team is responsible for the client design of this project. The responsibilities for us are to deal with the players’ requests, to get the responses from server and to show the updates to the players.<br>
## Rules
●	One player can only play one game at a time.<br>
●	The game creator, the player who creates the game, must enter his/her name to start a new game.<br>
●	The game creator must be able to create a practice mode game to play alone.<br>
●	The game creator must be able to create a share mode game, with an optional password, so that only authorized players can join the game.<br>
●	In a share mode game, a game manager must be assigned to manage the game, originally as the game creator when game starts; and must be re-designated randomly once the current game manager leaves the game.<br>
●	The game manager must be able to share the game number to other people who want to join.<br>
●	The game manager must be able to share the password if it exists.<br>
●	The game manager must be able to lock the game, so that no additional player can join.<br>
●	The game manager must be able to reset the game, so that all scores are reset and board state is shuffled.<br>
●	All players must be able to see who the game manager is.<br>
●	Players who want to join an existing game must enter their names, the number of the game and password if it exists, which must be obtained from the game manager.<br>
●	Game must be restarted whenever a new player joins the game.<br>
●	Players must be able to see the total number of other players within the same game.<br>
●	Players must be able to see a 4X4 letter board when the game starts.<br>
●	Players must be able to see when the boards of other players overlap his/her own board.<br>
●	Players must be able to reposition board.<br>
●	Players must be able to choose a letter on board.<br>
●	Players must be able to un-choose a letter to on board.<br>
●	Players must be able to see partially constructed word during construction and the score accordingly.<br>
●	Players must be able to submit the word when construction is done.<br>
●	Players must be able to see the overall score he/she has obtained.<br>
●	Players must be able to choose if he/she wants to see other players’ score.<br>
●	Players must be able to exit the game.<br>
●	Score is computed based on formula identified in initial RAD specification.<br>
●	Global board state is set randomly with a size of 7X7 when game starts, and will expand when necessary.<br>
●	Global board state size must be always larger than 16*Number of players. <br>
## Testing partner
The server is set on 72.249.186.243; cccwork3.wpi.edu; rambo.wpi.edu; 	
## Notes
Launch method: directly run ClientLauncher.java.
