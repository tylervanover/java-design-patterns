package dev.vanovertech.pluralsight.creational.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

/**
 * A class that tests the {@link WebsiteFactory}
 */
public class WebsiteFactoryTest {

    @Test
    @DisplayName("Website Factory.getWebsite(SHOP) returns a Shop Website")
    public void test_getWebsiteShop_returnsShopConcreteClass() {
        Website website = WebsiteFactory.getWebsite(WebsiteType.SHOP);
        assertThat(website, instanceOf(Shop.class));
    }

    @Test
    @DisplayName("Website Factory.getWebsite(BLOG) returns a Blog Website")
    public void test_getWebsiteBlog_returnsShopConcreteClass() {
        Website website = WebsiteFactory.getWebsite(WebsiteType.BLOG);
        assertThat(website, instanceOf(Blog.class));
    }
}
