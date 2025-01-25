package level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 후보키 {
    ArrayList<ArrayList<Integer>> candidateKey = new ArrayList<>();
    ArrayList<Integer> key = new ArrayList<>();
    String[][] relation;
    boolean[] isVisited;
    int numAttributes, num;


    void makeCandidate(int idx) {
        if (key.size() == num) {
            if (checkMinimal() && checkUnique())
                candidateKey.add(new ArrayList<>(key));
            return ;
        }
        for (int i = idx; i < numAttributes; ++i) {
            if (isVisited[i]) continue;
            key.add(i);
            isVisited[i] = true;
            makeCandidate(i + 1);
            isVisited[i] = false;
            key.remove(key.size() - 1);
        }
    }

    boolean checkMinimal() {
        for (ArrayList<Integer> cKey : candidateKey) {
            if (key.containsAll(cKey))
                return false;
        }
        return true;
    }

    boolean checkUnique() {
        Set<ArrayList<String>> set = new HashSet<>();
        for (String[] tuple : relation) {
            ArrayList<String> str = new ArrayList<>();
            for (int i : key)
                str.add(tuple[i]);
            if (set.contains(str))
                return false;
            set.add(str);
        }
        return true;
    }

    public int solution(String[][] pRelation) {
        relation = pRelation;
        numAttributes = pRelation[0].length;
        isVisited = new boolean[numAttributes];

        for (num = 1; num <= numAttributes; ++num)
            makeCandidate(0);

        return candidateKey.size();
    }
}
