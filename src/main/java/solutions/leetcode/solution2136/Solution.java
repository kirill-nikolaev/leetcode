package solutions.leetcode.solution2136;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<Plant> plants = new ArrayList<>();
        for (int i = 0; i < plantTime.length; i++)
            plants.add(new Plant(plantTime[i], growTime[i]));

        plants.sort((x, y) -> y.growTime - x.growTime);

        int overallPlantTime = 0;
        int maxBloomTime = 0;
        for (int i = 0; i < plants.size(); i++) {
            Plant plant = plants.get(i);
            overallPlantTime += plant.plantTime;
            maxBloomTime = Math.max(maxBloomTime, overallPlantTime + plant.growTime);
        }

        return maxBloomTime;
    }

    private static class Plant {
        int plantTime;
        int growTime;

        public Plant(int plantTime, int growTime) {
            this.plantTime = plantTime;
            this.growTime = growTime;
        }
    }
}
