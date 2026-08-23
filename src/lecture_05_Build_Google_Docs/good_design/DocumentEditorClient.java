package lecture_05_Build_Google_Docs.good_design;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Interface for document elements
interface DocumentElement {
    public String render();
}

// Concrete implementation for "text" elements
class TextElement implements DocumentElement {
    private final String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}

// Concrete implementation for "image" elements
class ImageElement implements DocumentElement {
    private final String imagePath;

    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String render() {
        return "[Image: "  + imagePath + "]";
    }
}

// Concrete implementation for "new line" elements (represent a line break in the document - added later to show open-close principle followed)
class NewLineElement implements DocumentElement {
    @Override
    public String render() {
        return "\n";
    }
}

// Concrete implementation for "tab space" elements (represent a tab space in the document - added later to show open-close principle followed)
class TabSpacesElement implements DocumentElement {
    @Override
    public String render() {
        return "\t";
    }
}


// Document class responsible for holding a collection of elements
class Document {
    private final List<DocumentElement> documentElements = new ArrayList<>();

    public void addDocumentElement(DocumentElement element) {
        documentElements.add(element);
    }

    // Renders the document by concatenating the render output of all elements.
    public String render() {
        StringBuilder result = new StringBuilder();
        for (DocumentElement element : documentElements) {
            result.append(element.render());
        }
        return result.toString();
    }
}


// Persistence Interface
interface Persistence {
    public void save(String data);
}

// FileStorage implementation of Persistence
class FileStorage implements Persistence {
    @Override
    public void save(String data) {
        try{
            FileWriter file = new FileWriter("document.txt");
            file.write(data);
            file.close();
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing");
        }
    }
}

// SQLDatabase implementation of Persistence
class SQLDatabase implements Persistence {
    @Override
    public void save(String data) {
        // save to DB
    }
}



// DocumentEditor class managing client interactions
class DocumentEditor {

    private final Document document;
    private final Persistence storage;
    private String renderedDocument = "";

    public DocumentEditor(Document document, Persistence storage) {
        this.document = document;
        this.storage = storage;
    }

    public void addText(String text) {
        document.addDocumentElement(new TextElement(text));
    }

    public void addImage(String imagePath) {
        document.addDocumentElement(new ImageElement(imagePath));
    }

    // Adds a new line to the document (added later to show open-close principle followed)
    public void addNewLine() {
        document.addDocumentElement(new NewLineElement());
    }

    // Adds a tab space to the document (added later to show open-close principle followed)
    public void addTabSpaces() {
        document.addDocumentElement(new TabSpacesElement());
    }

    public String renderDocument() {
        if(renderedDocument.isEmpty()){
            renderedDocument = document.render();
        }
        return renderedDocument;
    }

    public void saveDocument() {
        storage.save(renderedDocument);
    }
}


// Client Usage
public class DocumentEditorClient {
    static void main() {

        Document document = new Document();
        Persistence storage = new FileStorage();

        DocumentEditor editor = new DocumentEditor(document, storage);

        // Simulate a client using the editor with common text formatting features.
        editor.addText("Hello World!");
        editor.addNewLine();
        editor.addText("This is a text document.");
        editor.addNewLine();
        editor.addTabSpaces();
        editor.addText("This is another text after a tab space.");
        editor.addNewLine();
        editor.addImage("picture.png");

        // Render and display the final document.
        System.out.println(editor.renderDocument());

        editor.saveDocument();
    }
}


// It almost follows all SOLID Principle as per Trades-Off
// but not fully follow the least knowledge principle