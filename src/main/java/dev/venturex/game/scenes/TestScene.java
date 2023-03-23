package dev.venturex.game.scenes;

import dev.venturex.engine.handlers.KeyboardHandler;
import dev.venturex.engine.scene.DefaultScene;
import dev.venturex.engine.scene.Scene;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_SPACE;

public class TestScene extends Scene {

    @Override
    public void init() {
        System.out.println("Test Scene");
    }

    @Override
    public void update(double deltaTime) {

    }
}
