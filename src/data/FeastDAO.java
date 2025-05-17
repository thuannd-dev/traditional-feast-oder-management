package data;

import common.env.Constants;
import core.entities.Feast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FeastDAO {

    private final List<Feast> feastsList = new ArrayList<>();
    private final FileManager fileManager;

    public FeastDAO(String fileName) throws Exception {
        this.fileManager = new FileManager(fileName);
        loadData();
    }

    public void loadData() throws Exception {
        String feastCode, feastName, ingredients;
        int price;
        try {
            feastsList.clear();
            List<String> feastData = fileManager.readDataFromFile();
            feastData.remove(0);
            for (String e : feastData) {
                List<String> feastS = Arrays.asList(e.split(","));
                feastCode = feastS.get(0).trim();
                feastName = feastS.get(1).trim();
                price = Integer.parseInt(feastS.get(2).trim());
                ingredients = feastS.get(3).trim();
                Feast feast = new Feast(feastCode, feastName, price, ingredients);
                feastsList.add(feast);
                Constants.FEAST_CODE_LIST.add(feastCode);
                if (feastsList.isEmpty()) {
                    throw new Exception("Customer list is empty.");
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Feast> getFeasts() {
        return feastsList;
    }

    public Feast getFeastById(String id) throws Exception {
        if (feastsList.isEmpty()) {
            getFeasts();
        }
        Feast feast = feastsList.stream().filter(e -> e.getFeastCode().equals(id)).findFirst().orElse(null);
        return feast;
    }

}
