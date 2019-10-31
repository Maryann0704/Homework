package by.pvt.product.add;

import by.pvt.pojo.ProductCatalogItem;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductCatalogItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductCatalogItem.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductCatalogItem item = (ProductCatalogItem) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemName", "field.required",
                "Item name must not be empty");

        if (item.getItemName().length()<3) {
            errors.rejectValue("itemName", "itemName.length",
                    "name must be longer than 3 characters");
        }
        if (item.getPrice() == null || item.getPrice() <= 0) {
            errors.rejectValue("price", "price.value",
                    "price must be greater than zero");
        }
    }
}
