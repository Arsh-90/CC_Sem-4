#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        string s;
        cin >> s;

        if (n == 1) {
            cout << s << "\n";
            continue;
        }

        unordered_map<char, int> freq;
        for (char c : s) freq[c]++;

        char mx = s[0];
        for (auto& p : freq) {
            if (p.second > freq[mx])
                mx = p.first;
        }

        char mn = 0;
        for (auto& p : freq) {
            if (p.first != mx) {
                if (mn == 0 || p.second < freq[mn])
                    mn = p.first;
            }
        }

        if (mn == 0) {
            cout << s << "\n";
            continue;
        }

        for (char& c : s) {
            if (c == mn) {
                c = mx;
                break;
            }
        }

        cout << s << "\n";
    }
    return 0;
}