import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectFourModelTest {
    @Test
    void testPlay() {
        ConnectFourModel model = new ConnectFourModel();//red
        for (int i=0; i<7; i++) {
            assertTrue(model.play(5));
            if ((i % 2) == 0) {
                assertEquals(model.PLAYER_RED, model.getAtPosition(i,5));
            }else {
                assertEquals(model.PLAYER_YELLOW, model.getAtPosition(i,5));
            }
        }
        assertFalse(model.play(5));
    }

    @Test
    void testUpdateStatusVertical() {
        ConnectFourModel model = new ConnectFourModel();
        model.getStatus();
        for (int i=0; i<3; i++) {
            assertTrue(model.play(5));
            assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
            assertEquals(model.PLAYER_RED, model.getAtPosition(i,5));
            assertTrue(model.play(6));
            assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
            assertEquals(model.PLAYER_YELLOW, model.getAtPosition(i,6));
        }
        assertTrue(model.play(5));
        assertEquals(ConnectFourModel.Status.RED_WON, model.getStatus());
        assertEquals(model.PLAYER_RED, model.getAtPosition(3,5));
    }
    @Test
    void testUpdateStatusHorizontal() {
        ConnectFourModel model = new ConnectFourModel();
        model.getStatus();
        for (int i=0; i<3; i++) {
            assertTrue(model.play(i));
            assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
            assertEquals(model.PLAYER_RED, model.getAtPosition(0,i));
            assertTrue(model.play(i));
            assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
            assertEquals(model.PLAYER_YELLOW, model.getAtPosition(1,i));
        }
        assertTrue(model.play(3));
        assertEquals(ConnectFourModel.Status.RED_WON, model.getStatus());
        assertEquals(model.PLAYER_RED, model.getAtPosition(0,3));
    }
    @Test
    void testUpdateStatusDiagonalRight() {
        ConnectFourModel model = new ConnectFourModel();
        assertTrue(model.play(0));//red
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(1));//yellow
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(1));//red
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(3));//yellow
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(2));//red
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(2));//yellow
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(2));//red
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(0));//yellow
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(3));//red
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(3));//yellow
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(3));//red
        assertEquals(ConnectFourModel.Status.RED_WON, model.getStatus());
    }
    @Test
    void testUpdateStatusDiagonalLeft() {
        ConnectFourModel model = new ConnectFourModel();
        assertTrue(model.play(4));//red
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(5));//yellow
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(3));//red
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(4));//yellow
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(3));//red
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(3));//yellow
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(2));//red
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(2));//yellow
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(2));//red
        assertEquals(ConnectFourModel.Status.UNDECIDED, model.getStatus());
        assertTrue(model.play(2));//yellow
        assertEquals(ConnectFourModel.Status.YELLOW_WON, model.getStatus());
    }
}