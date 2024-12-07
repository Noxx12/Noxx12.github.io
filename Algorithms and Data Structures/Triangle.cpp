#include <iostream>
#include <vector>
#include <queue>
#include <limits>
#include <GL/glew.h>
#include <GLFW/glfw3.h>

using namespace std;

// Vertex Shader Source Code
const char* vertexShaderSource = R"(
    #version 330 core
    layout(location = 0) in vec2 position;
    layout(location = 1) in vec3 color;
    out vec3 fragColor;
    void main()
    {
        gl_Position = vec4(position, 0.0, 1.0);
        fragColor = color;
    }
)";

// Fragment Shader Source Code
const char* fragmentShaderSource = R"(
    #version 330 core
    in vec3 fragColor;
    out vec4 finalColor;
    void main()
    {
        finalColor = vec4(fragColor, 1.0);
    }
)";

// Dijkstra's Algorithm Implementation
void dijkstra(const vector<vector<pair<int, int>>>& graph, int source) {
    int n = graph.size();
    vector<int> distance(n, numeric_limits<int>::max());
    vector<int> predecessor(n, -1);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    distance[source] = 0;
    pq.push({ 0, source });

    while (!pq.empty()) {
        int currentDistance = pq.top().first;
        int currentNode = pq.top().second;
        pq.pop();

        if (currentDistance > distance[currentNode]) continue;

        for (const auto& neighbor : graph[currentNode]) {
            int nextNode = neighbor.first;
            int weight = neighbor.second;

            if (distance[currentNode] + weight < distance[nextNode]) {
                distance[nextNode] = distance[currentNode] + weight;
                predecessor[nextNode] = currentNode;
                pq.push({ distance[nextNode], nextNode });
            }
        }
    }

    // Output the shortest distances
    cout << "Shortest distances from source node " << source << ":\n";
    for (int i = 0; i < n; ++i) {
        if (distance[i] == numeric_limits<int>::max()) {
            cout << "Node " << i << ": INFINITY\n";
        }
        else {
            cout << "Node " << i << ": " << distance[i] << "\n";
        }
    }

    // Output the paths
    cout << "\nPaths from source node " << source << ":\n";
    for (int i = 0; i < n; ++i) {
        if (distance[i] != numeric_limits<int>::max()) {
            cout << "Path to " << i << ": ";
            int current = i;
            while (current != -1) {
                cout << current << " ";
                current = predecessor[current];
            }
            cout << "\n";
        }
    }
}

int main()
{
    // Example graph for Dijkstra's Algorithm
    vector<vector<pair<int, int>>> graph = {
        {{1, 4}, {2, 1}},      // Node 0
        {{0, 4}, {2, 2}, {3, 1}}, // Node 1
        {{0, 1}, {1, 2}, {3, 5}}, // Node 2
        {{1, 1}, {2, 5}}       // Node 3
    };
    int sourceNode = 0;

    cout << "Running Dijkstra's Algorithm...\n";
    dijkstra(graph, sourceNode);

    // Initialize GLFW
    if (!glfwInit())
        return -1;

    // Create a windowed mode with size
    GLFWwindow* window = glfwCreateWindow(800, 600, "Kelly Perez", nullptr, nullptr);
    if (!window)
    {
        glfwTerminate();
        return -1;
    }

    glfwMakeContextCurrent(window);

    // Initialize GLEW
    if (glewInit() != GLEW_OK)
    {
        cout << "Error!\n";
        return -1;
    }
    cout << "OpenGL Version: " << glGetString(GL_VERSION) << endl;

    // Vertex and color data 
    float vertices[] = {
        // First Triangle
        -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, // Vertex 1: x, y, R, G, B
        -1.0f, 1.0f, 1.0f, 0.0f, 0.0f, // Vertex 2: x, y, R, G, B
        -0.5f, 0.0f, 0.0f, 1.0f, 0.0f, // Vertex 3: x, y, R, G, B

        // Second Triangle
        0.0f, 0.0f, 1.0f, 0.0f, 0.0f, // Vertex 4: x, y, R, G, B
        -0.5f, 0.0f, 0.0f, 1.0f, 0.0f, // Vertex 3: x, y, R, G, B 
        0.0f, -1.0f, 0.0f, 1.0f, 0.0f  // Vertex 5: x, y, R, G, B
    };

    // Vertex buffer setup
    GLuint vao, vbo;
    glGenVertexArrays(1, &vao);
    glGenBuffers(1, &vbo);
    glBindVertexArray(vao);
    glBindBuffer(GL_ARRAY_BUFFER, vbo);
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices), vertices, GL_STATIC_DRAW);

    // Attribute layout for the vertices
    glVertexAttribPointer(0, 2, GL_FLOAT, GL_FALSE, 5 * sizeof(float), (void*)0);
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 5 * sizeof(float), (void*)(2 * sizeof(float)));
    glEnableVertexAttribArray(0);
    glEnableVertexAttribArray(1);

    glBindBuffer(GL_ARRAY_BUFFER, 0);
    glBindVertexArray(0);

    // Compile shaders and create program
    GLuint shaderProgram;
    GLuint vertexShader = glCreateShader(GL_VERTEX_SHADER);
    glShaderSource(vertexShader, 1, &vertexShaderSource, nullptr);
    glCompileShader(vertexShader);

    GLuint fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
    glShaderSource(fragmentShader, 1, &fragmentShaderSource, nullptr);
    glCompileShader(fragmentShader);

    shaderProgram = glCreateProgram();
    glAttachShader(shaderProgram, vertexShader);
    glAttachShader(shaderProgram, fragmentShader);
    glLinkProgram(shaderProgram);
    glDeleteShader(vertexShader);
    glDeleteShader(fragmentShader);

    // Main loop
    while (!glfwWindowShouldClose(window))
    {
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT);

        glUseProgram(shaderProgram);
        glBindVertexArray(vao);

        // Render two triangles
        glDrawArrays(GL_TRIANGLES, 0, 6);

        glfwSwapBuffers(window);
        glfwPollEvents();
    }

    // Cleanup
    glDeleteVertexArrays(1, &vao);
    glDeleteBuffers(1, &vbo);
    glDeleteProgram(shaderProgram);
    glfwTerminate();
    return 0;
}
