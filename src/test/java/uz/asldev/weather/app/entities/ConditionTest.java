package uz.asldev.weather.app.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConditionTest {

    private static final String SUNNY = "Sunny";
    private static final String SUN_ICON = "sun_icon";
    private static final int SUNNY_CODE = 200;

    private static final String CLOUDY = "Cloudy";
    private static final String CLOUD_ICON = "cloud_icon";
    private static final int CLOUDY_CODE = 300;

    @Test
    public void testGettersAndSetters() {
        Condition condition = new Condition();
        condition.setText(SUNNY);
        condition.setIcon(SUN_ICON);
        condition.setCode(SUNNY_CODE);

        assertEquals(SUNNY, condition.getText());
        assertEquals(SUN_ICON, condition.getIcon());
        assertEquals(SUNNY_CODE, condition.getCode());

        Condition conditionParam = new Condition(CLOUDY, CLOUD_ICON, CLOUDY_CODE);

        assertEquals(CLOUDY, conditionParam.getText());
        assertEquals(CLOUD_ICON, conditionParam.getIcon());
        assertEquals(CLOUDY_CODE, conditionParam.getCode());
    }
}