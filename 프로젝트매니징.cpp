#include <iostream>

using namespace std;

int check_hour(int t)
{
    if (t >= 24)
        return (t % 24);
    return (t);
}

int check_minute(int m)
{
    if (m >= 60)
        return (m % 60);
    return (m);
}

int main() {
    int N, T, M, ci;
    int hour;
    int minute;

    cin >> N;
    cin >> T;
    cin >> M;
    for (int i = 0; i < N; ++i)
    {
        cin >> ci;
        hour = ci / 60;
        minute = ci % 60;
        if (M + minute >= 60)
            T++;
        T = check_hour(T + hour);
        M = check_minute(M + minute);
    }
    cout << T << " " << M << "\n";
	return 0;
}