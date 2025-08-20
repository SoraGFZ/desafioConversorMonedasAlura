import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorMonedas {

    private static final String API_KEY = "06cb0a4af79028a7e8345d79";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static double obtenerTasaCambio(String from, String to) throws Exception {
        String urlStr = API_URL + from;

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);

        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
        return rates.get(to).getAsDouble();
    }

    public static double convertir(String from, String to, double cantidad) throws Exception {
        double tasa = obtenerTasaCambio(from, to);
        return cantidad * tasa;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Conversor de Monedas ===");
            System.out.println("1. USD -> ARS (Peso Argentino)");
            System.out.println("2. USD -> COP (Peso Colombiano)");
            System.out.println("3. USD -> JPY (Yen Japonés)");
            System.out.println("4. ARS -> USD");
            System.out.println("5. COP -> USD");
            System.out.println("6. JPY -> USD");
            System.out.println("7. Salir");
            System.out.print("Elige una opción (número o escribe 'salir'): ");

            String entrada = scanner.next();

            // Permitir escribir "salir" o "exit"
            if (entrada.equalsIgnoreCase("salir") || entrada.equalsIgnoreCase("exit") || entrada.equals("7")) {
                System.out.println("👋 Gracias por usar el conversor. ¡Hasta la próxima!");
                break;
            }

            int opcion;
            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida, intenta de nuevo.");
                continue;
            }

            System.out.print("Ingrese la cantidad: ");
            double cantidad = scanner.nextDouble();

            String from = "";
            String to = "";

            switch (opcion) {
                case 1 -> { from = "USD"; to = "ARS"; }
                case 2 -> { from = "USD"; to = "COP"; }
                case 3 -> { from = "USD"; to = "JPY"; }
                case 4 -> { from = "ARS"; to = "USD"; }
                case 5 -> { from = "COP"; to = "USD"; }
                case 6 -> { from = "JPY"; to = "USD"; }
                default -> {
                    System.out.println("⚠️ Opción inválida.");
                    continue;
                }
            }

            try {
                double resultado = convertir(from, to, cantidad);
                System.out.printf("%.2f %s = %.2f %s%n", cantidad, from, resultado, to);
            } catch (Exception e) {
                System.out.println("❌ Error al obtener la tasa de cambio: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
