#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <climits>
#include <algorithm>
using namespace std;

typedef pair<int, string> pii;

map<string, vector<pair<string, int>>> graph;

// Add edges
void addEdge(string u, string v, int w) {
    graph[u].push_back({v, w});
    graph[v].push_back({u, w});
}

// Function to print path
void printPath(map<string, string>& parent, string dest) {
    vector<string> path;

    while (dest != "") {
        path.push_back(dest);
        dest = parent[dest];
    }

    reverse(path.begin(), path.end());

    cout << "\nShortest Path: ";
    for (int i = 0; i < path.size(); i++) {
        cout << path[i];
        if (i != path.size() - 1)
            cout << " -> ";
    }
    cout << endl;
}

// Dijkstra Algorithm
void dijkstra(string start, string destination) {
    map<string, int> dist;
    map<string, string> parent;

    for (auto node : graph) {
        dist[node.first] = INT_MAX;
        parent[node.first] = "";
    }

    priority_queue<pii, vector<pii>, greater<pii>> pq;

    dist[start] = 0;
    pq.push({0, start});

    while (!pq.empty()) {
        auto current = pq.top();
        pq.pop();

        int currentDist = current.first;
        string currentNode = current.second;

        for (auto neighbor : graph[currentNode]) {
            string nextNode = neighbor.first;
            int weight = neighbor.second;

            if (currentDist + weight < dist[nextNode]) {
                dist[nextNode] = currentDist + weight;
                parent[nextNode] = currentNode;
                pq.push({dist[nextNode], nextNode});
            }
        }
    }

    if (dist[destination] == INT_MAX) {
        cout << "No path found!" << endl;
        return;
    }

    cout << "\nMinimum Distance: " << dist[destination] << " km" << endl;
    printPath(parent, destination);
}

int main() {
    // Graph setup (12 districts)
    addEdge("Shimla", "Solan", 45);
    addEdge("Shimla", "Mandi", 145);
    addEdge("Shimla", "Sirmaur", 120);

    addEdge("Solan", "Sirmaur", 70);
    addEdge("Solan", "Bilaspur", 90);

    addEdge("Sirmaur", "Una", 150);

    addEdge("Bilaspur", "Hamirpur", 65);
    addEdge("Bilaspur", "Mandi", 75);

    addEdge("Hamirpur", "Una", 50);
    addEdge("Hamirpur", "Kangra", 85);

    addEdge("Una", "Kangra", 60);

    addEdge("Kangra", "Chamba", 110);

    addEdge("Chamba", "Lahaul", 180);

    addEdge("Mandi", "Kullu", 70);

    addEdge("Kullu", "Lahaul", 110);

    addEdge("Lahaul", "Kinnaur", 200);

    addEdge("Kinnaur", "Shimla", 250);

    string start, destination;

    cout << "Available Districts:\n";
    for (auto node : graph) {
        cout << "- " << node.first << endl;
    }

    cout << "\nEnter starting district: ";
    cin >> start;

    cout << "Enter destination district: ";
    cin >> destination;

    // Check if valid
    if (graph.find(start) == graph.end() || graph.find(destination) == graph.end()) {
        cout << "Invalid district name!" << endl;
        return 0;
    }

    dijkstra(start, destination);

    return 0;
}