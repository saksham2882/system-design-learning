package lecture_17_Composite_Design_Pattern;


// Definition:
// Composite pattern composes object into tree like structure representing a part-whole hierarchy. It let client treats individual object and composition of object uniformly.

import java.util.ArrayList;
import java.util.List;

// Base interface for files and folders
interface FileSystemItem {
    void ls(int indent);
    void openAll(int indent);
    int getSize();
    FileSystemItem cd(String name);
    String getName();
    boolean isFolder();
}


// Leaf: file
class File implements FileSystemItem {

    private final String fileName;
    private final int size;

    public File(String fileName, int size) {
        this.fileName = fileName;
        this.size = size;
    }

    @Override
    public void ls(int indent) {
        String indentSpace = " ".repeat(indent);
        System.out.println(indentSpace + fileName + indentSpace);
    }

    @Override
    public void openAll(int indent) {
        String indentSpace = " ".repeat(indent);
        System.out.println(indentSpace + fileName + indentSpace);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public FileSystemItem cd(String name) {
        return null;
    }

    @Override
    public String getName() {
        return fileName;
    }

    @Override
    public boolean isFolder() {
        return false;
    }
}



// Composite: Folder
class Folder implements FileSystemItem {

    private final String name;
    private final List<FileSystemItem> children;

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public void ls(int indent) {
        String indentSpace = " ".repeat(indent);
        for(FileSystemItem item : children) {
            if(item.isFolder()) {
                System.out.println(indentSpace + "+ " + item.getName() + indentSpace);
            } else {
                System.out.println(indentSpace + item.getName());
            }
        }
    }

    @Override
    public void openAll(int indent) {
        String indentSpace = " ".repeat(indent);
        System.out.println(indentSpace + "+ " + name + indentSpace);
        for (FileSystemItem item : children) {
            item.openAll(indent + 4);
        }
    }

    @Override
    public int getSize() {
        int total = 0;
        for(FileSystemItem item : children) {
            total += item.getSize();
        }
        return total;
    }

    @Override
    public FileSystemItem cd(String target) {
        for(FileSystemItem item : children) {
            if(item.isFolder() && item.getName().equals(target)) {
                return item;
            }
        }
        // not found or not a folder
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isFolder() {
        return true;
    }
}


public class CompositeDesignPattern {
    static void main() {

        Folder root = new Folder("root");
        root.add(new File("file1.txt", 30));
        root.add(new File("file2.txt", 24));
        root.add(new File("file3.txt", 14));

        Folder docs = new Folder("docs");
        docs.add(new File("notes1.txt", 123));
        docs.add(new File("notes2.txt", 321));
        root.add(docs);

        Folder images = new Folder("images");
        images.add(new File("file1.png", 12));
        root.add(images);

        // ========= Command =========

        // root.ls(0);

        // docs.ls(0);

        root.openAll(0);

        FileSystemItem cwd = root.cd("docs");
        if(cwd  != null) {
            cwd.ls(0);
        } else {
            System.out.println("\nCould not cd into docs\n");
        }

        System.out.println(root.getSize() + "MB");
    }
}
