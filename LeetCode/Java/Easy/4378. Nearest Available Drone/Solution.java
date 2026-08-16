class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int minDistance = Integer.MAX_VALUE;
        int index = -1;

        for(int i = 0; i< drones.length; i++){
            int distance = Math.abs(target[0] - drones[i][0]) + Math.abs(target[1] - drones[i][1]);

            if(distance <= drones[i][2] && distance < minDistance){
                minDistance =  distance;
                index = i;
            }
        }

        return index;
    }
}