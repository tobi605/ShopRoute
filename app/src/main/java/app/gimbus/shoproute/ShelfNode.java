package app.gimbus.shoproute;

import java.util.List;

/**
 * Created by tobi6 on 07.02.2018.
 */

public class ShelfNode {
    private Shelf shelf;
    private List<ShelfNode> neighbours;
    private List<Product> products;

    public ShelfNode(Shelf shelf ,List<ShelfNode> neighbours) {
        this.shelf = shelf;
    }

    public void addNeighbour(ShelfNode node){
        neighbours.add(node);
    }

    public void addProducts(List<Product> list){
        products = list;
    }

    public List<Product> getProducts(){
        return products;
    }

    public List<ShelfNode> getNeighbours(){
        return neighbours;
    }

    public boolean contains(Product product){
        return products.contains(product);
    }
}
