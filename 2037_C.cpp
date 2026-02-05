#include <bits/stdc++.h>
using namespace std;

bool isPrime(int x) {
    if (x < 2) return false;
    for (int i = 2; i * i <= x; i++)
        if (x % i == 0)
            return false;
    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;

        if (n <= 4) {
            cout << -1 << "\n";
            continue;
        }

        vector<int> evens, odds;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) evens.push_back(i);
            else odds.push_back(i);
        }

        int last_even = evens.back();

        int chosen = -1;
        for (int x : odds) {
            if (!isPrime(last_even + x)) {
                chosen = x;
                break;
            }
        }

        if (chosen == -1) {
            cout << -1 << "\n";
            continue;
        }

        for (int x : evens)
            cout << x << " ";

        cout << chosen << " ";

        for (int x : odds) {
            if (x != chosen)
                cout << x << " ";
        }

        cout << "\n";
    }
    return 0;
}