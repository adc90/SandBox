/* The Business Delegate Pattern is used to decouple presentation tier 
 * and business tier. The pattern is broken up into 4 classes
 * 1) Client            : Presentation tier code.
 * 2) Business Delegate : A single entry point class for client entities
 *                        to provide access to Business Service methods.
 * 3) LookUp Service    : Lookup service object is responsible to get 
 *                        relative business implementation and provide business
 *                        object access to the business delegate object.
 * 4) Business Service  : Concrete class implement this business service 
 *                        to provide the actual business implementation logic.
 * */

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class busdel{
    public static void main(String[] args) {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setServiceType("EJB");

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceType("JMS");
        client.doTask();
    }
}

//----------------------------------------------------
// Interface for BusinessService
//----------------------------------------------------
interface BusinessService{
    public void doProcessing();
}

//----------------------------------------------------
// Concrete implmentatoin of BusinessService
//----------------------------------------------------
class EJBService implements BusinessService{
    @Override public void doProcessing(){
        System.out.println("Processing task by invoking EJB Service");
    }
}

//----------------------------------------------------
// Concrete implmentatoin of BusinessService
//----------------------------------------------------
class JMSService implements BusinessService{
    @Override public void doProcessing(){
        System.out.println("Processing task by invoking JMS Service");
    }
}

//----------------------------------------------------
// Concrete implmentatoin of BusinessService
//----------------------------------------------------
class BusinessLookUp{
    public BusinessService getBusinessService(String serviceType){
        if(serviceType.equalsIgnoreCase("EJB")){
            return new EJBService();
        }else{
            return new JMSService();
        }
    }
}

//----------------------------------------------------
//
//----------------------------------------------------
class BusinessDelegate{
    private BusinessLookUp lookupService = new BusinessLookUp();
    private BusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }

    public void doTask(){
        businessService = lookupService.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}

//----------------------------------------------------
// Client which holds a BuisinessDelegate and calls 
// its task through doTask() 
//----------------------------------------------------
class Client{
    BusinessDelegate businessService;

    public Client(BusinessDelegate businessService){
        this.businessService = businessService;
    }

    public void doTask(){
        businessService.doTask();
    }
}

