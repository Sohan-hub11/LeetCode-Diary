class Solution {
    public int[] scoreValidator(String[] events) {
        int n = events.length;
        int score = 0;
        int counter = 0;

        int[] ans = new int[2];

        for(int i=0; i<n; i++){
            if(counter == 10)
                break;
            else {
                if(events[i].equals("W"))
                    counter++;
                else if(events[i].equals("WD") || events[i].equals("NB"))
                    score++;
                else{
                    int num = Integer.parseInt(events[i]);
                    score += num;
                }
            }
        }

        ans[0] = score;
        ans[1] = counter;

        return ans;
    }
}