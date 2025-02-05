#include <string>
#include <vector>
#include <iostream>

using namespace std;

int count = 0;
int rows[13];

bool Promising(int depth) {
    for (int i = 1; i < depth; ++i) {
        if (rows[i] == rows[depth]) // 같은 행에 있는 경우
            return false;
        else if (rows[i] + i == rows[depth] + i) // 우 상향 대각선인 경우
            return false;
        else if (rows[i] - i == rows[depth] - i) // 좌 상향 대각선인 경우
            return false;
    }
    return true;
}

void NQueen(int depth, int n) {
    if (depth == n) {
        ++count;
        return ;
    }
    for (int i = 1; i <= n; ++i) {
        rows[depth + 1] = i;
        
        if (!Promising(depth + 1)) 
            continue;
        NQueen(depth + 1, n);
    }
}

int solution(int n) {
    NQueen(0, n);
    return count;
}