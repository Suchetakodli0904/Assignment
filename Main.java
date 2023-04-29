/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/


class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int res[] = new int[2];
        double maxQuality = 0;
        double quality = 0;
        int finalX = 0;
        int finalY = 0;
        for(int i=0; i<51; i++) {
            for(int j=0; j<51; j++) {
                quality = 0;
                for(int[] tower: towers) {
                    int x = tower[0]-i;
                    int y = tower[1]-j;
                    double dist = Math.sqrt(x*x+y*y); 
                    if(dist <= radius) quality += Math.floor(tower[2]/(1+dist));
                }
                if(maxQuality < quality) {
                    maxQuality = quality;
                    finalX = i;
                    finalY = j;
                }
            }
        }
        res[0] = finalX;
        res[1] = finalY;
        return res;
    }
}