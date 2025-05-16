package core.entities;

public class Feast {

    String feastCode;
    String feastName;
    int price;
    String ingredients;

    public Feast(String code, String name, int price, String ingredients) {
        this.feastCode = code;
        this.feastName = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getFeastCode() {
        return feastCode;
    }

    public String getFeastName() {
        return feastName;
    }

    public int getPrice() {
        return price;
    }

    public String getIngredients() {
        return ingredients;
    }
}
