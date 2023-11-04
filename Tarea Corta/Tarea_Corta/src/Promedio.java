public class Promedio {

    public static void main(String [] args){

        String input = "6.5819||6.962||6.5106||6.7915||6.4054||6.6736||6.4242||6.6798||6.4353||6.5182||7.4556||6.4387||7.0849||6.4777||6.7457||";
        String[] numeros = input.split("\\|\\|");

        float result = 0;

        for (int i = 0; i < numeros.length; i++) {
            String numero = numeros[i];
            //System.out.println("(" + numero + "," + "1000000" + ")");

            result += Float.parseFloat(numero);

        }

        System.out.println(result / 15);

    }


}
