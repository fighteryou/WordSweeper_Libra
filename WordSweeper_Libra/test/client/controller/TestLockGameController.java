package client.controller;
import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail; 
import java.util.ArrayList; 
import org.junit.Test; 
import org.junit.Before; 
import client.MockServerAccess; 
import client.controller.requestController.LockGameController; 
import client.view.Application; 
import client.model.Model; 
import xml.Message; 

/**@author You Zhou, Qingquan Zhao, Han Bao, Ruochen Shi (Authors contribute equally)
 * This is responsible for testing "Lock Game" Controller*/
public class TestLockGameController {
	Model model=new Model(); 
	Application client=new Application(model); 
	MockServerAccess mockServer=new MockServerAccess("localhost"); 

	/**the setting for the test*/
	@Before 
	public void set() 
	{
		// FIRST thing to do is register the protocol being used. 
		if (!Message.configure("wordsweeper.xsd")) { 
			fail ("unable to configure protocol"); 
		}
		client.setVisible(true); 
		client.setServerAccess(mockServer); 
	}
	 
	/**This is responsible for testing the process of "Join Game" Controller*/
	@Test
	public void TestLockGameProcess() 
	{
		String game_id = "lockGame"; 
		model.getGame().setGameID(game_id); 
		
		LockGameController lgame=new LockGameController(client,model); 
		lgame.process(); 

		ArrayList<Message> reqs = mockServer.getAndClearMessages(); 
		assertTrue(reqs.size() == 1); 
		Message r = reqs.get(0); 
		assertEquals("lockGameRequest", r.contents.getFirstChild().getLocalName()); 
		assertEquals(game_id, r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());	
	}	
}
//end of TestLockGameController