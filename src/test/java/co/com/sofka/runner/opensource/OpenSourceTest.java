package co.com.sofka.runner.opensource;

import co.com.sofka.model.opensource.OpenSourceModel;
import co.com.sofka.page.opensource.OpenSource;
import co.com.sofka.stepdefinition.setup.webui.WebUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class OpenSourceTest extends WebUI {

    private OpenSourceModel openSourceModel;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";

    @BeforeEach
    public void setUp(){
        try{
            generalSetUp();
            openSourceModel = new OpenSourceModel();
            openSourceModel.setUsername("Admin");
            openSourceModel.setPassword("admin123");
            openSourceModel.setName("Juan");
            openSourceModel.setMiddleName("Esteban");
            openSourceModel.setLastName("Gomez");
            openSourceModel.setPicture("src/test/resources/images/opensource/mia.jpg");
            openSourceModel.setUserName("esteban2021");
            openSourceModel.setPassWord("12345678");
            openSourceModel.setRePassword("12345678");

        } catch (Exception exception){
            quitDriver();
        }
    }

    @Test
    public void practiceFormTestMandatoryFields(){
        try{
            OpenSource openSource = new OpenSource(driver, openSourceModel);
            openSource.fillEmployee();

            Assertions.assertEquals(
                    openSource.isRegistrationDone(),
                    forSubmittedEmployee(),
                    ASSERTION_EXCEPTION_MESSAGE);
        } catch (Exception exception){
            quitDriver();
        }
    }

    @AfterEach
    public void tearDown(){
        quitDriver();
    }

    private List<String> forSubmittedEmployee(){
        List<String> submitedEmployeeResult = new ArrayList<String>();
        submitedEmployeeResult.add(openSourceModel.getName() + " " + openSourceModel.getMiddleName()+ " " + openSourceModel.getLastName());
        return submitedEmployeeResult;
    }

}
