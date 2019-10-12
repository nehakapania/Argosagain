package page_object;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends DriverManager {

    public String searchrdCategories;


    @FindBy(css = ".search-title__term")
    private WebElement searchedHeader;

    public String searchedItemHeader() {
        return searchedHeader.getText();
    }


    //This method will select a price of "£15-£20" products

    @FindBy(css = ".ac-facet__filters--default .ac-facet__label--default")
    private List<WebElement> priceFilters;

    public void selectPriceFilter(String customerSelectedPrice) {
        for (WebElement priceFilter : priceFilters) {
            if (priceFilter.getText().equalsIgnoreCase(customerSelectedPrice)) {
                sleep(3000);
                priceFilter.click();
                break;
            }
        }
    }

    // By this method we can verify that all the shown products according to the filtered price choice accordingly
    @FindBy(css = ".ac-product-price__amount")
    private List<WebElement> selectedPriceProducts;

    public List<Double> selectedProducts() {
        sleep(3000);
        List<Double> collectedPriceList = new ArrayList<>();
        for (WebElement selectedPriceProduct : selectedPriceProducts) {
            // System.out.println(selectedPriceProduct);
            String priceInString = selectedPriceProduct.getText().replaceAll("£", "");
            double priceInDouble = Double.parseDouble(priceInString);
            collectedPriceList.add(priceInDouble);
        }
        return collectedPriceList;
    }

    //With this code we can able to select a category of the Product

    @FindBy(css = ".ac-facet__filter--category .ac-facet__filter-text")
    private List<WebElement> selectProductCategory;

    public String selectACategoryOfProduct(String customerSelectedCategory)
    {
        for (WebElement selectCategory : selectProductCategory) {
            if (selectCategory.getText().equalsIgnoreCase(customerSelectedCategory))
            {
                searchrdCategories = customerSelectedCategory;
                System.out.println(searchrdCategories);
                selectCategory.click();
                break;
            }
        }
        return customerSelectedCategory;
    }

    // With this method u can select any rating from filter
    @FindBy(css = ".ac-facet__filters--rating .ac-facet__label--rating")
    private List<WebElement> productsRatings;

    public void selectARating(String customerSelectedRating) {
        for (WebElement productRating : productsRatings) {
            if (productRating.getText().equalsIgnoreCase(customerSelectedRating)) {
                privacyfooter();
                sleep(3000);
                productRating.click();
                break;
            }
        }
    }

    @FindBy(css = ".Ratingsstyles__Wrapper-sc-8mrsjy-0.kuyIjz")
    private List<WebElement> ratingsOfProduct;

    public List<Double> getRatingOfProducts() {
        List<Double> collectedRatings = new ArrayList<>();
        for (WebElement ratingOfProduct : ratingsOfProduct) {
            //collectedRatings.add(ratingOfProduct.getAttribute("data-star-rating"));
            String collectedRatingInString = ratingOfProduct.getAttribute("data-star-rating");

            // System.out.println(collectedRatingInString);
            double collectedRatingInDouble = Double.parseDouble(collectedRatingInString);
            collectedRatings.add(collectedRatingInDouble);
        }
        return collectedRatings;
    }

    @FindBy(css = ".sort-select")
    private WebElement sorting;

    public void selectSorting(String customerSelectedSorting) {
        Select select = new Select(sorting);
        select.selectByVisibleText(customerSelectedSorting);
    }

}