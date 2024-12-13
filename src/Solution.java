import java.util.Arrays;

public class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int[] diffList = Arrays.stream(diffs).sorted().toArray();
        int answer = 1, presentindex = 0;
        long interval = 0;
        for(int diff : diffList) {
            interval = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (diff >= diffs[i]) interval += times[i];
                else {
                    interval += (diffs[i] - diff) * (times[i - 1] + times[i]) + times[i];
                }
                if(interval > limit) break;
            }
            if(interval <= limit) {
                answer = diff;
                break;
            }
            presentindex++;
        }
        if(answer == 1) return answer;
        int shortAnswer = diffList[presentindex -1], biggerAnswer = diffList[presentindex] + 1;

        while(true)
        {
            interval = 0;
            answer = (biggerAnswer + shortAnswer)/2;
            for (int i = 0; i < diffs.length; i++) {
                if (answer >= diffs[i]) interval += times[i];
                else
                {
                    interval += (diffs[i] - answer) * (times[i - 1] + times[i]) + times[i];
                }
                if(interval > limit) break;
            }
            if(interval > limit)
            {
                shortAnswer = answer;
            }
            else if(answer +1 == biggerAnswer) break;
            else {
                biggerAnswer = answer;
            }
        }
        return answer;
    }
}
