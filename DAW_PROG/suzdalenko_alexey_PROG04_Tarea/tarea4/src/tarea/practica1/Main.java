package tarea.practica1;
public class Main {
    public static void main(String[] args) {
        String[] title = {"N", "10*N", "100*N", "1000*N", ""};
        Integer[] numbers = {1 ,2, 3, 4, 5};
        Integer[] potence = {1, 10, 100, 1000};
        String[] emptyStr = {"   ", "     ", "     ", "    "}; 
        
        String outTitle = "";
        String outLines = "";
    
        for(int i = 0; i < numbers.length; i++) {
            outTitle += title[i] + emptyStr[0];
            for(int y = 0; y < numbers.length; y++){     
                if(y == 4) continue;
                outLines += String.valueOf(numbers[i] * potence[y]) + emptyStr[y];
            }
            outLines += "\n";
        }
        
        System.out.println(outTitle + "\n");
        System.out.println(outLines);
    }   
}
