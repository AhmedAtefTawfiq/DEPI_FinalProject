package helpers;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class DataReader {


    Gson gson;
    BufferedReader bufferedReader;
    public static DataReader dataReader ;
    private DataReader() {
        //The primary purpose of the Gson class is to provide methods for converting between Java objects and JSON representations
        gson = new Gson();
    }

    public static DataReader getInstance(){
        if (dataReader == null)
        {
            dataReader = new DataReader();
        }
        return dataReader;
    }

    private void readFile(String filePath){
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public JsonObject readDataJsonObject(String filePath){
        readFile(filePath);
        return gson.fromJson(bufferedReader, JsonObject.class);
    }


//    // Read image from src
//    public BufferedImage readImageFile(String imagePath) {
//        try {
//            return ImageIO.read(new File(imagePath));
//        } catch (IOException e) {
//            throw new RuntimeException("Error reading image file: " + imagePath, e);
//        }
//    }

//    public String imageToBase64String(String imagePath) {
//        try {
//            // Read image file into byte array
//            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
//
//            // Encode byte array to Base64 string
//            return Base64.getEncoder().encodeToString(imageBytes);
//        } catch (IOException e) {
//            throw new RuntimeException("Error reading image file: " + imagePath, e);
//        }
//    }
//
//    // Read PDF text from src
//    public String readPdfFile(String pdfPath) {
//        try (PDDocument document = PDDocument.load(new File(pdfPath))) {
//            PDFTextStripper pdfStripper = new PDFTextStripper();
//            return pdfStripper.getText(document);
//        } catch (IOException e) {
//            throw new RuntimeException("Error reading PDF file: " + pdfPath, e);
//        }
//    }

//    public JsonArray readDataJsonArray(String filePath){
//        readFile(filePath);
//        return gson.fromJson(bufferedReader, JsonArray.class);
//    }

    public String getVariableFromJson(JsonObject jsonObjectName , String jsonName ,String variableName){
        return jsonObjectName.get(jsonName).getAsJsonObject().get(variableName).getAsString();

    }
}
