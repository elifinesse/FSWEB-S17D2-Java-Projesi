package com.workintech.s17d2.model;

import com.workintech.s17d2.tax.Taxable;

public class DeveloperFactory {

    public static Developer createDev(Developer developer, Taxable taxable){
        Developer newDev = null;
        if(developer.getExperience().name().equalsIgnoreCase("junior")){
            newDev = new JuniorDeveloper(developer.getId(), developer.getName(),
                    developer.getSalary() - (developer.getSalary() * taxable.getSimpleTaxRate()),
                    developer.getExperience());
        } else if(developer.getExperience().name().equalsIgnoreCase("mid")){
            newDev = new MidDeveloper(developer.getId(), developer.getName(),
                    developer.getSalary() - (developer.getSalary() * taxable.getMiddleTaxRate()),
                    developer.getExperience());
        } else if(developer.getExperience().name().equalsIgnoreCase("senior")){
            newDev = new MidDeveloper(developer.getId(), developer.getName(),
                    developer.getSalary() - (developer.getSalary() * taxable.getUpperTaxRate()),
                    developer.getExperience());
        }
        return newDev;
    }
}
