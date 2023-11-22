package tarea.practica5;
public class Practica5 {
    public static void main(String[] args) {
        String[] happyCristams = {"*", " ", "¡", "F", "E", "L", "I", "Z", " ", "N", "A", "V", "I", "D", "A", "D", "!", " ", "*"};
        int i = 0;
        int j;
        int max = 10;
        String space;
        String star;
        String outResult = "";
        while (i < max) {
            space = "";
            star = "";
            for (j = 0; j < max - i; j++) space += " ";
            for (j = 0; j < 2 * i + 1; j++) star += "*";
            outResult += space+star+"\n";
            i++;
        }
        i = 0;
        while (i < 4) {
            for (j = 0; j < 10; j++) outResult += " ";
            outResult += "* \n";
            i++;
        }
        outResult += " ";
        for (j = 0; j < 19; j++) outResult +="*";
        outResult += "\n ";
        for (j = 0; j < happyCristams.length; j++) outResult += happyCristams[j];
        outResult += "\n ";
        for (j = 0; j < 19; j++) outResult +="*";
        System.out.println(outResult);
    }
}
