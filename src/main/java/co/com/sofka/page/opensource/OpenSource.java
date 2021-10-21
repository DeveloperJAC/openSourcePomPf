package co.com.sofka.page.opensource;

import co.com.sofka.model.opensource.OpenSourceModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class OpenSource extends CommonActionsOnPages {

    private static final Logger LOGGER = Logger.getLogger(OpenSource.class);


    private final OpenSourceModel openSourceModel;
    private static final String MODEL_NULL_MESSAGE = "El login es nulo.";




    /////////////////////////////////////////////////////////////

    @FindBy(id = "txtUsername")
    @CacheLookup
    private WebElement username;

    @FindBy(id = "txtPassword")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "btnLogin")
    @CacheLookup
    private WebElement submit;

    @FindBy(id = "menu_pim_viewPimModule")
    @CacheLookup
    private WebElement menuPim;

    @FindBy(id = "menu_pim_viewEmployeeList")
    @CacheLookup
    private WebElement employeelist;

    @FindBy(xpath = "//*[@id=\"btnAdd\"]")
    @CacheLookup
    private WebElement addBtn;

    @FindBy(id = "firstName")
    @CacheLookup
    private WebElement name;

    @FindBy(id = "middleName")
    @CacheLookup
    private WebElement middleName;

    @FindBy(id = "lastName")
    @CacheLookup
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"photofile\"]")
    @CacheLookup
    private WebElement photoFile;

    @FindBy(id = "chkLogin")
    @CacheLookup
    private WebElement chkLogin;

    @FindBy(id = "user_name")
    @CacheLookup
    private WebElement userName;

    @FindBy(id = "user_password")
    @CacheLookup
    private WebElement passWord;

    @FindBy(id = "re_password")
    @CacheLookup
    private WebElement rePassword;

    @FindBy(id = "status")
    @CacheLookup
    private WebElement status;

    @FindBy(id = "btnSave")
    @CacheLookup
    private WebElement btnSave;


    ///////////////////////////////////////////////
    @FindBy(id = "firstName")
    @CacheLookup
    private WebElement assertionPersonalName;

    @FindBy(id = "middleName")
    @CacheLookup
    private WebElement assertionPersonalMiddleName;

    @FindBy(id = "lastName")
    @CacheLookup
    private WebElement assertionPersonalLastName;

    //Sikulix elements.


    private static final String ATTACHMENT_FILE_PATCH = USER_DIR.value() + "\\src\\test\\resources\\images\\opensource\\mia.png";

    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\page\\opensource\\";
    private static final String SELECT_PICTURE_PATCH = PAGE_BASE_PATCH + "selectPicture.PNG";
    private static final String SELECT_OPEN_PATCH = PAGE_BASE_PATCH + "openWindows.PNG";
    private static final String FILE_NAME_TEXT_BOX_PATCH = PAGE_BASE_PATCH + "fileNameWindows.PNG";

    private static final String PAGE_BASE = "\\src\\main\\resources\\page\\opensource\\";
    private static final String SELECT_PICTURE_ENABLED = PAGE_BASE + "selectPictureEnabled.PNG";



    public OpenSource(WebDriver driver, OpenSourceModel openSourceModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.openSourceModel = openSourceModel;
    }

    public OpenSource(WebDriver driver, OpenSourceModel openSourceModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver, this);


        if(openSourceModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);

        this.openSourceModel = openSourceModel;

    }


    //Page functions.
    public void fillEmployee() throws IOException {
        //clear(username);
        typeInto(username, openSourceModel.getUsername());

        //clear(password);
        typeInto(password, openSourceModel.getPassword());

        //scrollTo(submit);
        clickOn(submit);

        clickOn(menuPim);

        clickOn(employeelist);

        clickOn(addBtn);

        //scrollTo(name);
        //typeInto(name);
        typeInto(name, openSourceModel.getName());

        //scrollTo(middleName);
        //typeInto(middleName);
        typeInto(middleName, openSourceModel.getMiddleName());

        //scrollTo(lastName);
        //typeInto(lastName);
        typeInto(lastName, openSourceModel.getLastName());

        clickOn(SELECT_PICTURE_PATCH);
        insertInto(FILE_NAME_TEXT_BOX_PATCH, ATTACHMENT_FILE_PATCH);
        clickOn(SELECT_OPEN_PATCH);

        clickOn(chkLogin);

        //scrollTo(userName);
        //withExplicitWaitClear(userName);
        typeInto(userName, openSourceModel.getUserName());

        //scrollTo(passWord);
        //withExplicitWaitClear(passWord);
        typeInto(passWord, openSourceModel.getPassWord());

        //scrollTo(rePassword);
        //withExplicitWaitClear(rePassword);
        typeInto(rePassword, openSourceModel.getRePassword());

        clickOn(status);

        clickOn(SELECT_PICTURE_ENABLED);

        clickOn(btnSave);


    }

    public List<String> isRegistrationDone() {
        List<String> submitEmployeeResult = new ArrayList<>();
        submitEmployeeResult.add(getText(assertionPersonalName).trim());
        submitEmployeeResult.add(getText(assertionPersonalMiddleName).trim());
        submitEmployeeResult.add(getText(assertionPersonalLastName).trim());
        return submitEmployeeResult;
    }

    public String isNoneInseted() {
        return getText(assertionPersonalName).trim();
    }

}
