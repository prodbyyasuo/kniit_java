package org.kniit.lab2.task5;

abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract long getSize();
    public abstract void display(String indent);

    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Операция добавления не поддерживается для " + this.getClass().getSimpleName());
    }

    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Операция удаления не поддерживается для " + this.getClass().getSimpleName());
    }
}
