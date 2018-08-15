package ru.rougegibbons.landsanddungeons.utils.constants;

import java.math.BigDecimal;

/**
 * Class containing various constants that can't be
 * related to a single field of game.
 */
public final class Constants {
    public static final int PERCENTAGE_CAP_INT = 100;
    public static final int WIDE_PERCENTAGE_CAP_INT = 10000;
    public static final float PERCENTAGE_CAP_FLOAT = 1.0f;
    public static final float ONE_PERCENT_FLOAT = 0.01f;
    public static final BigDecimal PERCENTAGE_CAP_BD_FLOAT = new BigDecimal("1.0");
    public static final BigDecimal ONE_PERCENT_BD_FLOAT = new BigDecimal("0.01");

    public static final int DEFAULT_NUMBER_OF_SLOTS_IN_BAG = 20;
}
