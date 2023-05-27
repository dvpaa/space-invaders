package org.newdawn.spaceinvaders.configuration;

import java.util.ArrayList;
import java.util.List;

public class GameConfig {

    private List<StageConfig> stageConfigs;
//    private StageConfig whatStage;

    public GameConfig(String shipType, int stage) {


        stageConfigs = new ArrayList<>();
        stageConfigs.add(null); // 0번 인덱스는 사용하지 않음

        switch (stage) {
            case 1: //stage1
                stageConfigs.add(new StageConfig(1, "sprites/alien2.png", 2, 1, 3,
                        300, "sprites/boss1.png", 50, 2, -300,
                        "sprites/boss2.png", 500, shipType));
                break;
            case 2: // stage2
                stageConfigs.add(new StageConfig(2, "sprites/alien2.png", 2, 1, 3,
                        300, "sprites/boss1.png", 50, 2, -300,
                        "sprites/boss2.png", 500, shipType));
                break;
            case 3: //stage3
                stageConfigs.add(new StageConfig(3, "sprites/alien4., png", 4, 2, 4, 400,
                        "sprites/boss3.png", 50, 2, -400,
                        "sprites/alienshot.png", 600, shipType));
                break;
            case 4: //stage4
                stageConfigs.add(new StageConfig(4, "sprites/alien5.png", 5, 2, 4, 400,
                        "sprites/boss4.png", 70, 2, -400,
                        "sprites/alienshot.png", 600, shipType));
                break;
            case 5: //stgae5
                stageConfigs.add(new StageConfig(5, "sprites/alien5.png", 5, 3, 4, 400,
                        "sprites/boss5.png", 100, 3, -500,
                        "sprites/alienshot.png", 600, shipType));
                break;
        }
    }


        /*
        switch (stage) {
            case 1: //stage1
                whatStage = new StageConfig(1, "sprites/alien2.png", 2, 1, 3,
                        300, "sprites/boss1.png", 50, 2, -300,
                        "sprites/boss2.png", 500, shipType);
                break;
            case 2: // stage2
                whatStage = new StageConfig(2, "sprites/alien2.png", 2, 1, 3,
                        300, "sprites/boss1.png", 50, 2, -300,
                        "sprites/boss2.png", 500, shipType);
                break;
            case 3: //stage3
                whatStage = new StageConfig(3, "sprites/alien4., png", 4, 2, 4, 400,
                        "sprites/boss3.png", 50, 2, -400,
                        "sprites/alienshot.png", 600, shipType);
                break;
            case 4: //stage4
                whatStage = new StageConfig(4, "sprites/alien5.png", 5, 2, 4, 400,
                        "sprites/boss4.png", 70, 2, -400,
                        "sprites/alienshot.png", 600, shipType);
                break;
            case 5: //stgae5
                whatStage = new StageConfig(5, "sprites/alien5.png", 5, 3, 4, 400,
                        "sprites/boss5.png", 100, 3, -500,
                        "sprites/alienshot.png", 600, shipType);
                break;
        }
     }
         */
}
