#include <iostream>
#include <string>
#include <map>

using namespace std;

map<string,int> map_si;
int answer = 0;

void string_set(string s, int index[], int num, int i)
{
    if (num == 2)
    {
        map_si.insert(pair<string, int>(s.substr(0, index[0]), 0));
        map_si.insert(pair<string, int>(s.substr(index[0], index[1] - index[0]), 0));
        map_si.insert(pair<string, int>(s.substr(index[1]), 0));
        return ;
    }
    for (int j = i ; j < s.size(); ++j)
    {
        index[num] = j;
        string_set(s, index, num + 1, j + 1);
    }
}

void find_answer(string s, int index[], int num, int i)
{
    if (num == 2)
    {
        int tmp = map_si[s.substr(0, index[0])] + map_si[s.substr(index[0], index[1] - index[0])] 
                + map_si[s.substr(index[1])];
        if (answer < tmp)
            answer = tmp;
        return ;
    }
    for (int j = i ; j < s.size(); ++j)
    {
        index[num] = j;
        find_answer(s, index, num + 1, j + 1);
    }
}

int main()
{
    int n;
    string str;
    int index[2] = {0, 0};
    int idx = 1;
    cin >> n >> str;
    string_set(str, index, 0, 1);
    for (map<string, int>::iterator  iter = map_si.begin(); iter !=map_si.end(); ++iter)
        iter->second = idx++;
    find_answer(str, index, 0, 1);
    cout << answer << "\n";
    return (0);
}