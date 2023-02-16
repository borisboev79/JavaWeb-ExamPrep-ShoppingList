package examprep.shoppinglist.domain.enums;

import lombok.Getter;

@Getter
public enum CategoryType {
    FOOD("Food"),
    DRINK("Drink"),
    HOUSEHOLD("Household"),
    OTHER("Other");

   public final String label;

   CategoryType(String label){
       this.label = label;
   }



   // Food, Drink, Household, Other
}
