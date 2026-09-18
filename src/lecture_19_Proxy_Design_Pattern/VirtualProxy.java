package lecture_19_Proxy_Design_Pattern;

// Definition:
// The Proxy pattern provides a surrogate or placeholder for another object to control access to it.


interface IImage {
    void displayImage();
}

class RealImage implements IImage {
    private final String fileName;

    public RealImage(String file) {
        this.fileName = file;
        // Heavy Operation
        System.out.println("[RealImage] Loading image from disk: " + fileName);
    }

    @Override
    public void displayImage() {
        System.out.println("[RealImage] Displaying: " + fileName);
    }
}


// Proxy
class ImageProxy implements IImage {
    private RealImage realImage;
    private final String fileName;

    public ImageProxy(String fileName) {
        this.realImage = null;
        this.fileName = fileName;
    }

    @Override
    public void displayImage() {
        if(realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.displayImage();
    }
}


public class VirtualProxy {
    static void main() {

        IImage img = new ImageProxy("Sample.png");
        img.displayImage();
    }
}
