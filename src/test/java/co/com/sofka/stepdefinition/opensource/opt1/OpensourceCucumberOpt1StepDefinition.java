package co.com.sofka.stepdefinition.opensource.opt1;

import co.com.sofka.model.opensource.OpenSourceModel;
import co.com.sofka.page.opensource.OpenSource;
import co.com.sofka.stepdefinition.setup.webui.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;


public class OpensourceCucumberOpt1StepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(OpensourceCucumberOpt1StepDefinition.class);
    public OpenSourceModel openSourceModel;
    public OpenSource openSource;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";


    @Given("que el empleado administrativo pueda encontrar el area para registrar nuevos empleados")
    public void queElEmpleadoAdministrativoPuedaEncontrarElAreaParaRegistrarNuevosEmpleados() {
        try{
            generalSetUp();
            openSourceModel = new OpenSourceModel();
            openSourceModel.setUsername("Admin");
            openSourceModel.setPassword("admin123");
            openSourceModel.setName("Milena");
            openSourceModel.setMiddleName("Salgado");
            openSourceModel.setLastName("Gomez");
            openSourceModel.setPicture("src/test/resources/images/opensource/mia.jpg");
            openSourceModel.setUserName("milena2021");
            openSourceModel.setPassWord("12345678");
            openSourceModel.setRePassword("12345678");
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el administrativo llena todos los campos solicitados por el sitema")
    public void elAdministrativoLlenaTodosLosCamposSolicitadosPorElSitema() {
        try{
            OpenSource openSource = new OpenSource(driver, openSourceModel);
            openSource.fillEmployee();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }

    }

    @Then("el sistema debera registrar un nuevo empleado y mostrar el detalle del empleado registrado")
    public void elSistemaDeberaRegistrarUnNuevoEmpleadoYMostrarElDetalleDelEmpleadoRegistrado() {

        try{
            Assertions.assertEquals(
                    expected(),
                    openSource.isRegistrationDone(),
                    ASSERTION_EXCEPTION_MESSAGE);
            quitDriver();
        } catch (Exception exception){
            quitDriver();

        }

    }

    private List<String> expected(){
        List<String> submitedEmployeeResult = new ArrayList<String>();
        submitedEmployeeResult.add(openSourceModel.getName() + " " + openSourceModel.getMiddleName()+ " " + openSourceModel.getLastName());
        return submitedEmployeeResult;
    }


}
