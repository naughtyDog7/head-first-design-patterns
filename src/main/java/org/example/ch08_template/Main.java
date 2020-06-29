package org.example.ch08_template;

import lombok.extern.slf4j.Slf4j;
import org.example.ch08_template.beverage.CaffeineBeverage;
import org.example.ch08_template.beverage.Tea;

@Slf4j
public class Main {

    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();
    }


}
