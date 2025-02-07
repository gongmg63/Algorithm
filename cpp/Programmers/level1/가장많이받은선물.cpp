#include <string>
#include <vector>
#include <map>
#include <sstream>
#include <algorithm>

using namespace std;

// 두 사람이 선물을 주고 받았으면 다음달에 덜 준애가 하나 더 선물 (주고받은 적이 없거나 같은면 선물지수가 더 작은 사람이 선물 전달)
// 선물지수는 내가 친구들에게 준 선물의 수 - 받은 선물 수
// 선물지수까지 같으면 주고받지 않음
// 다음달 선물을 가장 많이 받을 사람의 선물 수

int solution(vector<string> friends, vector<string> gifts) {
    int answer = 0;
    
    map<string, map<string, int>> log;
    map<string, int> gift_point;
    map<string, int> next_month;
    
    for (int i = 0; i < friends.size(); ++i) {
        log.insert({friends[i], map<string,int>()});
        gift_point.insert({friends[i], 0});
        next_month.insert({friends[i], 0});
        for (int j = 0; j < friends.size(); ++j) {
            if (i == j) continue;
            log[friends[i]].insert({friends[j], 0});
        }
    }
    
    for (int i = 0; i < gifts.size(); ++i) {
        istringstream iss(gifts[i]);
        
        string give, receive;
        
        getline(iss, give, ' ');
        getline(iss, receive);
        
        ++log[give][receive];
    }
    
    for (string give : friends) {
        for (auto receive : log[give]) {
            gift_point[give] += receive.second;
            gift_point[receive.first] -= receive.second;
        }
    }

    for (string give : friends) {
        for (auto receive : log[give]) {
            if (log[receive.first][give] == receive.second) {
                if (gift_point[give] > gift_point[receive.first]) 
                    ++next_month[give];
                else if (gift_point[give] < gift_point[receive.first])
                    ++next_month[receive.first];
            }
            else {
                string get_name = (log[receive.first][give] > receive.second ? receive.first : give);
                ++next_month[get_name];
            }
        }
    }
    
    for (auto n : next_month) {
        answer = max(n.second, answer);
    }
    
    return answer / 2;
}