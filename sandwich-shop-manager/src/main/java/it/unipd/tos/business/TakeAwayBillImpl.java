////////////////////////////////////////////////////////////////////
// [SIMONE] [FRANCONETTI] [1143567]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillImpl implements TakeAwayBill {
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        if (itemsOrdered.size() > 30) {
            throw new TakeAwayBillException("Non si possono ordinare oltre 30 MenuItem");
        }

        double totalPrice = 0;
        int paniniCount = 0;
        int paniniFrittiPrice = 0;
        double minorPricePanini=0;


        
        for (int i = 0; i < itemsOrdered.size(); i++) {
            totalPrice = totalPrice + itemsOrdered.get(i).getPrice();

            if (itemsOrdered.get(i).getType() == MenuItem.itemType.PANINI) {
                paniniCount++;
            }
            
            // calcolo il prezzo totale dei panini+fritti
            if (itemsOrdered.get(i).getType() == MenuItem.itemType.FRITTI
                    || itemsOrdered.get(i).getType() == MenuItem.itemType.PANINI) {
                paniniFrittiPrice += itemsOrdered.get(i).getPrice();
            }
        }
        
        // se c'è almeno un panino nella lista, prendo il prezzo del panino con 
        // => prezzo minimo e lo salvo dentro minorPricePanini
        // se non c'è => minorPricePanini = 0
        if(itemsOrdered
                .stream()
                .filter(x -> x.getType() == MenuItem.itemType.PANINI)
                .count() > 0 ) {
            minorPricePanini = itemsOrdered
                .stream()
                .filter(x -> x.getType() == MenuItem.itemType.PANINI)
                .mapToDouble(x -> x.getPrice()).min().getAsDouble();                
        }

        if (paniniCount > 5) {
            totalPrice -= minorPricePanini / 2;
        }

        if (paniniFrittiPrice > 50) {
            totalPrice = 0.90 * totalPrice;
        }

        if (totalPrice < 10) {
            totalPrice = totalPrice + 0.5;
        }

        return totalPrice;
    }
}
