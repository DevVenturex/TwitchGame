package dev.venturex.engine.scene;

import dev.venturex.engine.Application;
import dev.venturex.engine.Window;

public abstract class Scene {

    public Window window = Application.window;
    public abstract void init();
    public abstract void update(double deltaTime);
}
