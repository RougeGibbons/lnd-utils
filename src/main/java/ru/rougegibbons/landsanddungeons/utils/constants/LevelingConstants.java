package ru.rougegibbons.landsanddungeons.utils.constants;

/**
 * Class containing constants related with
 * characters, NPCs, items and rewards leveling.
 */
public final class LevelingConstants {
    public static final int START_LEVEL = 1;
    public static final int MAX_LEVEL = 60;
    public static final int FIRST_LEVEL_UP_CAP = 100;
    public static final int SKILL_POINTS_GRANTED_PER_LEVEL = 1;
    public static final int LEVEL_RANGE_FOR_LOOT_DROPPING = 5;

    public static final int INITIAL_HITPOINTS_CAP = 100;
    public static final int HITPOINTS_PER_ENDURANCE_POINT = 60;
    @SuppressWarnings("FieldNamingConvention")
    public static final int HITPOINTS_PER_FIRST_TWENTY_POINTS = 1;
    public static final int ENDURANCE_BONUS_JUMP_POINT = 20;

    public static final float MINIMAL_DAMAGE_REDUCTION = 0.05f;

    public static final float STATS_GROWTH_PER_LEVEL = 0.03f;
    public static final float CASH_REWARD_GROWTH_PER_LEVEL = 0.025f;

    public static final int INITIAL_CASH_REWARD = 5;

    public static final int DEFAULT_INITIATIVE_VALUE = 10;
    public static final int DEFAULT_ALIVE_ENTITY_SPEED = 4;
}
