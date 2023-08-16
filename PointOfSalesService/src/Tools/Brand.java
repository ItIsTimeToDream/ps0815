package Tools;

public enum Brand {
	STIHL("STIHL", "Stihl"), 
	WERNER("WERNER", "Werner"), 
	DEWALT("DEWALT", "DeWalt"), 
	RIGID("RIGID", "Rigid");

	String code;
	String name;

	private Brand(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

}
