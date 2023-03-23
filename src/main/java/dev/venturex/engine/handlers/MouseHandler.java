package dev.venturex.engine.handlers;

public class MouseHandler {

    private static MouseHandler instance;

    private double scrollX, scrollY;
    private double xPos, yPos, lastX, lastY;
    private boolean buttonsPressed[] = new boolean[3];

    private MouseHandler() {
        this.scrollX    = this.scrollY  = 0.0;
        this.xPos       = this.yPos     = 0.0;
        this.lastX      = this.lastY    = 0.0;
    }

    public static MouseHandler get() {
        if (MouseHandler.instance == null)
            MouseHandler.instance = new MouseHandler();
        return MouseHandler.instance;
    }

    public static void mousePosCallback(long window, double xpos, double ypos) {}

    public static void  mouseButtonCallback(long window, int button, int action, int mods) {}

    public static void mouseScrollCallback(long window, double xOffset, double yOffset) {}

    public static void endFrame() {}

    public static float getX() {
        return (float) get().xPos;
    }

    public static float getY() {
        return (float) get().yPos;
    }

    public static float getDx() {
        return (float) (get().lastX - get().xPos);
    }

    public static float getDy() {
        return (float) (get().lastY - get().yPos);
    }

    public static boolean mouseButtonPressed(int button) {
        if (button < get().buttonsPressed.length) {
            return get().buttonsPressed[button];
        } else
            return false;
    }
}

