import java.util.ArrayList;
import java.util.Random;

public class ArticlePresenter {
    private ArrayList<Article> model;
    private ArticleView view;
    private int lastArticleNumber;

    public ArticlePresenter(ArrayList<Article> m, ArticleView a) {
        model = m;
        view = a;
        // On donne ici l'accés au presenter à la vue
        view.setAp(this);

        lastArticleNumber = 0;

        // Initialisation d'un minimum d'articles pour simplifier les tests
        for (int i = 0; i < 5; i++) {
            addArticle();
        }

        // Lancement de la fonction gérant les fonctions utilisateur
        view.awaitInput();
    }

    // Ajout d'un article aléatoire
    public void addArticle() {
        Random r = new Random();
        Article art = new Article(r.nextFloat() + r.nextInt(), "Article " + lastArticleNumber);
        art.setAp(this);
        model.add(art);
        lastArticleNumber++;
    }

    // Iteration de tous les articles
    public void iterate() {
        for (Article art: model) {
            art.iterate();
        }
    }

    //Méthode de raffraichissement de la vue
    public void updateView() {
        view.displayArticles(model);
    }
}
