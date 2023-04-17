package org.mp.sesion04;

import java.util.StringTokenizer;

/**
 * Clase Evaluador
 * @author Sarai Besada Pino
 * @version Sesion04
 * Clase Evaluador
 */
public class Evaluador {

	private GenericStack<Integer> pila = new GenericStack<>();

	/**
	 * Constructor por defecto.
	 */
	public Evaluador() {	
	}

	/**
	 * Metodo que elimina los espacios blancos de la expresión.
	 * @param expresion String con blancos
	 * @return la expresión sin espacios blancos
	 */
	public String [] eliminarBlancos(String expresion) {
		StringTokenizer exp1 = new StringTokenizer(expresion, "    */+-()", true);
		GenericQueue<String> exp2 = new GenericQueue<>();

		while (exp1.hasMoreTokens()) {
			String token = exp1.nextToken();
			if(!token.equals(" ")) exp2.enqueue(token);
		}
		String [] array = new String[exp2.getSize()];
		for(int i = 0; i < array.length; i++) {
			array [i] = exp2.dequeue();
		}
		return array;
	}

	/**
	 * Metodo que procesa el operador que recibe por paramentros y devuelve el resultado de la operación.
	 * @param op 
	 * 	Operador de la operación.
	 * @param operandosPila 
	 * 	Pila donde se almacena el resultado.
	 */
	public void procesarUnOperador(char op, GenericStack<Integer> operandosPila) {
		int op1, op2;
		Integer resultado = 0;
		op2 = operandosPila.pop();
		op1 = operandosPila.pop();

		switch(op){
		case '+' : 
			resultado = op1 + op2;
			break;
		
		case '-' : 
			resultado = op1 - op2;
			break;
		
		case '*' : 
			resultado = op1 * op2;
			break;
			
		case '/' : 
			if(op2 == 0) throw new RuntimeException("No es posible una división por cero");
			else resultado = op1 / op2;
			break;
		} operandosPila.push(resultado);
	}
	
	/**
	 * Este metodo evalua la expresión, primero elimina los espacios en blanco, a continuación introduce el contenido del array en el
	 * string mediante un for, a continuación mediante un if evalua si contiene solo digitos y si es asi lo añade a la cabeza de la pila,
	 * si no mediante un for con un if evalua si es un operador y realiza la operación y si no lo añade a la cabeza de la pila. Y por ultimo 
	 * devuelve el resultado que esta en la cabeza y lo elimina. 
	 * @param expresion expresion a evaluar.
	 * @return elemento resultado de la expresion.
	 */
	public int evaluarExpresion(String expresion) {
		String [] arraySinBlancos = eliminarBlancos(expresion);
		String stringSinBlancos = "";
		String token = "";
		
		for(int i = 0; i < arraySinBlancos.length; i++) {
			//Con este for vamos introduciendo el contenido del array en el string
			stringSinBlancos += arraySinBlancos[i];
		}
		if(soloDigitos(stringSinBlancos)) {
			pila.push(new Integer(stringSinBlancos));
		}else {
			for(int i = 0; i < arraySinBlancos.length; i++) {
				token = arraySinBlancos[i];
				if(esOperador(token)) {
					procesarUnOperador(token.charAt(0), pila);
				}else {
					pila.push(new Integer(token));
				}
			}
		}return pila.pop();
		
	}
	
	/**
	 * Este metodo examina la expresión para averiguar si tiene digitos, devuelve true si tiene unicamente digitos y false si no.
	 * @param expresion expresion a examinar.
	 * @return true si la expresion tiene un operador y false si no lo tiene.
	 */
	private boolean soloDigitos(String expresion) {
		for(int i = 0; i < expresion.length(); i++) {
			if(!Character.isDigit(expresion.charAt(i)))
				return false;
		}
		return true;
	}
	
	/**
	 * Este metodo examina la expresion para averiguar si tiene algun operador, devolverá true si tiene algun operador y false si no.
	 * @param token
	 * @return
	 */
	private boolean esOperador(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	}

}