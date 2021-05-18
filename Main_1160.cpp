#include <iostream>
#include <algorithm>

using namespace std;

struct Cable {
    int from, to, length;

    bool operator< (const Cable& other) {
        return length < other.length;
    }
};

class DisjointSetUnion {

    private: pair<int, int>* nodes;

    public:
        DisjointSetUnion(int size) {
            nodes = new pair<int, int>[size + 1];
            for (int i = 1; i <= size; i++) nodes[i] = {0, i};
        }

        int findRoot(int a) {
            if (a != nodes[a].second) nodes[a].second = findRoot(nodes[a].second);
            return nodes[a].second;
        }

        void merge(int a, int b) {
            if (nodes[a].first > nodes[b].first) nodes[b].second = a;
            else {
                nodes[a].second = b;
                if (nodes[a].first == nodes[b].first) nodes[b].first++;
            }
        }
};

int main() {
    int n, m, maxLength = 0;
    cin >> n >> m;
    Cable cables[m];
    for (int i = 0; i < m; i++) {
        int a, b, l;
        cin >> a >> b >> l;
        cables[i] = {a, b, l};
    }
    sort(cables, cables + m);
    for (int i = 0; i < m; i++) {
        int from = cables[i].from;
        int to = cables[i].to;
        if (dsu->findRoot(from) != dsu->findRoot(to)) {
            if (cables[i].length > maxLength) maxLength = cables[i].length;
            cables[i].length *= -1;
            dsu->merge(dsu->findRoot(from), dsu->findRoot(to));
        }
    }
    cout << maxLength << "\n" << n - 1 << "\n";
    for (Cable c: cables) if (c.length < 0) cout << c.from << " " << c.to << "\n";
    return 0;
}