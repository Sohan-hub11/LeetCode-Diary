//Sorting Approach T.C -- O(n logn)

/*
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long m = mass;

        Arrays.sort(asteroids);
        for(int num: asteroids){
            if(m >= num){
                m += num;
            } else {
                return false;
            }
        }

        return true;
    }
}
*/

//Counting Array T.C -- O(n)

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long m = mass;

        long[] arr = new long[100001];

        for(int num: asteroids){
            arr[num]++;
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0){
                if(m >= i){
                    m += (i*arr[i]);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}