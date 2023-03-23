package dev.venturex.engine.scene;

import dev.venturex.engine.graphics.Mesh;
import dev.venturex.engine.graphics.Shader;
import dev.venturex.engine.handlers.KeyboardHandler;
import dev.venturex.game.scenes.TestScene;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_SPACE;

public class DefaultScene extends Scene {

    Mesh mesh;
    Shader defaultShader;

    @Override
    public void init() {
        System.out.println("Default Scene");
        defaultShader = new Shader("src/main/resources/shaders/default.glsl");
        defaultShader.compile();
        mesh = new Mesh();
    }

    @Override
    public void update(double deltaTime) {
        defaultShader.use();
        mesh.render();
        defaultShader.detach();
    }
}
