package Logic.Rules;

import Logic.Models.Article;
import Logic.Models.Shoppinglist;

//public class WeekdayRestriction extends BasicRule {
//    public WeekdayRestriction(Shoppinglist shoppingList, Article article, int amount) {
//        super(shoppingList, article, amount);
//    }
//    private void setOptions()
//    {
//        this.options = [
//                'available_on_days' => 'array',
//        ];
//    }
//
//    private void apply()
//    {
//        if (!in_array(this.shoppingList.date.format('l'), this.settings['available_on_days'])) {
//            this.amount = 0;
//            this.applied = true;
//        }
//    }
//
//    public int priority()
//    {
//        return 10;
//    }
//
//    public String getReason()
//    {
//        if (this.applied) {
//            return 'Not available on this day';
//        }
//
//        return null;
//    }
}
