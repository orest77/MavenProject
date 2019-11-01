package Pages.ProductPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class ConfigFilter {
    protected WebDriver driver;

    private List<WebElement> price;
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
        price = driver.findElements(By.cssSelector(".price-filter__row input"));
        brand = driver.findElements(By.xpath("//li[@data-filter-code='brand']//li[@class='filter__list-item ']"));
        screenDiagonal = driver.findElements(By.xpath("//li[@data-filter-code='nout_diag']//li[@class='filter__list-item ']"));
        processorSeries = driver.findElements(By.xpath("//li[@data-filter-code='proc_seriya']//li[@class='filter__list-item ']"));
        modelCPU = driver.findElements(By.xpath("//li[@data-filter-code='model_cpu']//li[@class='filter__list-item ']"));
        amountOfRAM = driver.findElements(By.xpath("//li[@data-filter-code='ozy_objem_f']//li[@class='filter__list-item ']"));
        typeDrive = driver.findElements(By.xpath("//li[@data-filter-code='hdd_tip']//li[@class='filter__list-item ']"));
        graphicsCardSeries = driver.findElements(By.xpath("//li[@data-filter-code='filtr_descret_video']//li[@class='filter__list-item ']"));
        storageVolume = driver.findElements(By.xpath("//li[@data-filter-code='hdd_objem']//li[@class='filter__list-item ']"));
        numberOfCores = driver.findElements(By.xpath("//li[@data-filter-code='oper_sistem']//li[@class='filter__list-item ']"));
        maxSizeRAM = driver.findElements(By.xpath("//li[@data-filter-code='max_objem_ozu']//li[@class='filter__list-item ']"));
    }

    public ConfigFilter choosePrice(String forPrice, String toPrice) {
        price.get(0).sendKeys(forPrice);
        price.get(1).sendKeys(toPrice);
        return this;
    }

    public ConfigFilter clickBrand(String brandText) {
        for (int i = 0; i < brand.size(); i++) {
            if (brand.get(i).getText().contains(brandText)) {
                brand.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickScreenDiagonal(String sizeDiagonal) {
        for (int i = 0; i < screenDiagonal.size(); i++) {
            if (screenDiagonal.get(i).getText().contains(sizeDiagonal)) {
                screenDiagonal.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickProcessorSeries(String cpuSerial) {
        for (int i = 0; i < processorSeries.size(); i++) {
            if (processorSeries.get(i).getText().contains(cpuSerial)) {
                processorSeries.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickModelCPU(String modelCPUText) {
        for (int i = 0; i < modelCPU.size(); i++) {
            if (modelCPU.get(i).getText().contains(modelCPUText)) {
                modelCPU.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickAmountOfRAM(String ram) {
        for (int i = 0; i < amountOfRAM.size(); i++) {
            if (amountOfRAM.get(i).getText().contains(ram)) {
                amountOfRAM.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickTypeDrive(String hardDisk) {
        for (int i = 0; i < typeDrive.size(); i++) {
            if (typeDrive.get(i).getText().contains(hardDisk)) {
                typeDrive.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickGraphicsCardSeries(String cardSeries) {
        for (int i = 0; i < graphicsCardSeries.size(); i++) {
            if (graphicsCardSeries.get(i).getText().contains(cardSeries)) {
                graphicsCardSeries.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickStorageVolume(String sizeVolume) {
        for (int i = 0; i < storageVolume.size(); i++) {
            if (storageVolume.get(i).getText().contains(sizeVolume)) {
                storageVolume.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickNumberOfCores(String numberCore) {
        for (int i = 0; i < numberOfCores.size(); i++) {
            if (numberOfCores.get(i).getText().contains(numberCore)) {
                numberOfCores.get(i).click();
            }
        }
        return this;
    }

    public ConfigFilter clickMaxSizeRAM(String maxSize) {
        for (int i = 0; i < maxSizeRAM.size(); i++) {
            if (maxSizeRAM.get(i).getText().contains(maxSize)) {
                maxSizeRAM.get(i).click();
            }
        }
        return this;
    }

   public ConfigFilter clickShowResult() {
       WebElement showResult;showResult = driver.findElement(By.cssSelector(".price-filter__submit-link"));
       showResult.click();
       return this;
    }
}
