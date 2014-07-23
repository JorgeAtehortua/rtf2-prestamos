package com.edu.udea.util.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {

	/**
	 * Valida que el correo electrónico establecido como parámetro sea un correo electrónico con formato válido
	 * @param correo texto con el correo electrónico a validar
	 * @return true si el texto tiene un formato de correo electrónico válido, de lo contrario retorna false
	 */
    public static boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        
        if("".equals(correo))
        	return false;
        
        mat = pat.matcher(correo);
        if (mat.find()) {            
            return true;
        }else{
            return false;
        }        
    }

}
