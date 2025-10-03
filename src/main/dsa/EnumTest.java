package src.main.dsa;

public enum EnumTest {
    
    DELIVERED(3, "DELIVERED"),
    
    IN_TRANSIT(4, "IN_TRANSIT");
    
    private final int key;
    private final String value;
    
    EnumTest(int key, String value){
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }
    
    public int getKeyByValue(String value){
        for(EnumTest e : EnumTest.values()){
            if(e.getValue().equals(value)){
                return e.getKey();
            }
        }
        
        throw new IllegalArgumentException();
    }
    
}
