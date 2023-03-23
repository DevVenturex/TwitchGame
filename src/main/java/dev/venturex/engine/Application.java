package dev.venturex.engine;

public class Application {

    public static Window window;

    public static void run() {
        window = new Window(1024, 760, "Game");
        window.run();
    }

    public Window getWindow() {
        return window;
    }
}
