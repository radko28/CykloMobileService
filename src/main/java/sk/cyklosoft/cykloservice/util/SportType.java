package sk.cyklosoft.cykloservice.util;

import java.util.LinkedHashMap;
import java.util.Map;


public enum SportType {
	
    MTB_CYCLING("Mountain cycling"),
    ROAD_CYCLING("Road cycling"),
    STOP("Stop");


    private String value;
    
    SportType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public static Map<SportType, String> getRecommendedTypeMap() {
        Map<SportType, String> recommendedTypeMap = new LinkedHashMap<SportType, String>();
        for(SportType type:SportType.values()) {
            recommendedTypeMap.put(type, type.getValue());
        }
        return recommendedTypeMap;
    }

}
