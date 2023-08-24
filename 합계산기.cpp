#include <iostream>

using namespace std;

int cal(int l, int r, char op)
{
    if (op == '+')
        return (l + r);
    if (op == '-')
        return (l - r);
    if (op == '*')
        return (l * r);
    if (op == '/')
        return (l / r);
}

int main() {
    int answer = 0;
    int n;
    int left, right;
    char op;

    cin >> n;
    for (int i = 0; i < n; ++i)
    {
        cin >> left;
        cin >> op;
        cin >> right;
        answer += cal(left, right, op);
    }
    cout << answer << "\n";
	return 0;
}