package dev.venturex.engine.graphics;

import org.joml.Vector2f;
import org.joml.Vector4f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Mesh {

    float vertices[] = {
            // position             // color
            -0.5f, -0.5f, 0.0f,     1.0f, 0.0f, 0.0f, 1.0f,
             0.5f, -0.5f, 0.0f,     0.0f, 1.0f, 0.0f, 1.0f,
             0.5f,  0.5f, 0.0f,     0.0f, 0.0f, 1.0f, 1.0f,
            -0.5f,  0.5f, 0.0f,     0.0f, 0.0f, 0.0f, 1.0f,
    };
    int indices[] = {
            0, 2, 1,
            2, 3, 0,
    };

    private int vao, vbo, ebo;

    public Mesh() {
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        // Create a float buffer of vertices
        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(vertices.length);
        vertexBuffer.put(vertices).flip();

        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);

        // Create a int buffer of indices
        IntBuffer indiceBuffer = BufferUtils.createIntBuffer(indices.length);
        indiceBuffer.put(indices).flip();

        ebo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ebo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indiceBuffer, GL_STATIC_DRAW);

        int positionSize = 3;
        int colorSize = 4;
        int vertexSize = (positionSize + colorSize) * Float.BYTES;

        glVertexAttribPointer(0, 3, GL_FLOAT, false, vertexSize, 0);
        glEnableVertexAttribArray(0);

        glVertexAttribPointer(1, 4, GL_FLOAT, false, vertexSize, positionSize * Float.BYTES);
        glEnableVertexAttribArray(1);
    }

    public void render() {
        glBindVertexArray(vao);

        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);

        glDrawElements(GL_TRIANGLES, indices.length, GL_UNSIGNED_INT, 0);

        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);

        glBindVertexArray(0);
    }
}
