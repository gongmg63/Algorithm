#include <iostream>

using namespace std;

int main() {
    int w;
    float r;
    cin >> w >> r;
    cout << (int) (w * (1 + r / 30)) << "\n";
	return 0;
}