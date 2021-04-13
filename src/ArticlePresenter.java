import java.util.ArrayList;
import java.util.Random;

public class ArticlePresenter {
    private ArrayList<Article> model;
    private ArticleView view;
    private int lastArticleNumber;

    public ArticlePresenter(ArrayList<Article> m, ArticleView a) {
        model = m;
        view = a;
        view.setAp(this);
        lastArticleNumber = 0;
        for (int i = 0; i < 5; i++) {
            addArticle();
        }

        view.awaitInput();
    }

    public void addArticle() {
        Random r = new Random();
        Article art = new Article(r.nextFloat() + r.nextInt(), "Article " + lastArticleNumber);
        art.setAp(this);
        model.add(art);
        lastArticleNumber++;
    }

    public void iterate() {
        for (Article art: model) {
            art.iterate();
        }
    }

    public void updateView() {
        view.displayArticles(model);
    }
}
