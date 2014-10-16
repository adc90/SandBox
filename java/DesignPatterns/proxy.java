/* This design pattern seperates some of the loading functionality
 * from the display functionality. In this example the ProxyImage
 * class takes the responsibility of making sure that the image is loaded
 * away from the actual RealImage class */

//----------------------------------------------------
// Main class 
//----------------------------------------------------
public class proxy{
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //Image will be loaded from disk
        image.display();
        System.out.println("");
        //Image will not be loaded from disk
        image.display();
    }
}

//----------------------------------------------------
//Interface for the image
//----------------------------------------------------
interface Image{
    void display();
}

//----------------------------------------------------
//Responsible for loading the image from disk
//----------------------------------------------------
class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName); 
    }

    @Override public void display(){
        System.out.println("Displaying " + fileName); 
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName); 
    }
}

//----------------------------------------------------
// Makes sure that the image is loaded before 
// displaying it
//----------------------------------------------------
class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName; 
    }

    @Override public void display(){
        if(realImage == null){
            realImage = new RealImage(fileName);    
        }
        realImage.display();
    }
}
