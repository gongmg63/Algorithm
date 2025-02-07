#include <string>

using namespace std;

//3번 던지기 / 0~10점 / S,D,T(1,2,3제곱) / * : 이전점수 * 2, 현재점수 * 2 / # : 현재점수 * -1
// 점수 | 보너스 | [옵션]
int solution(string dartResult) {
    int answer = 0;
    
    int score[3] = {0};
    
    int point = 0, idx = -1;
    for (int i = 0; i < dartResult.size(); ++i) {
        char present = dartResult[i];
        
        if (isdigit(present)) {
            ++idx;
            score[idx] = present - '0';
            if (present == '1') {
                if (dartResult[i + 1] == '0') {
                    score[idx] = 10;
                    ++i;
                }
            }
        }
        else {
            if (present == 'D')
                score[idx] *= score[idx];
            else if (present == 'T')
                score[idx] *= score[idx] * score[idx];
            else if (present == '*') {
                score[idx] *= 2;
                if (idx != 0)
                    score[idx - 1] *= 2;
            }
            else if (present == '#')
                score[idx] *= -1;
        }
    }
    
    return score[0] + score[1] + score[2];
}

#include <sstream>
#include <iostream>

int useStringStream(string dartResult) {
    int scores[3] = {0};
    istringstream ss(dartResult);

    for (int i = 0; i < 3; ++i) {
        int score;
        char area, option;

        ss >> score >> area >> option;

        if (isdigit(option))
            ss.unget();
        cout << score << " " << area << " " << option << "\n";
    }
    return 0;
}
