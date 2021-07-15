public class Person {
    String name, sex, act;
    int age;
    float height, weight;

    Person(String name, String sex, int age, float height, float weight, String act) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.act = act;
    }

    public float getIMC() {
        if (this.age >= 20 && this.age < 60) {
            return this.weight / (float) (Math.pow(this.height, 2));
        } else {
            return 0;
        }
    }

    public int getAverageIMC() {
        if (this.sex == "m") {
            return 22;
        } else if (this.sex == "f") {
            return 20;
        } else {
            return 0;
        }
    }

    public String getTitleIMC() {
        if (this.getIMC() == 0) {
            return "Não calculado devido à faixa etária";
        } else if (this.getIMC() > 0 && this.getIMC() < 16) {
            return "Magreza Grau III";
        } else if (this.getIMC() >= 16.0 && this.getIMC() < 17) {
            return "Magreza Grau II";
        } else if (this.getIMC() >= 17.0 && this.getIMC() < 18.5) {
            return "Magreza Grau I";
        } else if (this.getIMC() >= 18.5 && this.getIMC() < 25) {
            return "Eutrofia";
        } else if (this.getIMC() >= 25.0 && this.getIMC() < 30) {
            return "Sobrepeso";
        } else if (this.getIMC() >= 30.0 && this.getIMC() < 35) {
            return "Obesidade Grau I";
        } else if (this.getIMC() >= 35.0 && this.getIMC() < 40) {
            return "Obesidade Grau II";
        } else if (this.getIMC() >= 40.0) {
            return "Obesidade Grau III";
        } else {
            return "N/A";
        }
    }

    public float getTheoricalWeight() {
        return this.getAverageIMC() * (float) (Math.pow(this.height, 2));
    }

    public float getTMB() {
        if (this.sex == "m") {
            if (this.age < 3) {
                return 59.512f * this.weight - 30.4f;
            } else if (this.age >= 3 && this.age < 10) {
                return 22.706f * this.weight + 504.3f;
            } else if (this.age >= 10 && this.age < 18) {
                return 17.686f * this.weight + 658.2f;
            } else if (this.age >= 18 && this.age < 30) {
                return 15.057f * this.weight + 692.2f;
            } else if (this.age >= 30 && this.age < 60) {
                return 11.472f * this.weight + 873.1f;
            } else if (this.age >= 60) {
                return 11.711f * this.weight + 587.7f;
            } else {
                return 0;
            }
        } else if (this.sex == "f") {
            if (this.age < 3) {
                return 58.317f * this.weight - 31.1f;
            } else if (this.age >= 3 && this.age < 10) {
                return 20.317f * this.weight + 485.9f;
            } else if (this.age >= 10 && this.age < 18) {
                return 13.384f * this.weight + 692.6f;
            } else if (this.age >= 18 && this.age < 30) {
                return 14.818f * this.weight + 486.6f;
            } else if (this.age >= 30 && this.age < 60) {
                return 8.126f * this.weight + 845.6f;
            } else if (this.age >= 60) {
                return 9.082f * this.weight + 658.5f;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public float getVET() {
        if (this.act == "s" || this.act == "m") {
            return this.getTMB() * 1.53f;
        } else if (this.act == "a") {
            return this.getTMB() * 1.76f;
        } else if (this.act == "ma") {
            return this.getTMB() * 2.25f;
        } else {
            return 0;
        }
    }

    public float getGTE() {
        if (this.age >= 9 && this.age < 18) {
            if (this.sex == "m") {
                if (this.act == "s") {
                    return 88.5f - 61.9f * this.age + 1 * (26.7f * this.weight + 903 * this.height) + 25;
                } else if (this.act == "m") {
                    return 88.5f - 61.9f * this.age + 1.13f * (26.7f * this.weight + 903 * this.height) + 25;
                } else if (this.act == "a") {
                    return 88.5f - 61.9f * this.age + 1.26f * (26.7f * this.weight + 903 * this.height) + 25;
                } else if (this.act == "ma") {
                    return 88.5f - 61.9f * this.age + 1.42f * (26.7f * this.weight + 903 * this.height) + 25;
                } else {
                    return 0;
                }
            } else if (this.sex == "f") {
                if (this.act == "s") {
                    return 135.3f - 30.8f * this.age + 1 * (10 * this.weight + 934 * this.height) + 20;
                } else if (this.act == "m") {
                    return 135.3f - 30.8f * this.age + 1.16f * (10 * this.weight + 934 * this.height) + 20;
                } else if (this.act == "a") {
                    return 135.3f - 30.8f * this.age + 1.31f * (10 * this.weight + 934 * this.height) + 20;
                } else if (this.act == "ma") {
                    return 135.3f - 30.8f * this.age + 1.56f * (10 * this.weight + 934 * this.height) + 20;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else if (this.age >= 18) {
            if (this.sex == "m") {
                if (this.act == "s") {
                    return 662 - 9.53f * this.age + 1 * (15.91f * this.weight + 539.6f * this.height);
                } else if (this.act == "m") {
                    return 662 - 9.53f * this.age + 1.11f * (15.91f * this.weight + 539.6f * this.height);
                } else if (this.act == "a") {
                    return 662 - 9.53f * this.age + 1.25f * (15.91f * this.weight + 539.6f * this.height);
                } else if (this.act == "ma") {
                    return 662 - 9.53f * this.age + 1.48f * (15.91f * this.weight + 539.6f * this.height);
                } else {
                    return 0;
                }
            } else if (this.sex == "f") {
                if (this.act == "s") {
                    return 354 - 6.91f * this.age + 1 * (9.35f * this.weight + 726 * this.height);
                } else if (this.act == "m") {
                    return 354 - 6.91f * this.age + 1.12f * (9.35f * this.weight + 726 * this.height);
                } else if (this.act == "a") {
                    return 354 - 6.91f * this.age + 1.27f * (9.35f * this.weight + 726 * this.height);
                } else if (this.act == "ma") {
                    return 354 - 6.91f * this.age + 1.45f * (9.35f * this.weight + 726 * this.height);
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public String toString() {
        return this.name + ", " + this.sex + ", " + this.age + " anos, " + this.weight + " kg, " + this.height + " m, " + this.act + "\nIMC (Indice de Massa Corporea): " + this.getIMC() + " (" + this.getTitleIMC() + ")\nPeso Teorico: " + this.getTheoricalWeight() + " kg\nTMB (Taxa Metabólica Basal): " + this.getTMB() + "\nVET (Valor Energetico Total): " + this.getVET() + "\nGTE (Gasto Total Energetico): " + this.getGTE() + "\n";
    }
}
