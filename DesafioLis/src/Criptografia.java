
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Criptografia {
    private static ArrayList<Character>criptografia;
    private  static Map<Character,Integer>cript;
    private static char alphabet[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','.',',',';','!','?'};
    public static void main(String[] args) {
        cript= new HashMap<>();
        criptografia = new ArrayList<>();
        //Sincroniza o char e o valor numerico dele
       for (int i = 0; i <alphabet.length ; i++) {
           cript.put(alphabet[i],i);
       }

        Scanner in = new Scanner(System.in);
        System.out.println("Type the name of file");
         // Para leitura de arquivo
        String filePath = Paths.get(in.nextLine()).toAbsolutePath().toString();
        filePath = filePath.replace("src","");
        Path path = Paths.get(filePath);

        //Guardar dados do arquivo no array de char
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String line =null;
            String message="";
            while ((line = reader.readLine()) !=null){
                message=line;
                for (int i = 0; i <message.length() ; i++) {

                    char c= message.charAt(i);
                    if (message.charAt(i) == '#' && (int)c == 35 ) {
                        criptografia.add(' ');

                    }
                    else criptografia.add(message.charAt(i));
                }

            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }


        System.out.println("Translate: "+translate());
    }


// faz o teste das chaves possiveis e exibe todas as traduções, é um teste de força bruta para todas as combinações
       public static String translate(){
            int count=0;
            int key =0;
            String traducao="";
           for (int i = 1; i <31 ; i++) {
               for (int j = 0; j < criptografia.size() ; j++) {
                   if(criptografia.get(j) != ' '){
                       key=cript.get(criptografia.get(j))+i;
                       while(key>30){
                           key=key- 31;
                       }
                       traducao+= alphabet[key];
                   }
                   else{
                        traducao+=criptografia.get(j);
                   }

               }
               System.out.println("=================================================================================");
               System.out.println("test "+i+" with the key: "+key+" results: "+ traducao);
               System.out.println("=================================================================================");

                traducao="";
           }

           return traducao;
       }

}
