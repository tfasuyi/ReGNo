package main.java.test;



import main.java.EnvCong.BaseClass;
import main.java.Utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static main.java.Utilities.Parq.*;
import static main.java.Utilities.PropertiesManager.getProperty;


public class CarRegistration extends BaseClass {



    @Test
    public  void checkCarRegistration() throws Exception {
        List<String> s = ExtractTextData.readFile();


        if ("DN09HRM".equals(s.get(0).trim())) {
            focus(name("vrm"));
            touch();
            compose(s.get(0));
            focus(tag(Html.Tag.BUTTON, "Free Car Check"));
            touch();
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.REGISTRATION_NUMBER.getValue(), (s.get(0).trim()));
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.MAKE.getValue(), "BMW");
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.MODEL.getValue(), "320D Se");
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.COLOUR.getValue(), "Black");
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.YEAR.getValue(), "2009");
            ExtractTextData.compareOutputData(s.get(0).trim(), "BMW", "320D Se", "Black", "2009");
        }
        if ("BW57 BOW".equals(s.get(1).trim())) {
            go(getProperty("car.url"));
            focus(name("vrm"));
            touch();
            compose(s.get(1));
            focus(tag(Html.Tag.BUTTON, "Free Car Check"));
            touch();
            try {
                VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.REGISTRATION_NUMBER.getValue(), (s.get(1).trim()));
                compose(s.get(1));
                focus(tag(Html.Tag.BUTTON, "Free Car Check"));
                touch();
                VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.REGISTRATION_NUMBER.getValue(), (s.get(1).trim()));
                VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.MAKE.getValue(), "BMW");
                VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.MODEL.getValue(), "320D Se");
                VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.COLOUR.getValue(), "Black");
                VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.YEAR.getValue(), "2009");
                ExtractTextData.compareOutputData(s.get(1).trim(), "BMW", "320D Se", "Black", "2009");
            }catch (Exception e){
                e.getMessage();
            }


        }
        if (s.get(2).trim().equals("KT17DLX")) {
            Parq.go(getProperty("car.url"));
            focus(name("vrm"));
            touch();
            compose(s.get(2));
            focus(tag(Html.Tag.BUTTON, "Free Car Check"));
            touch();
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.REGISTRATION_NUMBER.getValue(), (s.get(2).trim()));
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.MAKE.getValue(), "Skoda");
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.MODEL.getValue(), "Superb Sportline Tdi S-A");
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.COLOUR.getValue(), "White");
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.YEAR.getValue(), "2017");
            ExtractTextData.compareOutputData(s.get(2).trim(), "Skoda", "Superb Sportline Tdi S-A", "White", "2017");
        }
        if ("SG18 HTN".equals(s.get(3).trim())) {
            Parq.go(getProperty("car.url"));
            focus(name("vrm"));
            touch();
            compose(s.get(3));
            focus(tag(Html.Tag.BUTTON, "Free Car Check"));
            touch();
            String str = s.get(3).trim();
            str = str.replaceAll("\\s+", "");
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.REGISTRATION_NUMBER.getValue(), (str));
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.MAKE.getValue(), "Volkswagen");
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.MODEL.getValue(), "Golf Se Navigation Tsi Evo");
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.COLOUR.getValue(), "White");
            VerifyRegNo.verifyCarRegDetails(CarDataEnum.Field.YEAR.getValue(), "2018");
            ExtractTextData.compareOutputData(str.trim(), "Volkswagen", "Golf Se Navigation Tsi Evo", "White", "2018");
        }



    }
}
