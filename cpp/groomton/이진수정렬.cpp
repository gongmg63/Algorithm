#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b)
{
    if (a.second > b.second)
        return (true);
    else if (a.second == b.second)
    {
        if (a.first > b.first)
            return (true);
    }
    return (false);
}

int bit_count(int a)
{
    int x = 0;
    while (a != 0)
    {
        x += (a % 2);
        a = a >> 1;
    }
    return (x);
}

int main()
{
    int n, k;
    int num;
    int one_num;
    vector<pair<int, int>> v;

    cin >> n >> k;
    for (int i = 0; i < n; ++i)
    {
        cin >> num;
        one_num = bit_count(num);
        v.push_back(make_pair(num, one_num));
    }
    sort(v.begin(), v.end(), cmp);
    cout << v[k - 1].first << "\n";
    return (0);
}