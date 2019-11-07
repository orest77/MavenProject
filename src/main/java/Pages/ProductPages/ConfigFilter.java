package Pages.ProductPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class ConfigFilter {
    protected WebDriver driver;

    private WebElement priceFrom;
    private WebElement priceTo;
    private List<WebElement> brand;
    private List<WebElement> screenDiagonal;
    private List<WebElement> processorSeries;
    private List<WebElement> modelCPU;
    private List<WebElement> amountOfRAM;
    private List<WebElement> typeDrive;
    private List<WebElement> graphicsCardSeries;
    private List<WebElement> storageVolume;
    private List<WebElement> numberOfCores;
    private List<WebElement> maxSizeRAM;

    public ConfigFilter(WebDriver driver) {
        this.driver = driver;
        initWebElements();
    }

    private void initWebElements() {
        priceFrom = driver.findElement(By.id("priceFilterFrom"));
        priceTo = driver.findElement(By.id("priceFilterTo"));
        brand = driver.findElements(By.cssSelector(".js-filter-list-brands .filter__list-lbl"));
        screenDiagonal = driver.findElements(By.cssSelector(".filter-nout_diag .filter__list-lbl"));
        processorSeries = driver.findElements(By.cssSelector(".filter-proc_seriya .filter__list-lbl"));
        modelCPU = driver.findElements(By.cssSelector(".filter-model_cpu li span.filter__list-lbl"));
        amountOfRAM = driver.findElements(By.cssSelector(".filter-ozy_objem_f li span.filter__list-lbl"));
        typeDrive = driver.findElements(By.cssSelector(".filter-hdd_tip .filter__list-lbl"));
        graphicsCardSeries = driver.findElements(By.cssSelector(".filter-filtr_descret_video .filter__list-lbl"));
        storageVolume = driver.findElements(By.cssSelector(".filter-hdd_objem .filter__list-lbl"));
        numberOfCores = driver.findElements(By.cssSelector(".filter-note_yader .filter__list-lbl"));
        maxSizeRAM = driver.findElements(By.cssSelector(".filter-max_objem_ozu .filter__list-lbl"));
    }

    public ConfigFilter choosePriceRange(String forPrice, String toPrice) {
        priceFrom.sendKeys(forPrice);
        priceTo.sendKeys(toPrice);
        return this;
    }

    public ConfigFilter clickBrand(String brandText) {

        for (int i = 0; i < brand.size(); i++) {
            if (brand.get(i).getText().trim().equals(brandText)) {
                brand.get(i).click();
                break;
            }
        }
        return this;
    }

    public ConfigFilter clickScreenDiagonal(String sizeDiagonal) {
        for (int i = 0; i < screenDiagonal.size(); i++) {
            if (screenDiagonal.get(i).getText().trim().equals(sizeDiagonal)) {
                screenDiagonal.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickProcessorSeries(String cpuSerial) {
        for (int i = 0; i < processorSeries.size(); i++) {
            if (processorSeries.get(i).getText().trim().equals(cpuSerial)) {
                processorSeries.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickModelCPU(String modelCPUText) {
        for (int i = 0; i < modelCPU.size(); i++) {
            if (modelCPU.get(i).getText().trim().equals(modelCPUText)) {
                modelCPU.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickAmountOfRAM(String ram) {
        for (int i = 0; i < amountOfRAM.size(); i++) {
            if (amountOfRAM.get(i).getText().trim().equals(ram)) {
                amountOfRAM.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickTypeDrive(String hardDisk) {
        for (int i = 0; i < typeDrive.size(); i++) {
            if (typeDrive.get(i).getText().trim().equals(hardDisk)) {
                typeDrive.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickGraphicsCardSeries(String cardSeries) {
        for (int i = 0; i < graphicsCardSeries.size(); i++) {
            if (graphicsCardSeries.get(i).getText().trim().equals(cardSeries)) {
                graphicsCardSeries.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickStorageVolume(String sizeVolume) {
        for (int i = 0; i < storageVolume.size(); i++) {
            if (storageVolume.get(i).getText().trim().equals(sizeVolume)) {
                storageVolume.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickNumberOfCores(String numberCore) {
        for (int i = 0; i < numberOfCores.size(); i++) {
            if (numberOfCores.get(i).getText().trim().equals(numberCore)) {
                numberOfCores.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickMaxSizeRAM(String maxSize) {
        for (int i = 0; i < maxSizeRAM.size(); i++) {
            if (maxSizeRAM.get(i).getText().trim().equals(maxSize)) {
                maxSizeRAM.get(i).click();
            }
        }
        return this;
    }

    public ProductPage clickShowResult() {
        WebElement showResult;
        showResult = driver.findElement(By.cssSelector(".price-filter__submit-link"));
        if (showResult.isDisplayed())
            showResult.click();
        return new ProductPage(driver);
    }
}
