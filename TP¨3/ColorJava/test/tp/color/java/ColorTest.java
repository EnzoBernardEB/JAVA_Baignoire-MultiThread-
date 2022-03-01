package tp.color.java.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import tp.color.java.Color;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {
    private Color color;

    @BeforeEach
    public void setUp()  {
        color = new Color(255, 255,255);
    }

    @Test
    public void colorCréeAvecTroisArgument() {
        assertNotNull(new Color(255,122,144),"Instance pas crée");
    }

    @Test
    public void constructeurInvalideLeveIllegalArgumentExceptionPourRouge() {
        assertThrows(IllegalArgumentException.class,() -> new Color(300,155,20));
    }
    @Test
    public void constructeurInvalideLeveIllegalArgumentExceptionPourVert() throws IllegalAccessException {
        assertThrows(IllegalArgumentException.class, () -> new Color(155,300,20));
    }
    @Test
    public void constructeurInvalideLeveIllegalArgumentExceptionPourBleu() throws IllegalAccessException {
        assertThrows(IllegalArgumentException.class, () -> new Color(155,20,300));
    }

    @Test
    public void colorCréeAvecUnArgument() {
        assertNotNull(new Color("#EF8C1D"),"Instance pas crée");
    }

    @Test
    public void constructeurUnArgumentHexadecimalLeveIllegalArgumentExceptionSiMauvaisFormat(){
        assertThrows(IllegalArgumentException.class, () -> new Color("6516+51651"));
    }

    @AfterEach
    public void tearDown() {
        color = null;
    }
}