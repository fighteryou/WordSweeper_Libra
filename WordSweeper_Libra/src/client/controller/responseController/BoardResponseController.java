package client.controller.responseController;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import client.model.Model;
import client.view.Application;
import client.view.LeftBoardPanel;
import client.view.RightGameInfoBoard;
import xml.Message;

/**
 * Tells the client whether the model is locked or not BY SOME OTHER CLIENT.
 * This will never be returned to a client to tell him that HE has the model
 * locked (that is job of LockResponse).
 */
public class BoardResponseController extends ControllerChain {

	public Application app;
	public Model model;
	private boolean flag;

	public BoardResponseController(Application a, Model m) {
		super();
		this.app = a;
		this.model = m;
		this.flag = false;
	}

	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("boardResponse")) {
			return next.process(response);
		}
		this.model.existedGame = true;

		// this refers to the outer node of the Message DOM (in this case,
		// updateResponse).
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();

		String gameId = map.getNamedItem("gameId").getNodeValue();
		String managingUser = map.getNamedItem("managingUser").getNodeValue();
		String bonusCell = map.getNamedItem("bonus").getNodeValue();
		app.getResponseArea().append("Board Message received for game:" + gameId + "\n");
		app.getResponseArea().append("Players:\n");
		NodeList list = boardResponse.getChildNodes();

		Map<String, Integer> allPlayersInfo = new HashMap<>();
		Map<String, String> allPlayersPositionInfo = new HashMap<>();
		this.model.getBoard().positions.clear();

		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			String pname = n.getAttributes().getNamedItem("name").getNodeValue();
			String pscore = n.getAttributes().getNamedItem("score").getNodeValue();
			String boardInfo = n.getAttributes().getNamedItem("board").getNodeValue();
			String plocation = n.getAttributes().getNamedItem("position").getNodeValue();
			char[] corRowArray = plocation.toCharArray();
			Integer globalStartingCol = Integer.valueOf(String.valueOf(corRowArray[0]));
			Integer globalStaringRow = Integer.valueOf(String.valueOf(corRowArray[corRowArray.length - 1]));
			Long score = Long.valueOf(n.getAttributes().getNamedItem("score").getNodeValue());
			allPlayersInfo.put(pname, Integer.valueOf(pscore));
			allPlayersPositionInfo.put(pname, plocation);
			if (this.flag == false)
				model.updateInfo(gameId, managingUser, pname, globalStartingCol, globalStaringRow, boardInfo, score,
						bonusCell);
			else if (pname.equals(this.model.getPlayer().getName()))
				model.updateInfo(gameId, managingUser, pname, globalStartingCol, globalStaringRow, boardInfo, score,
						bonusCell);
			this.model.getBoard().positions.add(plocation);

			app.getResponseArea().append("  " + pname + "\n");
		}

		// at this point, you would normally start processing this...
		app.getResponseArea().append(response.toString());
		app.getResponseArea().append("\n");

		model.getGame().setPlayersInfoMap(allPlayersInfo);
		model.getGame().setPlayersPositionMap(allPlayersPositionInfo);

		// obtain information from xml and update the corresponding model
		// information

		// Node player = boardResponse.getFirstChild();
		// NamedNodeMap playerMap = player.getAttributes();
		// String playerName = playerMap.getNamedItem("name").getNodeValue();
		// String boardInfo = playerMap.getNamedItem("board").getNodeValue();
		// String colRow = playerMap.getNamedItem("position").getNodeValue();
		// char[] corRowArray = colRow.toCharArray();
		// Integer globalStartingCol =
		// Integer.valueOf(String.valueOf(corRowArray[0]));
		// Integer globalStaringRow =
		// Integer.valueOf(String.valueOf(corRowArray[corRowArray.length - 1]));
		// Long score =
		// Long.valueOf(playerMap.getNamedItem("score").getNodeValue());
		//
		// model.updateInfo(gameId, managingUser, playerName, globalStartingCol,
		// globalStaringRow, boardInfo, score);
		//

		if (this.flag == true) {
			((LeftBoardPanel) app.getMultiGame().getLeftBoardPanel()).refreshBoard();
			((RightGameInfoBoard) app.getMultiGame().getRightGameInfoPanel()).updateGameInfoBoard();
		}
		this.flag = true;

		return true;
	}

}
