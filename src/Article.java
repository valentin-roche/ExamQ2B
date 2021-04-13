import java.util.Random;

public class Article {
    private float price;
    private String name;
    private Random r;
    private ArticlePresenter ap;

    public Article(float p, String n) {
        setPrice(p);
        setName(n);
        r = new Random();
    }

    public void iterate() {
        switch(r.nextInt(3)) {
            // Price decrease
            case 0:
                setPrice(getPrice() * r.nextFloat());
                break;
            // Price increase
            case 2:
                setPrice(getPrice() * (1 + r.nextFloat()));
                break;
            default:
                break;
        }
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
        if (ap != null) {
            ap.updateView();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (ap != null) {
            ap.updateView();
        }
    }

    public ArticlePresenter getAp() {
        return ap;
    }

    public void setAp(ArticlePresenter ap) {
        this.ap = ap;
    }
}
