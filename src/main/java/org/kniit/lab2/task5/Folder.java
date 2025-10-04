package org.kniit.lab2.task5;

import java.util.ArrayList;
import java.util.List;

class Folder extends FileSystemComponent {
    private List<FileSystemComponent> children;

    public Folder(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + name);
        String newIndent = indent + "  ";
        for (FileSystemComponent component : children) {
            component.display(newIndent);
        }
    }
}
