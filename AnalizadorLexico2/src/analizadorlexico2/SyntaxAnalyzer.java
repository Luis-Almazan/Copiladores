/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico2;

import java.util.List;

/**
 *
 * @author pc
 */
public class SyntaxAnalyzer {
    public static boolean validate(List<Token> tokens) {
        // Verificar si la lista de tokens comienza con "inicio" y termina con "fin"
        if (tokens.size() >= 2 && tokens.get(0).getValue().equals("main") && tokens.get(tokens.size() - 1).getValue().equals(";")) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean validate2(List<Token> tokens) {
        // Variable para rastrear el índice actual mientras recorremos los tokens
        int currentIndex = 0;
        int tokenCount = tokens.size();

        // Comenzamos con la validación del ciclo for
        while (currentIndex < tokenCount) {
            Token currentToken = tokens.get(currentIndex);

            // Verificamos si el ciclo for comienza con la palabra clave "for"
            if (currentToken.getValue().equals("for")) {
                // Si encuentra un ciclo for, verifica la estructura interna
                currentIndex++; // Avanzamos al siguiente token
                if (currentIndex < tokenCount && tokens.get(currentIndex).getValue().equals("(")) {
                    // Avanzamos al siguiente token
                    currentIndex++;
                    // Aquí validarías la estructura dentro del ciclo for, por ejemplo, variables, condiciones, etc.
                    // Implementa tu lógica de validación aquí
                    // Asumiendo que la estructura dentro del ciclo for es válida, avanzamos hasta el final del ciclo for
                    while (currentIndex < tokenCount && !tokens.get(currentIndex).getValue().equals(")")) {
                        currentIndex++;
                    }
                    if (currentIndex >= tokenCount) {
                        // No se encontró el paréntesis de cierre
                        return false;
                    }
                    // Si se encontró el paréntesis de cierre, avanzamos al siguiente token
                    currentIndex++;
                } else {
                    // No se encontró el paréntesis de apertura
                    return false;
                }
            }

            // Verificamos si hay otros tipos de estructuras como while, if, etc.
            // Implementa la lógica similar para validar otras estructuras

            // Avanzamos al siguiente token
            currentIndex++;
        }

        // Si hemos llegado hasta aquí sin encontrar ninguna discrepancia, el código es válido
        return true;
    }

    public static boolean validate3(List<Token> tokens) {
    int currentIndex = 0;
    int tokenCount = tokens.size();

    while (currentIndex < tokenCount) {
        Token currentToken = tokens.get(currentIndex);

        if (currentToken.getValue().equals("for")) {
            // Validar la estructura del ciclo for
            currentIndex = validateFor(tokens, currentIndex);
            if (currentIndex == -1) {
                return false; // Error en la estructura del ciclo for
            }
        } else if (currentToken.getValue().equals("while")) {
            // Validar la estructura del ciclo while
            currentIndex = validateWhile(tokens, currentIndex);
            if (currentIndex == -1) {
                return false; // Error en la estructura del ciclo while
            }
        } else if (currentToken.getValue().equals("if")) {
            // Validar la estructura del condicional if
            currentIndex = validateIf(tokens, currentIndex);
            if (currentIndex == -1) {
                return false; // Error en la estructura del condicional if
            }
        } else {
            // Si no es ninguno de los casos anteriores, avanzar al siguiente token
            currentIndex++;
        }
    }

    // Si hemos llegado hasta aquí sin encontrar ninguna discrepancia, el código es válido
    return true;
}

private static int validateFor(List<Token> tokens, int currentIndex) {
     // Verificar si hay suficientes tokens para representar la estructura del ciclo for
    if (currentIndex + 4 >= tokens.size()) {
        return -1; // Error: No hay suficientes tokens para la estructura del ciclo for
    }

    // El ciclo for debe comenzar con la palabra clave "for"
    if (!tokens.get(currentIndex).getValue().equals("for")) {
        return -1; // Error: La palabra clave "for" no está presente
    }
    currentIndex++; // Avanzar al siguiente token

    // Después de "for" debería haber un paréntesis de apertura "("
    if (!tokens.get(currentIndex).getValue().equals("(")) {
        return -1; // Error: Falta el paréntesis de apertura "("
    }
    currentIndex++; // Avanzar al siguiente token

    // Después del paréntesis de apertura "(" debe venir una declaración de inicialización (por ejemplo, "int i = 0")
    // En este ejemplo, supondremos que la declaración de inicialización siempre consiste en tres tokens
    currentIndex = validateInitialization(tokens, currentIndex);
    if (currentIndex == -1) {
        return -1; // Error en la declaración de inicialización
    }

    // Después de la declaración de inicialización debería haber un punto y coma ";"
    if (!tokens.get(currentIndex).getValue().equals(";")) {
        return -1; // Error: Falta el punto y coma ";"
    }
    currentIndex++; // Avanzar al siguiente token

    // Después del punto y coma ";" debe venir la condición de terminación del ciclo (por ejemplo, "i < 10")
    // En este ejemplo, supondremos que la condición siempre consiste en tres tokens
    currentIndex = validateCondition(tokens, currentIndex);
    if (currentIndex == -1) {
        return -1; // Error en la condición de terminación del ciclo
    }

    // Después de la condición de terminación del ciclo debería haber un punto y coma ";"
    if (!tokens.get(currentIndex).getValue().equals(";")) {
        return -1; // Error: Falta el punto y coma ";"
    }
    currentIndex++; // Avanzar al siguiente token

    // Después del punto y coma ";" debe venir la actualización de la variable de control (por ejemplo, "i++")
    // En este ejemplo, supondremos que la actualización siempre consiste en dos tokens
    currentIndex = validateUpdate(tokens, currentIndex);
    if (currentIndex == -1) {
        return -1; // Error en la actualización de la variable de control
    }

    // Después de la actualización de la variable de control debería haber un paréntesis de cierre ")"
    if (!tokens.get(currentIndex).getValue().equals(")")) {
        return -1; // Error: Falta el paréntesis de cierre ")"
    }
    currentIndex++; // Avanzar al siguiente token

    // Devolver el índice actualizado después de la validación exitosa del ciclo for
    return currentIndex;
}

private static int validateWhile(List<Token> tokens, int currentIndex) {
    // Validar la estructura del ciclo while
    // Implementa tu lógica de validación aquí
    // Asegúrate de devolver el índice actualizado después de la validación
        return 0;
    
}

private static int validateIf(List<Token> tokens, int currentIndex) {
    // Validar la estructura del condicional if
    // Implementa tu lógica de validación aquí
    // Asegúrate de devolver el índice actualizado después de la validación
        return 0;
}






//////////////////////////////////////////////////////////////
private static int validateInitialization(List<Token> tokens, int currentIndex) {
    // Verificar si hay suficientes tokens para la declaración de inicialización
    if (currentIndex + 2 >= tokens.size()) {
        return -1; // Error: No hay suficientes tokens para la declaración de inicialización
    }

    // Suponiendo que la declaración de inicialización consta de tres tokens: tipo, nombre de la variable, y operador de asignación "="
    String tipo = tokens.get(currentIndex).getValue(); // Obtener el tipo de variable
    currentIndex++; // Avanzar al siguiente token
    String nombre = tokens.get(currentIndex).getValue(); // Obtener el nombre de la variable
    currentIndex++; // Avanzar al siguiente token
    String asignacion = tokens.get(currentIndex).getValue(); // Obtener el operador de asignación
    currentIndex++; // Avanzar al siguiente token

    // Verificar que los tokens de la declaración de inicialización sean válidos
    if (!isValidType(tipo) || !isValidIdentifier(nombre) || !asignacion.equals("=")) {
        return -1; // Error: La declaración de inicialización no es válida
    }

    // Devolver el índice actualizado después de la validación exitosa de la declaración de inicialización
    return currentIndex;
}

// Método auxiliar para verificar si un tipo es válido (solo como ejemplo)
private static boolean isValidType(String tipo) {
    // Aquí podrías implementar la lógica para verificar si el tipo es válido
    // En este ejemplo, supondremos que cualquier cadena no vacía es un tipo válido
    return !tipo.isEmpty();
}

// Método auxiliar para verificar si un identificador es válido (solo como ejemplo)
private static boolean isValidIdentifier(String nombre) {
    // Aquí podrías implementar la lógica para verificar si el identificador es válido
    // En este ejemplo, supondremos que cualquier cadena no vacía es un identificador válido
    return !nombre.isEmpty();
}

/////////////////////////////////////////////////////////////
private static int validateUpdate(List<Token> tokens, int currentIndex) {
    // Verificar si hay suficientes tokens para la actualización de la variable de control
    if (currentIndex + 2 >= tokens.size()) {
        return -1; // Error: No hay suficientes tokens para la actualización de la variable de control
    }

    // Suponiendo que la actualización de la variable de control consta de dos tokens: nombre de la variable y operador de incremento/decremento (++ o --)
    String variable = tokens.get(currentIndex).getValue(); // Obtener el nombre de la variable
    currentIndex++; // Avanzar al siguiente token
    String operador = tokens.get(currentIndex).getValue(); // Obtener el operador de incremento/decremento
    currentIndex++; // Avanzar al siguiente token

    // Verificar que los tokens de la actualización de la variable de control sean válidos
    if (!isValidIdentifier(variable) || (!operador.equals("++") && !operador.equals("--"))) {
        return -1; // Error: La actualización de la variable de control no es válida
    }

    // Devolver el índice actualizado después de la validación exitosa de la actualización de la variable de control
    return currentIndex;
}
//////////////////////////////////////////////////////////////////7
private static int validateCondition(List<Token> tokens, int currentIndex) {
    // Verificar si hay suficientes tokens para la condición del ciclo
    if (currentIndex + 4 >= tokens.size()) {
        return -1; // Error: No hay suficientes tokens para la condición del ciclo
    }

    // Suponiendo que la condición del ciclo consta de tres tokens: variable, operador de comparación (<, >, <=, >=, ==, !=), y valor
    String variable = tokens.get(currentIndex).getValue(); // Obtener la variable
    currentIndex++; // Avanzar al siguiente token
    String operador = tokens.get(currentIndex).getValue(); // Obtener el operador de comparación
    currentIndex++; // Avanzar al siguiente token
    String valor = tokens.get(currentIndex).getValue(); // Obtener el valor
    currentIndex++; // Avanzar al siguiente token

    // Verificar que los tokens de la condición del ciclo sean válidos
    if (!isValidIdentifier(variable) || !isValidOperator(operador) || !isValidValue(valor)) {
        return -1; // Error: La condición del ciclo no es válida
    }

    // Devolver el índice actualizado después de la validación exitosa de la condición del ciclo
    return currentIndex;
}

// Método auxiliar para verificar si un operador de comparación es válido (solo como ejemplo)
private static boolean isValidOperator(String operador) {
    // Aquí podrías implementar la lógica para verificar si el operador de comparación es válido
    // En este ejemplo, supondremos que solo se permiten los operadores <, >, <=, >=, ==, !=
    return operador.equals("<") || operador.equals(">") || operador.equals("<=") || operador.equals(">=") || operador.equals("==") || operador.equals("!=");
}

// Método auxiliar para verificar si un valor es válido (solo como ejemplo)
private static boolean isValidValue(String valor) {
    // Aquí podrías implementar la lógica para verificar si el valor es válido
    // En este ejemplo, supondremos que cualquier cadena no vacía es un valor válido
    return !valor.isEmpty();
}


}
