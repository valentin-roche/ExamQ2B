import java.util.ArrayList;

public class ApplicationController {
    public static void main(String[] args) {

        ArrayList<Article> model = new ArrayList<>();
        ArticleView view = new ArticleView();

        ArticlePresenter ac = new ArticlePresenter(model, view);
    }
}
