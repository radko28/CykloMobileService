package sk.cyklosoft.cykloservice.util;

public enum TrainType {

    LAST("last"),
    CURRENT("Current");
	
	private String value;
	
	TrainType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }


}

