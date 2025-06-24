package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */


    public String invertirCadena(String texto) {
        Stack<Character> pila = new Stack<>();
        for (char c : texto.toCharArray()) {
            pila.push(c);
        }

        StringBuilder invertido = new StringBuilder();
        while (!pila.isEmpty()) {
            invertido.append(pila.pop());
        }
        return invertido.toString();
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        
        Stack<Character> pila = new Stack<>();
        for (char c : expresion.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                pila.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (pila.isEmpty()) {
                    return false;
                }
                char ultimo = pila.pop();
                if (!((c == '}' && ultimo == '{') ||
                    (c == ']' && ultimo == '[') ||
                    (c == ')' && ultimo == '('))) {
                    return false;
                }
            }
        }
        return pila.isEmpty();

        /*Stack<Character> simbolosAper = new Stack<>();
        Stack<Character> simboloCier= new Stack<>();
        for (char c : expresion.toCharArray()){
            if (c =='{' || c =='[' || c=='(' ){
                simbolosAper.push(c);
            }else if(c =='}' || c ==']' || c==')'){
                simboloCier.push(c);
            }*/
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> pila2 = new Stack<>();
    
    while (!pila.isEmpty()) {
        int temporal = pila.pop();
        
        while (!pila2.isEmpty() && pila2.peek() > temporal) {
            pila.push(pila2.pop());
        }
        
        pila2.push(temporal);
    }
    
    return new ArrayList<>(pila2);

        /*for (int i = 0 ; i<pila.size();i++){

            int ultimo = pila.pop();

            while (ultimo < pila.peek()){
                pila2.push(pila.peek());
                pila.pop();
            }
            pila2.push(ultimo);
        }
        return pila2;*/


    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        LinkedList<Integer> pares = new LinkedList<>();
        LinkedList<Integer> impares = new LinkedList<>();

        for (Integer numero : original) {
            if (numero % 2 == 0) {
                pares.add(numero);
            } else {
                impares.add(numero);
            }
        }

        // Combina las listas de pares e impares
        pares.addAll(impares);
        return pares;
    }
}
