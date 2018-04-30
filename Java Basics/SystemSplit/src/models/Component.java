package models;


public abstract class Component {
    private String name;
    private String type;

    protected Component(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
