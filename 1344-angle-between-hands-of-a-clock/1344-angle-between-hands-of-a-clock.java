class Solution {
    public double angleClock(int hour, int minutes) {
        //T.C -- O(1), S.C -- O(1)

        // Hour hand moves 30 degrees per hour, plus 0.5 degrees per minute (drift)
        double getHourDeg = (hour % 12) * 30 + (0.5 * minutes);
        
         // Minute hand moves 6 degrees per minute
        double getMinDeg = minutes * 6;

        double diff = Math.abs(getHourDeg - getMinDeg);

        // Return the smaller of the two angles formed (clockwise vs counter-clockwise)
        return Math.min(diff, (360 - diff));
    }
}