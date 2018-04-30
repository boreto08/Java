import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String input = reader.readLine();
        if (input.split("\\s+")[0].equals("Pizza")) {
            String[] tokensPizza = input.split("\\s+");

            String pizzaName = tokensPizza[1];
            int pizzaNumOfToppings = Integer.parseInt(tokensPizza[2]);

            Pizza pizza = new Pizza(pizzaName, pizzaNumOfToppings);

            if (!pizza.getLegal()) {
                return;
            }

            String inputDough = reader.readLine();
            String[] tokensDough = inputDough.split("\\s+");

            String flourType = tokensDough[1];
            String bakingTech = tokensDough[2];
            int gramsDough = Integer.parseInt(tokensDough[3]);

            Dough currDough = new Dough(gramsDough, bakingTech, flourType);

            if (currDough.getIsIlegal()) {
                return;
            }
            double calDough = currDough.getTotalCalories();
            pizza.addCalories(calDough);

            while (true) {
                String inputTopping = reader.readLine();
                if (inputTopping.equals("END")) {
                    break;
                }
                String[] toppingTokens = inputTopping.split("\\s+");

                String toppingType = toppingTokens[1];
                int toppingWeight = Integer.parseInt(toppingTokens[2]);

                Topping currentTopping = new Topping(toppingType, toppingWeight);

                if (currentTopping.getIlegal()) {
                    return;
                }
                double cal = currentTopping.getTotalCalories();
                pizza.addCalories(cal);
            }

            System.out.printf("%s - %.2f", pizza.getName(), pizza.getTotalCalories());
        }else if((input.split("\\s+")[0].equals("Dough"))){

            String[] tokens = input.split("\\s+");
            String flourType = tokens[1];
            String bakingTech = tokens[2];
            int gramsDough = Integer.parseInt(tokens[3]);

            Dough currDough = new Dough(gramsDough, bakingTech, flourType);
            if (currDough.getIsIlegal()) {
                return;
            }
            System.out.printf("%.2f\n", currDough.getTotalCalories());

            while (true) {
                String inputTopping = reader.readLine();
                if (inputTopping.equals("END")) {
                    return;
                }
                String[] toppingTokens = inputTopping.split("\\s+");

                if (!toppingTokens[0].equals("Topping") || toppingTokens.length != 3) {
                    continue;
                }
                String toppingType = toppingTokens[1];
                int toppingWeight = Integer.parseInt(toppingTokens[2]);

                Topping currentTopping = new Topping(toppingType, toppingWeight);
                if (currentTopping.getIlegal()) {
                    continue;
                }
                System.out.printf("%.2f\n", currentTopping.getTotalCalories());
            }
        }


    }

}


