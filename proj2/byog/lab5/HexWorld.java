package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.net.CacheRequest;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    protected static class Position{
        private int px;
        private int py;
        public Position(int px, int py){
            this.px = px;
            this.py = py;
        }
    }
    public static int RowWidth(int s, int i){
        int temp = i;
        if(i >= s){
            temp = 2 * s - 1 - temp;
        }
        return s + 2 * temp;
    }
    public static int rowOffset(int s, int i){
        return ((3 * s - 2) - RowWidth(s,i)) / 2;
    }
    public static void initWorld(TETile[][] tiles){
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[0].length; j++){
                tiles[i][j] = Tileset.NOTHING;
            }
        }
    }
    public static void addHexagon(TETile[][] tiles,Position p,int n,TETile t){
        for(int i = 0; i < 2 * n; i++){
            int titleNum = RowWidth(n,i);
            int xOffset = rowOffset(n,i);

            for(int k = 0; k < titleNum; k++){
                tiles[p.px + i][p.py + xOffset + k] = t;
            }
        }

    }
    public static void drawVerticalHex(TETile[][] world, int n){

    }


    @Test
    public void testHexRowWidth() {
        assertEquals(3, RowWidth(3, 5));
        assertEquals(5, RowWidth(3, 4));
        assertEquals(7, RowWidth(3, 3));
        assertEquals(7, RowWidth(3, 2));
        assertEquals(5, RowWidth(3, 1));
        assertEquals(3, RowWidth(3, 0));
        assertEquals(2, RowWidth(2, 0));
        assertEquals(4, RowWidth(2, 1));
        assertEquals(4, RowWidth(2, 2));
        assertEquals(2, RowWidth(2, 3));
    }
    @Test
    public void testHexRowOffset() {
        assertEquals(2, rowOffset(3, 5));
        assertEquals(1, rowOffset(3, 4));
        assertEquals(0, rowOffset(3, 3));
        assertEquals(0, rowOffset(3, 2));
        assertEquals(1, rowOffset(3, 1));
        assertEquals(2, rowOffset(3, 0));
        assertEquals(1, rowOffset(2, 0));
        assertEquals(0, rowOffset(2, 1));
        assertEquals(0, rowOffset(2, 2));
        assertEquals(1, rowOffset(2, 3));
    }

    public static void main( String[] args) {
        int WIDTH = 50;
        int HEIGHT = 50;
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        Position newP = new Position(1,1);
        TETile[][] hexWorld = new TETile[WIDTH][HEIGHT];
        initWorld(hexWorld);
        addHexagon(hexWorld,newP,4,Tileset.FLOWER);
        Position newP2 = new Position(6,1);
        addHexagon(hexWorld,newP2,3,Tileset.GRASS);

        ter.renderFrame(hexWorld);
    }


}
