#include <string>
#include <vector>

using namespace std;

vector<int> rate(7);
vector<vector<int>> users;
vector<int> emoticons;
int member = 0;
int sales = 0;

vector<int> CalculatePrice() {
    vector<int> sum_price(users.size(), 0);
    vector<int> ret(2, 0);

    for (int j = 0; j < emoticons.size(); ++j) {
        for (int i = 0; i < users.size(); ++i) {
            int discount_price = emoticons[j] * (100 - rate[j]) / 100;   
        
            if (rate[j] >= users[i][0]) 
                sum_price[i] += discount_price;
        }
    }
    for (int i = 0; i < users.size(); ++i) {
        if (sum_price[i] >= users[i][1]) 
            ++ret[0];
        else
            ret[1] += sum_price[i];
    }
    return ret;
}

void GetRateAndCal(int num) {    
    if (num == 0) {
        vector<int> ret(move(CalculatePrice()));

        if (ret[0] > member) {
            member = ret[0];
            sales = ret[1];
        }
        else if (ret[0] == member) {
            if (sales < ret[1])
                sales = ret[1];
        }
        return ;
    }
    for (int i = 10; i <= 40; i += 10) {
        rate[num - 1] = i;
        GetRateAndCal(num - 1);
    }
}

vector<int> solution(vector<vector<int>> p_users, vector<int> p_emoticons) {
    vector<int> answer;
    users = move(p_users);
    emoticons = move(p_emoticons);
    
    GetRateAndCal(emoticons.size());

    answer.push_back(member);
    answer.push_back(sales);

    return answer;
}