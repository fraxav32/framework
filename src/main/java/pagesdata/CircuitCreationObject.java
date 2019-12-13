package pagesdata;



public class CircuitCreationObject {
	private String circuitId ;
    private String capacity;
    private String noOfConnections;
    private String directionality;
    
    public String getCircuitId()
    {
                    return circuitId;
    }
    public void setCapacity(String cap)
    {
                    capacity = cap;
    }
    public String getCapacity()
    {
                    return capacity;                                
    }
    public void setNoOfConnections(String no)
    {
                    noOfConnections = no;
    }
    public String getNoOfConnections()
    {
                    return noOfConnections;
    }
    public String getDirectionality()
    {
                    return directionality;
    }

}
