package dev.venturex.engine.gameobjects;

import java.util.List;

public class GameObject {

    private String name;
    private List<Component> components;

    public void addComponent(Component c) {
        if (!components.contains(c))
            components.add(c);
    }

    public <T extends Component> T getComponent(Class<T> componentClass) {
        for (Component c :  components) {
            if (componentClass.isAssignableFrom(c.getClass())) {
                try {
                    return componentClass.cast(c);
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public <T extends Component> void removeComponent(Class<T> componentClass) {
        for (Component c :  components) {
            if (componentClass.isAssignableFrom(c.getClass())) {
                components.remove(c);
                return;
            }
        }
    }

    public void init() {
        for (Component c :  components) {
            c.init();
        }
    }

    public void update(double deltaTime) {
        for (Component c :  components) {
            c.update(deltaTime);
        }
    }
}
