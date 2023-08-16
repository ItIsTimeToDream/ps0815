package Tools;

import ToolTypes.Chainsaw;
import ToolTypes.Jackhammer;
import ToolTypes.Ladder;
import ToolTypes.ToolType;

public enum Tool {
	CHNS("CHNS",new Chainsaw(),Brand.STIHL),
	LADW("LADW",new Ladder(),Brand.WERNER),
	JAKD("JAKD",new Jackhammer(),Brand.DEWALT),
	JAKR("JAKR",new Jackhammer(),Brand.RIGID)
	;
	
	String code;
	ToolType toolType;
	Brand brand;
	
	private Tool(String code, ToolType toolType, Brand brand) {
		this.code = code;
		this.toolType = toolType;
		this.brand = brand;
	}

	public String getCode() {
		return code;
	}

	public ToolType getToolType() {
		return toolType;
	}

	public Brand getBrand() {
		return brand;
	}

}
