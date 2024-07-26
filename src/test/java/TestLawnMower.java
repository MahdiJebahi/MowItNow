import entities.Lawn;
import entities.Mower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLawnMower {

    @Test
    public void testTurnLeft(){
        Mower mower = new Mower(0, 0, 'N', new Lawn(5, 5));
        mower.move("G");
        assertEquals("0 0 W", mower.getPosition());

    }

    @Test
    public void testTurnRight(){
        Mower mower = new Mower(0, 0, 'N', new Lawn(5, 5));
        mower.move("D");
        assertEquals("0 0 E", mower.getPosition());

    }

    @Test
    public void testAdvance(){
        Mower mower = new Mower(0, 0, 'N', new Lawn(5, 5));
        mower.move("A");
        assertEquals("0 1 N", mower.getPosition());

    }

    @Test
    public void testMowerDoesNotMoveOutsideLawn() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(0, 0, 'S', lawn);
        mower.move("A");
        assertEquals("0 0 S", mower.getPosition());

        mower = new Mower(0, 0, 'W', lawn);
        mower.move("A");
        assertEquals("0 0 W", mower.getPosition());

        mower = new Mower(5, 5, 'N', lawn);
        mower.move("A");
        assertEquals("5 5 N", mower.getPosition());

        mower = new Mower(5, 5, 'E', lawn);
        mower.move("A");
        assertEquals("5 5 E", mower.getPosition());
    }

    @Test
    public void testMowerCase1(){
        Mower mower = new Mower(1, 2, 'N', new Lawn(5,5));
        mower.move("GAGAGAGAA");
        assertEquals("1 3 N", mower.getPosition());
    }
    @Test
    public void testMowerCase2(){
        Mower mower = new Mower(3, 3, 'E', new Lawn(5,5));
        mower.move("AADAADADDA");
        assertEquals("5 1 E", mower.getPosition());
    }

}
