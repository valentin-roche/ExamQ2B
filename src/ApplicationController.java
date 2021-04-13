import java.util.ArrayList;

public class ApplicationController {
    public static void main(String[] args) {
        System.out.println("Pas d'articles à surveiller pour le moment ;p");

        ArrayList<Article> model = new ArrayList<>();
        ArticleView view = new ArticleView();

        ArticlePresenter ac = new ArticlePresenter(model, view);
        //ac.start();
    }
}
