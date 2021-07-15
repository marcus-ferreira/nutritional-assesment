''' Cálculos nutricionais '''

class Person:
    def __init__(self, name, sex, age, weight, height, act) -> None:
        self.name = name
        self.sex = sex
        self.age = int(age)
        self.weight = float(weight)
        self.height = float(height)
        self.act = act

    def get_imc(self) -> float:
        if 20 <= self.age < 60:
            return round(self.weight / (self.height ** 2), 2)
        else:
            return None

    def get_average_imc(self) -> int:
        if self.sex == "m":
            return 22
        elif self.sex == "f":
            return 20
        else:
            return None

    def getTitleIMC(self) -> str:
        if self.get_imc() == 0:
            return "Não calculado devido à faixa etária"
        elif 0 < self.get_imc() < 16:
            return "Magreza Grau III"
        elif 16.0 <= self.get_imc() < 17:
            return "Magreza Grau II"
        elif 17.0 <= self.get_imc() < 18.5:
            return "Magreza Grau I"
        elif 18.5 <= self.get_imc() < 25:
            return "Eutrofia"
        elif 25.0 <= self.get_imc() < 30:
            return "Sobrepeso"
        elif 30.0 <= self.get_imc() < 35:
            return "Obesidade Grau I"
        elif 35.0 <= self.get_imc() < 40:
            return "Obesidade Grau II"
        elif self.get_imc() >= 40.0:
            return "Obesidade Grau III"

    def get_theorical_weight(self) -> float:
        return round(self.get_average_imc() * (self.height ** 2), 2)

    def get_tmb(self) -> float:
        if self.sex == "m":
            if self.age < 3:
                return round(59.512 * self.weight - 30.4)
            elif 3 <= self.age < 10:
                return round(22.706 * self.weight + 504.3)
            elif 10 <= self.age < 18:
                return round(17.686 * self.weight + 658.2)
            elif 18 <= self.age < 30:
                return round(15.057 * self.weight + 692.2)
            elif 30 <= self.age < 60:
                return round(11.472 * self.weight + 873.1)
            elif self.age >= 60:
                return round(11.711 * self.weight + 587.7)
        elif self.sex == "f":
            if self.age < 3:
                return round(58.317 * self.weight - 31.1)
            elif 3 <= self.age < 10:
                return round(20.317 * self.weight + 485.9)
            elif 10 <= self.age < 18:
                return round(13.384 * self.weight + 692.6)
            elif 18 <= self.age < 30:
                return round(14.818 * self.weight + 486.6)
            elif 30 <= self.age < 60:
                return round(8.126 * self.weight + 845.6)
            elif self.age >= 60:
                return round(9.082 * self.weight + 658.5)

    def get_vet(self) -> float:
        if self.act == "s" or self.act == "m":
            return round(self.get_tmb() * 1.53)
        elif self.act == "a":
            return round(self.get_tmb() * 1.76)
        elif self.act == "ma":
            return round(self.get_tmb() * 2.25)

    def get_gte(self) -> float:
        if 9 <= self.age < 18:
            if self.sex == "m":
                if self.act == "s":
                    return round(88.5 - 61.9 * self.age + 1.00 * (26.7 * self.weight + 903 * self.height) + 25)
                elif self.act == "m":
                    return round(88.5 - 61.9 * self.age + 1.13 * (26.7 * self.weight + 903 * self.height) + 25)
                elif self.act == "a":
                    return round(88.5 - 61.9 * self.age + 1.26 * (26.7 * self.weight + 903 * self.height) + 25)
                elif self.act == "ma":
                    return round(88.5 - 61.9 * self.age + 1.42 * (26.7 * self.weight + 903 * self.height) + 25)
            elif self.sex == "f":
                if self.act == "s":
                    return round(135.3 - 30.8 * self.age + 1.00 * (10 * self.weight + 934 * self.height) + 20)
                elif self.act == "m":
                    return round(135.3 - 30.8 * self.age + 1.16 * (10 * self.weight + 934 * self.height) + 20)
                elif self.act == "a":
                    return round(135.3 - 30.8 * self.age + 1.31 * (10 * self.weight + 934 * self.height) + 20)
                elif self.act == "ma":
                    return round(135.3 - 30.8 * self.age + 1.56 * (10 * self.weight + 934 * self.height) + 20)
        elif self.age >= 18:
            if self.sex == "m":
                if self.act == "s":
                    return round(662 - 9.53 * self.age + 1.00 * (15.91 * self.weight + 539.6 * self.height))
                elif self.act == "m":
                    return round(662 - 9.53 * self.age + 1.11 * (15.91 * self.weight + 539.6 * self.height))
                elif self.act == "a":
                    return round(662 - 9.53 * self.age + 1.25 * (15.91 * self.weight + 539.6 * self.height))
                elif self.act == "ma":
                    return round(662 - 9.53 * self.age + 1.48 * (15.91 * self.weight + 539.6 * self.height))
            elif self.sex == "f":
                if self.act == "s":
                    return round(354 - 6.91 * self.age + 1.00 * (9.35 * self.weight + 726 * self.height))
                elif self.act == "m":
                    return round(354 - 6.91 * self.age + 1.12 * (9.35 * self.weight + 726 * self.height))
                elif self.act == "a":
                    return round(354 - 6.91 * self.age + 1.27 * (9.35 * self.weight + 726 * self.height))
                elif self.act == "ma":
                    return round(354 - 6.91 * self.age + 1.45 * (9.35 * self.weight + 726 * self.height))
        else:
            return None

    def __str__(self) -> str:
        if self.sex == "m":
            self.sexPrint = "Masculino"
        elif self.sex == "f":
            self.sexPrint = "Feminino"
        
        if self.act == "s":
            self.actPrint = "Sedentário"
        elif self.act == "m":
            self.actPrint = "Moderado"
        elif self.act == "a":
            self.actPrint = "Ativo"
        elif self.act == "ma":
            self.actPrint = "Muito Ativo"
        
        return f"Nome: {self.name}\nSexo: {self.sexPrint}\nIdade: {self.age} anos\nPeso: {self.weight} kg\nAltura: {self.height} m\nNAF (Nível de Atividade Física): {self.actPrint}\nIMC (Índice de Massa Corpórea): {self.get_imc()} ({self.getTitleIMC()})\nPeso Teórico: {self.get_theorical_weight()} kg\nTMB (Taxa Metabólica Basal): {self.get_tmb()}\nVET (Valor Energético Total): {self.get_vet()}\nGTE (Gasto Total Energético): {self.get_gte()}"


def main():
    p = Person(
        input("Digite o nome: ").capitalize(),
        input("Digite o sexo ('m' para Masculino ou 'f' para feminino): "),
        input("Digite a idade: "),
        input("Digite o peso: "),
        input("Digite a altura: "),
        input("Digite o nível de atividade física ('s' para Sedentário, 'm' para Moderado, 'a' para Ativo ou 'ma' para Muito Ativo): ")
    )
    print()
    print(p)
    print()
    cont = input("Continuar? (s/n) ")
    if cont == "s":
        main()
    else:
        quit()


if __name__ == "__main__":
    main()
