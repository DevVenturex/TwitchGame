package dev.venturex.engine.handlers;

import org.lwjgl.glfw.GLFWWindowCloseCallback;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class KeyboardHandler {

    private static KeyboardHandler instance;

    private boolean[] keysPressed = new boolean[350];

    public static KeyboardHandler get() {
        if (KeyboardHandler.instance == null)
            KeyboardHandler.instance = new KeyboardHandler();
        return KeyboardHandler.instance;
    }

    public static void keyCallback(long window, int key, int scancode, int action, int mods) {
        if (action == GLFW_PRESS) {
            get().keysPressed[key] = true;
        } else if (action == GLFW_RELEASE) {
            get().keysPressed[key] = false;
        }
    }

    public static boolean isKeyPressed(int keyCode) {
        return get().keysPressed[keyCode];
    }
}
