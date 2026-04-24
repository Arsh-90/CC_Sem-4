const graph = {
    "Shimla": {"Solan": 45, "Mandi": 145, "Sirmaur": 120},
    "Solan": {"Shimla": 45, "Sirmaur": 70, "Bilaspur": 90},
    "Sirmaur": {"Shimla": 120, "Solan": 70, "Una": 150},
    "Bilaspur": {"Solan": 90, "Hamirpur": 65, "Mandi": 75},
    "Hamirpur": {"Bilaspur": 65, "Una": 50, "Kangra": 85},
    "Una": {"Hamirpur": 50, "Sirmaur": 150, "Kangra": 60},
    "Kangra": {"Una": 60, "Hamirpur": 85, "Chamba": 110},
    "Chamba": {"Kangra": 110, "Lahaul": 180},
    "Mandi": {"Shimla": 145, "Bilaspur": 75, "Kullu": 70},
    "Kullu": {"Mandi": 70, "Lahaul": 110},
    "Lahaul": {"Kullu": 110, "Chamba": 180, "Kinnaur": 200},
    "Kinnaur": {"Lahaul": 200, "Shimla": 250}
};

const districts = Object.keys(graph);
const source = document.getElementById("source");
const destination = document.getElementById("destination");
const loader = document.getElementById("loader");
const mapImg = document.getElementById("map");

// Fill dropdowns
districts.forEach(d => {
    source.innerHTML += `<option>${d}</option>`;
    destination.innerHTML += `<option>${d}</option>`;
});

function dijkstra(start, end) {
    let dist = {}, prev = {}, pq = [];

    districts.forEach(d => {
        dist[d] = Infinity;
        prev[d] = null;
    });

    dist[start] = 0;
    pq.push([0, start]);

    while (pq.length) {
        pq.sort((a,b)=>a[0]-b[0]);
        let [cost, node] = pq.shift();

        for (let neighbor in graph[node]) {
            let newCost = cost + graph[node][neighbor];
            if (newCost < dist[neighbor]) {
                dist[neighbor] = newCost;
                prev[neighbor] = node;
                pq.push([newCost, neighbor]);
            }
        }
    }

    let path = [];
    let curr = end;

    while (curr) {
        path.push(curr);
        curr = prev[curr];
    }

    return {
        distance: dist[end],
        path: path.reverse()
    };
}

function findPath() {
    let s = source.value;
    let d = destination.value;

    loader.classList.remove("hidden");
    document.getElementById("result").innerHTML = "";
    mapImg.classList.remove("highlight");

    // Fake loading delay (for animation)
    setTimeout(() => {
        let result = dijkstra(s, d);

        loader.classList.add("hidden");

        document.getElementById("result").innerHTML =
            `<h3>Distance: ${result.distance} km</h3>
             <p>Path: ${result.path.join(" → ")}</p>`;

        // Highlight map
        mapImg.classList.add("highlight");

    }, 1200);
}