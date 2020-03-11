package com.yulmaso.game.Tools;

import com.yulmaso.game.Containers.Constants;
import com.yulmaso.game.Containers.EnemyType;

import java.util.Random;

public class RandomUtils {

    public static EnemyType getRandomEnemyType(){
        RandomEnum<EnemyType> randomEnum = new RandomEnum<EnemyType>(EnemyType.class);
        return randomEnum.random();
    }

    private static class RandomEnum<E extends Enum>{

        private static final Random random = new Random();
        private final E[] values;

        private RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random(){
            return values[random.nextInt(values.length)];
        }
    }

    public static float getRandomEnemyY(){
        Random random = new Random();
        return (float) random.nextInt((int)Constants.ENEMY_Y - 3) + 3 ;
    }

}
