import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o nome: ");
            String name = scanner.nextLine();
            System.out.print("Digite o sexo (m/f): ");
            String sex = scanner.nextLine();
            System.out.print("Digite a idade: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite a altura: ");
            float height = Float.parseFloat(scanner.nextLine());
            System.out.print("Digite o peso: ");
            float weight = Float.parseFloat(scanner.nextLine());
            System.out.print("Digite o nível de atividade física ('s' para sedentário, 'm' para moderado, 'a' para ativo ou 'ma' para muito ativo): ");
            String act = scanner.nextLine();
    
            Person p = new Person(name, sex, age, height, weight, act);
            System.out.println("\n" + p);
        } catch (Exception e) {
            System.out.println("\nErro: " + e + "\n");
        }

        scanner.close();
    }
}
