package Tools;

import Exceptions.InvalidInputException;

public class ToolFactory {

	public ToolFactory() {
		super();
	}

	public Tool createTool(String theToolCode) throws InvalidInputException {
		Tool myTool = null;
		
		if(Tool.CHNS.getCode().equals(theToolCode)) {
			myTool = Tool.CHNS;
		}
		else if(Tool.LADW.getCode().equals(theToolCode)) {
			myTool = Tool.LADW;
		}
		else if(Tool.JAKD.getCode().equals(theToolCode)) {
			myTool = Tool.JAKD;
		}
		else if(Tool.JAKR.getCode().equals(theToolCode)) {
			myTool = Tool.JAKR;
		}
		else {
			throw new InvalidInputException("The input Tool Code: " + theToolCode + " was not found in our inventory. please confirm you have the corret item");
		}
		
		return myTool;
	}
}
