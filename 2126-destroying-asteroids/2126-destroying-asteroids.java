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