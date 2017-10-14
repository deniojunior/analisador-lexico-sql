package roles;

import java.util.ArrayList;

/**
 * @author deniojunior
 */
public class Language {
 
    private static Language instance = new Language();
    
    public Language(){}
    
    public static Language getInstance(){
        return instance;
    }
    
    public static ArrayList<String[]> initSQLTokensLexems(){
        ArrayList<String[]> palavrasReservadas = new ArrayList<>();
        String tokens_lexemas[] = new String[2];
        
        tokens_lexemas[0] = "SELECT";
        tokens_lexemas[1] = "<SELECT>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "INSERT";
        tokens_lexemas[1] = "<INSERT>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "DELETE";
        tokens_lexemas[1] = "<DELETE>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "UPDATE";
        tokens_lexemas[1] = "<UPDATE>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "INTO";
        tokens_lexemas[1] = "<INTO>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "VALUES";
        tokens_lexemas[1] = "<VALUES>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "SET";
        tokens_lexemas[1] = "<SET>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "FROM";
        tokens_lexemas[1] = "<FROM>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "WHERE";
        tokens_lexemas[1] = "<WHERE>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "AND";
        tokens_lexemas[1] = "<AND>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "BETWEEN";
        tokens_lexemas[1] = "<BETWEEN>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "IN";
        tokens_lexemas[1] = "<IN>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "OR";
        tokens_lexemas[1] = "<OR>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "ON";
        tokens_lexemas[1] = "<ON>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "BY";
        tokens_lexemas[1] = "<BY>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "AS";
        tokens_lexemas[1] = "<AS>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "LIKE";
        tokens_lexemas[1] = "<LIKE>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "GROUP";
        tokens_lexemas[1] = "<GROUP>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "HAVING";
        tokens_lexemas[1] = "<HAVING>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "INNER";
        tokens_lexemas[1] = "<INNER>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "UNION";
        tokens_lexemas[1] = "<UNION>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "JOIN";
        tokens_lexemas[1] = "<JOIN>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "ORDER";
        tokens_lexemas[1] = "<ORDER>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "NULL";
        tokens_lexemas[1] = "<NULL>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "=";
        tokens_lexemas[1] = "<OPERADOR>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = ">";
        tokens_lexemas[1] = "<OPERADOR>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "<";
        tokens_lexemas[1] = "<OPERADOR>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = ">=";
        tokens_lexemas[1] = "<OPERADOR>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "<=";
        tokens_lexemas[1] = "<OPERADOR>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "'";
        tokens_lexemas[1] = "<ASPAS>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "*";
        tokens_lexemas[1] = "<TODOS>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = ",";
        tokens_lexemas[1] = "<VIRGULA>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = "(";
        tokens_lexemas[1] = "<PARENTESES_ABRE>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = ")";
        tokens_lexemas[1] = "<PARENTESES_FECHA>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = ";";
        tokens_lexemas[1] = "<PONTO-E-VIRGULA>";
        palavrasReservadas.add(tokens_lexemas);
        
        tokens_lexemas = new String[2];
        tokens_lexemas[0] = ".";
        tokens_lexemas[1] = "<PONTO>";
        palavrasReservadas.add(tokens_lexemas);   
        
        return palavrasReservadas;
    }
}