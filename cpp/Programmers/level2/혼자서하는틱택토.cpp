#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

char winner;

int DiffOX(vector<string>& board) {
    vector<int> ox(2,0);

    for (string line : board) {
        for (char c : line) {
            if (c == 'O')
                ++ox[0];
            else if (c == 'X')
                ++ox[1];
        }
    }
    return ox[0] - ox[1];
}

bool CheckWinner(vector<string>& board) {
    vector<string> bingo(board);

    for (int i = 0; i < 3; ++i) 
        bingo.emplace_back(string{board[0][i], board[1][i], board[2][i]});

    bingo.emplace_back(string{board[0][0], board[1][1], board[2][2]});
    bingo.emplace_back(string{board[2][0], board[1][1], board[0][2]});

    auto o_it = find(bingo.begin(), bingo.end(), "OOO");
    auto x_it = find(bingo.begin(), bingo.end(), "XXX");

    if (o_it != bingo.end() && x_it != bingo.end()) {
        winner = 'F';
        return true;
    }
    if (o_it != bingo.end() && x_it == bingo.end()) {
        winner = 'O';
        return true;
    }
    else if (x_it != bingo.end() && o_it == bingo.end()) {
        winner = 'X';
        return true;
    }
    return false;
}

int solution(vector<string> board) {
    int diff_ox = DiffOX(board);

    if (CheckWinner(board)) {
        if (winner == 'O' && diff_ox == 1)
            return 1;
        else if (winner == 'X' && diff_ox == 0)
            return 1;
        else
            return 0;
    }
    if (diff_ox == 0 || diff_ox == 1)
        return 1;
    return 0;
}