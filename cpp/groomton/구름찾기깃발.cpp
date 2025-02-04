#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> board;
int dx[8] = {-1, 0, 1, -1, 1, -1, 0 ,1};
int dy[8] = {-1, -1, -1, 0, 0, 1, 1, 1};

int check_around(int n, int x, int y)
{
    int nx, ny;
    int num = 0;

    for (int i = 0; i < 8; ++i)
    {
        nx = x + dx[i];
        ny = y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n)
            continue;
        if (board[nx][ny] == 1)
            num++;
    }
    return num;
}

int main(void)
{
    int n, k;
    int num;
    int answer = 0;
    vector<int> line;

    cin >> n >> k;
    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            cin >> num;
            line.push_back(num);
        }
        board.push_back(line);
        line.clear();
    }
    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            if(board[i][j] == 0)
            {
                if (check_around(n,i,j) == k)
                    answer++;
            }
        }
    }
    cout << answer << "\n";
    return 0;
}