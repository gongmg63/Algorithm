#include <iostream>

using namespace std;

int main(void)
{
    int n;
    int ans;

    cin >> n;
    
    while (n > 0)
    {
        ans += n / 14;
        n %= 14;
        ans += n / 7;
        n %= 7;
        ans += n;
    }
    cout << ans << "\n";
    return 0;
}