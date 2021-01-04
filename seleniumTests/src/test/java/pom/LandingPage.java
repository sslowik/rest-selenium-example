package pom;

import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(css = "a[title='About us']")
	@CacheLookup
	private WebElement aboutUs;

	@FindBy(css = "a[title='Best sellers']")
	@CacheLookup
	private WebElement bestSellers;

	@FindBy(css = "a[title='Blouses']")
	@CacheLookup
	private WebElement blouses1;

	@FindBy(css = "a[title='Match your favorites blouses with the right accessories for the perfect look.']")
	@CacheLookup
	private WebElement blouses2;

	@FindBy(css = "a[title='View my shopping cart']")
	@CacheLookup
	private WebElement cart0ProductProductsEmpty;

	@FindBy(css = "#block_top_menu ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows li:nth-of-type(1) ul.submenu-container.clearfix.first-in-line-xs li:nth-of-type(2) ul li:nth-of-type(1) a")
	@CacheLookup
	private WebElement casualDresses1;

	@FindBy(css = "#block_top_menu ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows li:nth-of-type(2) ul.submenu-container.clearfix.first-in-line-xs li:nth-of-type(1) a")
	@CacheLookup
	private WebElement casualDresses2;

	@FindBy(css = "#footer div.row section:nth-of-type(2) div.category_footer.toggle-footer div.list ul.tree.dynamized li.last ul li:nth-of-type(2) ul li:nth-of-type(1) a")
	@CacheLookup
	private WebElement casualDresses3;

	@FindBy(id = "button_order_cart")
	@CacheLookup
	private WebElement checkOut;

	@FindBy(css = "a[title='Contact Us']")
	@CacheLookup
	private WebElement contactUs1;

	@FindBy(css = "a[title='Contact us']")
	@CacheLookup
	private WebElement contactUs2;

	@FindBy(css = "#block_top_menu ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows li:nth-of-type(1) ul.submenu-container.clearfix.first-in-line-xs li:nth-of-type(2) a.sf-with-ul")
	@CacheLookup
	private WebElement dresses1;

	@FindBy(css = "#block_top_menu ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows li:nth-of-type(2) a.sf-with-ul")
	@CacheLookup
	private WebElement dresses2;

	@FindBy(css = "#footer div.row section:nth-of-type(2) div.category_footer.toggle-footer div.list ul.tree.dynamized li.last ul li:nth-of-type(2) a")
	@CacheLookup
	private WebElement dresses3;

	@FindBy(css = "a._blank")
	@CacheLookup
	private WebElement ecommerceSoftwareByPrestashop;

	@FindBy(id = "newsletter-input")
	@CacheLookup
	private WebElement ecommerceSoftwareByPrestashop2014;

	@FindBy(css = "#block_top_menu ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows li:nth-of-type(1) ul.submenu-container.clearfix.first-in-line-xs li:nth-of-type(2) ul li:nth-of-type(2) a")
	@CacheLookup
	private WebElement eveningDresses1;

	@FindBy(css = "#block_top_menu ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows li:nth-of-type(2) ul.submenu-container.clearfix.first-in-line-xs li:nth-of-type(2) a")
	@CacheLookup
	private WebElement eveningDresses2;

	@FindBy(css = "a[title='Browse our different dresses to choose the perfect dress for an unforgettable evening!']")
	@CacheLookup
	private WebElement eveningDresses3;

	@FindBy(css = "a[title='Manage my customer account']")
	@CacheLookup
	private WebElement myAccount;

	@FindBy(css = "a[title='My addresses']")
	@CacheLookup
	private WebElement myAddresses;

	@FindBy(css = "a[title='My credit slips']")
	@CacheLookup
	private WebElement myCreditSlips;

	@FindBy(css = "a[title='My orders']")
	@CacheLookup
	private WebElement myOrders;

	@FindBy(css = "a[title='Manage my personal information']")
	@CacheLookup
	private WebElement myPersonalInfo;

	@FindBy(css = "a[title='New products']")
	@CacheLookup
	private WebElement newProducts;

	@FindBy(name = "submitNewsletter")
	@CacheLookup
	private WebElement ok;

	@FindBy(css = "a[title='Our stores']")
	@CacheLookup
	private WebElement ourStores;

	private final String pageLoadedText = "Your shopping cart is empty";

	private final String pageUrl = "/index.php?controller=order";

	@FindBy(css = "a.btn.btn-default.button.button-medium")
	@CacheLookup
	private WebElement proceedToCheckout;

	@FindBy(id = "search_query_top")
	@CacheLookup
	private WebElement productSuccessfullyAddedToYourShopping;

	@FindBy(name = "submit_search")
	@CacheLookup
	private WebElement search;

	@FindBy(css = "a.login")
	@CacheLookup
	private WebElement signIn;

	@FindBy(css = "a[title='Sitemap']")
	@CacheLookup
	private WebElement sitemap;

	@FindBy(css = "a[title='Specials']")
	@CacheLookup
	private WebElement specials;

	@FindBy(css = "#block_top_menu ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows li:nth-of-type(1) ul.submenu-container.clearfix.first-in-line-xs li:nth-of-type(2) ul li:nth-of-type(3) a")
	@CacheLookup
	private WebElement summerDresses1;

	@FindBy(css = "#block_top_menu ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows li:nth-of-type(2) ul.submenu-container.clearfix.first-in-line-xs li:nth-of-type(3) a")
	@CacheLookup
	private WebElement summerDresses2;

	@FindBy(css = "a[title='Short dress, long dress, silk dress, printed dress, you will find the perfect dress for summer.']")
	@CacheLookup
	private WebElement summerDresses3;

	@FindBy(css = "a[href='mailto:%73%75%70%70%6f%72%74@%73%65%6c%65%6e%69%75%6d%66%72%61%6d%65%77%6f%72%6b.%63%6f%6d']")
	@CacheLookup
	private WebElement supportseleniumframeworkCom;

	@FindBy(css = "a[title='Terms and conditions of use']")
	@CacheLookup
	private WebElement termsAndConditionsOfUse;

	@FindBy(css = "a[title='Tops']")
	@CacheLookup
	private WebElement tops1;

	@FindBy(css = "#footer div.row section:nth-of-type(2) div.category_footer.toggle-footer div.list ul.tree.dynamized li.last ul li:nth-of-type(1) a")
	@CacheLookup
	private WebElement tops2;

	@FindBy(css = "#block_top_menu ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows li:nth-of-type(1) ul.submenu-container.clearfix.first-in-line-xs li:nth-of-type(1) ul li:nth-of-type(1) a")
	@CacheLookup
	private WebElement tshirts1;

	@FindBy(css = "#block_top_menu ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows li:nth-of-type(3) a")
	@CacheLookup
	private WebElement tshirts2;

	@FindBy(css = "#footer div.row section:nth-of-type(2) div.category_footer.toggle-footer div.list ul.tree.dynamized li.last ul li:nth-of-type(1) ul li:nth-of-type(1) a")
	@CacheLookup
	private WebElement tshirts3;

	@FindBy(css = "a[href='https://twitter.com/seleniumfrmwrk']")
	@CacheLookup
	private WebElement twitter;

	@FindBy(css = "a[title='Women']")
	@CacheLookup
	private WebElement women1;

	@FindBy(css = "#footer div.row section:nth-of-type(2) div.category_footer.toggle-footer div.list ul.tree.dynamized li.last a")
	@CacheLookup
	private WebElement women2;

	@FindBy(css = "a[href='https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA']")
	@CacheLookup
	private WebElement youtube;

	public LandingPage() {
	}

	public LandingPage(WebDriver driver) {
		this();
		this.driver = driver;
	}

	public LandingPage(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public LandingPage(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on About Us Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickAboutUsLink() {
		aboutUs.click();
		return this;
	}

	/**
	 * Click on Best Sellers Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickBestSellersLink() {
		bestSellers.click();
		return this;
	}

	/**
	 * Click on Blouses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickBlouses1Link() {
		blouses1.click();
		return this;
	}

	/**
	 * Click on Blouses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickBlouses2Link() {
		blouses2.click();
		return this;
	}

	/**
	 * Click on Cart 0 Product Products Empty Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickCart0ProductProductsEmptyLink() {
		cart0ProductProductsEmpty.click();
		return this;
	}

	/**
	 * Click on Casual Dresses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickCasualDresses1Link() {
		casualDresses1.click();
		return this;
	}

	/**
	 * Click on Casual Dresses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickCasualDresses2Link() {
		casualDresses2.click();
		return this;
	}

	/**
	 * Click on Casual Dresses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickCasualDresses3Link() {
		casualDresses3.click();
		return this;
	}

	/**
	 * Click on Check Out Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickCheckOutLink() {
		checkOut.click();
		return this;
	}

	/**
	 * Click on Contact Us Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickContactUs1Link() {
		contactUs1.click();
		return this;
	}

	/**
	 * Click on Contact Us Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickContactUs2Link() {
		contactUs2.click();
		return this;
	}

	/**
	 * Click on Dresses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickDresses1Link() {
		dresses1.click();
		return this;
	}

	/**
	 * Click on Dresses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickDresses2Link() {
		dresses2.click();
		return this;
	}

	/**
	 * Click on Dresses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickDresses3Link() {
		dresses3.click();
		return this;
	}

	/**
	 * Click on Ecommerce Software By Prestashop Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickEcommerceSoftwareByPrestashopLink() {
		ecommerceSoftwareByPrestashop.click();
		return this;
	}

	/**
	 * Click on Evening Dresses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickEveningDresses1Link() {
		eveningDresses1.click();
		return this;
	}

	/**
	 * Click on Evening Dresses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickEveningDresses2Link() {
		eveningDresses2.click();
		return this;
	}

	/**
	 * Click on Evening Dresses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickEveningDresses3Link() {
		eveningDresses3.click();
		return this;
	}

	/**
	 * Click on My Account Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickMyAccountLink() {
		myAccount.click();
		return this;
	}

	/**
	 * Click on My Addresses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickMyAddressesLink() {
		myAddresses.click();
		return this;
	}

	/**
	 * Click on My Credit Slips Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickMyCreditSlipsLink() {
		myCreditSlips.click();
		return this;
	}

	/**
	 * Click on My Orders Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickMyOrdersLink() {
		myOrders.click();
		return this;
	}

	/**
	 * Click on My Personal Info Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickMyPersonalInfoLink() {
		myPersonalInfo.click();
		return this;
	}

	/**
	 * Click on New Products Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickNewProductsLink() {
		newProducts.click();
		return this;
	}

	/**
	 * Click on Ok Button.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickOkButton() {
		ok.click();
		return this;
	}

	/**
	 * Click on Our Stores Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickOurStoresLink() {
		ourStores.click();
		return this;
	}

	/**
	 * Click on Proceed To Checkout Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickProceedToCheckoutLink() {
		proceedToCheckout.click();
		return this;
	}

	/**
	 * Click on Search Button.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickSearchButton() {
		search.click();
		return this;
	}

	/**
	 * Click on Sign In Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickSignInLink() {
		signIn.click();
		return this;
	}

	/**
	 * Click on Sitemap Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickSitemapLink() {
		sitemap.click();
		return this;
	}

	/**
	 * Click on Specials Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickSpecialsLink() {
		specials.click();
		return this;
	}

	/**
	 * Click on Summer Dresses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickSummerDresses1Link() {
		summerDresses1.click();
		return this;
	}

	/**
	 * Click on Summer Dresses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickSummerDresses2Link() {
		summerDresses2.click();
		return this;
	}

	/**
	 * Click on Summer Dresses Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickSummerDresses3Link() {
		summerDresses3.click();
		return this;
	}

	/**
	 * Click on Supportseleniumframework.com Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickSupportseleniumframeworkComLink() {
		supportseleniumframeworkCom.click();
		return this;
	}

	/**
	 * Click on Terms And Conditions Of Use Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickTermsAndConditionsOfUseLink() {
		termsAndConditionsOfUse.click();
		return this;
	}

	/**
	 * Click on Tops Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickTops1Link() {
		tops1.click();
		return this;
	}

	/**
	 * Click on Tops Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickTops2Link() {
		tops2.click();
		return this;
	}

	/**
	 * Click on Tshirts Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickTshirts1Link() {
		tshirts1.click();
		return this;
	}

	/**
	 * Click on Tshirts Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickTshirts2Link() {
		tshirts2.click();
		return this;
	}

	/**
	 * Click on Tshirts Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickTshirts3Link() {
		tshirts3.click();
		return this;
	}

	/**
	 * Click on Twitter Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickTwitterLink() {
		twitter.click();
		return this;
	}

	/**
	 * Click on Women Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickWomen1Link() {
		women1.click();
		return this;
	}

	/**
	 * Click on Women Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickWomen2Link() {
		women2.click();
		return this;
	}

	/**
	 * Click on Youtube Link.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage clickYoutubeLink() {
		youtube.click();
		return this;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage fill() {
		setProductSuccessfullyAddedToYourShoppingTextField();
		setEcommerceSoftwareByPrestashopTextField2014();
		return this;
	}

	/**
	 * Fill every fields in the page and submit it to target page.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage fillAndSubmit() {
		fill();
		return submit();
	}

	/**
	 * Set default value to 2014 Ecommerce Software By Prestashop Text field.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage setEcommerceSoftwareByPrestashopTextField2014() {
		return setEcommerceSoftwareByPrestashopTextField2014(data.get("ECOMMERCE_SOFTWARE_BY_PRESTASHOP_2014"));
	}

	/**
	 * Set value to 2014 Ecommerce Software By Prestashop Text field.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage setEcommerceSoftwareByPrestashopTextField2014(String ecommerceSoftwareByPrestashopValue2014) {
		ecommerceSoftwareByPrestashop2014.sendKeys(ecommerceSoftwareByPrestashopValue2014);
		return this;
	}

	/**
	 * Set default value to Product Successfully Added To Your Shopping Cart Text field.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage setProductSuccessfullyAddedToYourShoppingTextField() {
		return setProductSuccessfullyAddedToYourShoppingTextField(data.get("PRODUCT_SUCCESSFULLY_ADDED_TO_YOUR_SHOPPING"));
	}

	/**
	 * Set value to Product Successfully Added To Your Shopping Cart Text field.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage setProductSuccessfullyAddedToYourShoppingTextField(String productSuccessfullyAddedToYourShoppingValue) {
		productSuccessfullyAddedToYourShopping.sendKeys(productSuccessfullyAddedToYourShoppingValue);
		return this;
	}

	/**
	 * Submit the form to target page.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage submit() {
		clickSearchButton();
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage verifyPageLoaded() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getPageSource().contains(pageLoadedText);
			}
		});
		return this;
	}

	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 * @return the Shop class instance.
	 */
	public LandingPage verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
