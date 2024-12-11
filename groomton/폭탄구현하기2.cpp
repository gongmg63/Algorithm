#include <iostream>
#include <vector>
#include <string>

using namespace std;

int what_plus(char c)
{
    if (c == '#')
        return 0;
    if (c == '0')
        return 1;
    if (c == '@')
        return 2;
}

int check_max(vector<vector<int>> board)
{
    int max = 0;

    for (int i = 0; i < board.size(); ++i)
    {
        for (int j = 0; j < board.size(); ++j)
        {
            if (board[i][j] > max)
                max = board[i][j];
        }
    }
    return max;
}

int main(void)
{
    int n, k, py, px;
    int y, x;
    vector<vector<char>> o_board;
    vector<vector<int>> r_board;
    char c;
    int dy[4] = {-1, 0 , 1, 0};
    int dx[4] = {0, -1, 0, 1};

    cin >> n >> k;
    for (int i = 0; i < n; ++i)
    {
        o_board.push_back(vector<char>());
        r_board.push_back(vector<int>());
        for (int j = 0; j < n; ++j)
        {
            cin >> c;
            o_board[i].push_back(c);
            r_board[i].push_back(0);
        }
    }
    for (int i = 0; i < k; ++i)
    {
        cin >> y >> x;
        y--;
        x--;
        r_board[y][x] += what_plus(o_board[y][x]);
        for (int j = 0; j < 4; ++j)
        {
            py = y + dy[j];
            px = x + dx[j];
            if (py < 0 || px < 0 || py >= n || px >= n)
                continue;
            r_board[py][px] += what_plus(o_board[py][px]);
        }
    }
    cout << check_max(r_board) << "\n";
}