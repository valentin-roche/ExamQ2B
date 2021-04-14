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

    // Pour simuler les changements de prix on fait un aléatoire sur les 3 possibilités
    // (augmentation, pas de changement ou baisse)
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

    // Afin de garantir que les derniéres données affichées sont les plus récentes, on passe par le presenter pour
    // appeler le raffrachissement de la vue
    public void setPrice(float price) {
        this.price = price;
        // Si on n'a pas de presenter, la maj de la vue n'est pas appelée
        if (ap != null) {
            ap.updateView();
        }
    }

    public String getName() {
        return name;
    }

    // La logique de cette fonction est analogue à celle de setPrice
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
