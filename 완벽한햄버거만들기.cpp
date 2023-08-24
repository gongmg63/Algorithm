#include <iostream>

using namespace std;

int main() {
    int answer = 0;
    int n;
    int material, next_m;
    bool asc = false;
    bool des = false;
	
    cin >> n;
    cin >> material;
    answer += material;
    for (int i = 0; i < n - 1; ++i)
    {
        cin >> next_m;
        answer += next_m;
        if (material < next_m)
        {
            asc = true;
            if (des)
            {
                cout << "0\n";
                return (0);
            }
        }
        else if (material > next_m)
            des = true;
        material = next_m;
    }
    cout << answer << "\n";
    return 0;
}