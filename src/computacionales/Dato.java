package computacionales;

public class Dato {

    public String decimalToHexa(float e) {
        int entrada = 0;
        entrada = Math.round(e);
        String digits = "0123456789ABCDEF";
        if (entrada == 0);
        String hexadecimal = "";
        while (entrada > 0) {
            int mod = entrada % 16;              // Dígito de la derecha
            hexadecimal = digits.charAt(mod) + hexadecimal;  // Concatenación de cadenas
            entrada = entrada / 16;
        }
        return hexadecimal;
    }

    public String decimalToOct(String bis) {
        int decimal = Integer.parseInt(bis);
        int rem;
        String octal = "";
        char octalchars[] = {'0', '1', '2', '3', '4', '5', '6', '7'};
        while (decimal > 0) {
            rem = decimal % 8;
            octal = octalchars[rem] + octal;
            decimal = decimal / 8;
        }
        return octal;
    }

    public String decimalToBinary(float bis) {
        int decimal = 0;
        decimal = Math.round(bis);
        String binario = "";
        while (decimal > 0) {
            binario = decimal % 2 + binario;
            decimal /= 2;
        }
        return binario;
    }

    public int convertOctalToDecimal(int octal) {
        int decimalNumber = 0, i = 0;

        while (octal != 0) {
            decimalNumber += (octal % 10) * Math.pow(8, i);
            ++i;
            octal /= 10;
        }
        return decimalNumber;
    }

    public String octaToBinary(String valor) {
       int v= Integer.parseInt(valor);
       v= convertOctalToDecimal(v);
       float s = (float)v;
       valor=decimalToBinary(s);
       return valor;
    }

    public String oct_hex(String valor) {
        int oct, dec = 0, i = 0, t;
        oct = Integer.parseInt(valor);
        while (oct != 0) {
            dec = dec + (oct % 10) * (int) Math.pow(8, i);
            i++;
            oct = oct / 10;
        }
        valor = Integer.toString(dec);
        String hex = octHex(valor);
        return hex;
    }

    /**
     * Método de apoyo de oct_hex que sirve para convertir octal a hexadecimal
     *
     * @param valor
     * @return
     */
    public String octHex(String valor) {
        int q = Integer.parseInt(valor);
        char a[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int rem;
        String hexdec = "";
        while (q != 0) {
            rem = q % 16;
            hexdec = a[rem] + hexdec;
            q = q / 16;
        }
        return hexdec;
    }

    public String hexaToDecimal(String s) {
        String digitos = "0123456789ABCDEF";
        s = s.toUpperCase();
        int decimal = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digitos.indexOf(c);
            decimal = 16 * decimal + d;
        }
        return Integer.toString(decimal);
    }

    public String binToDec(String base) {
        String cadenaInver = "";
        int b = 0;
        int c = 0;
        for (int i = base.length() - 1; i >= 0; i--) {
            cadenaInver += "" + base.charAt(i);
        }
        double[] arreglo;
        for (int i = 0; i <= cadenaInver.length(); i++) {
            arreglo = new double[99];
            arreglo[i] = (Math.pow(2, i));

            for (int m = 0; m < cadenaInver.length(); m++) {
                String convertir = "" + cadenaInver.charAt(m);
                b = Integer.parseInt(convertir);
                c += b * arreglo[m];
            }
        }
        return Integer.toString(c);
    }

    public String binTohex(String valor) {
        valor = binToDec(valor);
        float v = Float.parseFloat(valor);
        valor = decimalToHexa(v);
        return valor;
    }

    public String bin_oct(String valor) {
        String s = binToDec(valor);
        valor = decimalToOct(s);
        return valor;
    }

    public String hexToBin(String valor) {
        String xD = hexaToDecimal(valor);
        float s = Float.parseFloat(xD);
        xD = decimalToBinary(s);
        return xD;
    }

    public String hex_oct(String valor) {
        valor = hexaToDecimal(valor);
        valor = decimalToOct(valor);
        return valor;
    }

}
