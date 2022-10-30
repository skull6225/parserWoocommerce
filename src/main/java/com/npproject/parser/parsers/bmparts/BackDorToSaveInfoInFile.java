package com.npproject.parser.parsers.bmparts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.npproject.parser.models.BmModels.BmModel;

public class BackDorToSaveInfoInFile {
    public void saveInfoInFile(List<BmModel> products) throws IOException {
        FileOutputStream fos = new FileOutputStream("products.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(products);
        oos.close();
    }

    public List<BmModel> readInfoFromFile() {
        try {
            FileInputStream fis = new FileInputStream("products.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<BmModel> products = (List<BmModel>) ois.readObject();
            ois.close();
            return products;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}