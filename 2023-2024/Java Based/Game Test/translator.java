import java.awt.Color;

public class translator {
    public static void main(String[] args) {
        Assets tester = new Assets(0, 0, 0, 7);
        Color[][] testColor  = tester.getColorsByType();
        for(var row = 0; row < testColor.length; row++){
            String theStr = "{";
            for(var col = 0; col < testColor[row].length; col++){

            }
        }
    }
}
