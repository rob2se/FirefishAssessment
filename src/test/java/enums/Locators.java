package enums;

/**
 * Enum representing the different types of locators that can be used for finding web elements.
 * This enum provides a central place for managing locator types supported by the application.
 * Author: Rob Thomson
 * Date: 06/06/2024
 */
public enum Locators {
    /**
     * Locator strategy using the class name of the element.
     */
    ClassName,

    /**
     * Locator strategy using the CSS selector of the element.
     */
    CssSelector,

    /**
     * Locator strategy using the ID of the element.
     */
    Id,

    /**
     * Locator strategy using the link text of the element.
     */
    LinkText,

    /**
     * Locator strategy using the name attribute of the element.
     */
    Name,

    /**
     * Locator strategy using a partial match on the link text of the element.
     */
    PartialLink,

    /**
     * Locator strategy using the tag name of the element.
     */
    TagName,

    /**
     * Locator strategy using the XPath of the element.
     */
    Xpath
}