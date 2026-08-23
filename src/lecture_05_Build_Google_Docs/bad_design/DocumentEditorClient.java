package lecture_05_Build_Google_Docs.bad_design;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DocumentEditor {

    private final List<String> documentElements;
    private String renderedDocument;

    public DocumentEditor() {
        this.documentElements = new ArrayList<>();
        this.renderedDocument = "";
    }

    // Adds text as a plain string
    public void addText(String text) {
        documentElements.add(text);
    }

    // Adds an image represented by its file path
    public void addImage(String imagePath) {
        documentElements.add(imagePath);
    }

    // Renders the document by checking the type of each element at runtime
    public String renderDocument() {
        if(renderedDocument.isEmpty()) {
            StringBuilder result = new StringBuilder();

            for(String element : documentElements) {
                if(element.length() > 4 && (element.endsWith(".jpg") || element.endsWith(".png"))) {
                    result.append("[Image: ").append(element).append("]\n");
                } else {
                    result.append(element).append("\n");
                }
            }
            renderedDocument = result.toString();
        }
        return renderedDocument;
    }

    // save document data to document.txt
    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("documents.txt");
            writer.write(renderDocument());
            writer.close();
            System.out.println("Documents saved!");
        } catch (IIOException e) {
            System.out.println("Error while saving documents!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


public class DocumentEditorClient {
    static void main() {
        DocumentEditor documentEditor = new DocumentEditor();

        documentEditor.addText("Hello World!");
        documentEditor.addImage("picture.png");
        documentEditor.addText("Bye!");

        System.out.println(documentEditor.renderDocument());

        documentEditor.saveToFile();
    }
}
